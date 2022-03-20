package controler.function;

import dal.ProductDBContext;
import dal.StoreProductDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Product;
import model.StoreProduct;

/**
 *
 * @author Hoang Quang
 */
public class AddProductControler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account adminSession = (Account) session.getAttribute("account");
//        if (adminSession != null) {
        request.getRequestDispatcher("../viewfunction/addproduct.jsp").forward(request, response);
//        } else {
//            response.getWriter().println("You need to login!!");
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String raw_itime = request.getParameter("itime");
        String raw_idate = request.getParameter("idate");
        String raw_seller = request.getParameter("seller");
        String raw_phone = request.getParameter("phone");
        String raw_pname = request.getParameter("pname");
        String raw_pprice = request.getParameter("pprice");
        String raw_quantity = request.getParameter("quantity");
        
        //validate value
        int itime = Integer.parseInt(raw_itime);
        Date idate = Date.valueOf(raw_idate);
        String seller = raw_seller;
        String phone = raw_phone;
        String pname = raw_pname;
        Double pprice = Double.parseDouble(raw_pprice);
        int quantity = Integer.parseInt(raw_quantity);
        
        Product product = new Product();
        product.setItime(itime);
        product.setIdate(idate);
        product.setSeller(seller);
        product.setPhone(phone);
        product.setpName(pname);
        product.setPrice(pprice);
        product.setQuantity(quantity);
        
        ProductDBContext productDBContext = new ProductDBContext();
        productDBContext.insertProduct(product);
        //insert vào bill
        //insert vào store product
        // insert vào store product cả ngày cùng với tên sản phẩm để có thể edit và delete
        StoreProduct storeProduct = new StoreProduct();
        storeProduct.setProductName(pname);
        storeProduct.setQuantity(quantity);
        
        storeProduct.setIdate(idate);
        StoreProductDBContext storeProductDBContext = new StoreProductDBContext();
        storeProductDBContext.insertStoreProduct(storeProduct);
        response.getWriter().println("Add Successfully!");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
