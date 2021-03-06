package controler.function;

import dal.BillDBContext;
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
import model.Bill;
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
        if (adminSession != null) {
        request.getRequestDispatcher("../viewfunction/addproduct.jsp").forward(request, response);
        } else {
            response.sendRedirect("../login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String raw_pid = request.getParameter("pid");
        String raw_itime = request.getParameter("itime");
        String raw_idate = request.getParameter("idate");
        String raw_seller = request.getParameter("seller");
        String raw_phone = request.getParameter("phone");
        String raw_pname = request.getParameter("pname");
        String raw_pprice = request.getParameter("pprice");
        String raw_quantity = request.getParameter("quantity");
        String raw_desP = request.getParameter("desP");
        String raw_desB = request.getParameter("desB");
        
        //validate value
        String pid = raw_pid;
        String itime = raw_itime;
        Date idate = Date.valueOf(raw_idate);
        String seller = raw_seller;
        String phone = raw_phone;
        String pname = raw_pname;
        Double pprice = Double.parseDouble(raw_pprice);
        int quantity = Integer.parseInt(raw_quantity);
        String desP = raw_desP;
        String desB = raw_desB;
        
        //insert v??o product
        Product product = new Product();
        product.setPid(pid);
        product.setItime(itime);
        product.setPname(pname);
        product.setPrice(pprice);
        product.setQuantity(quantity);
        product.setDescription(desP);
        ProductDBContext productDBContext = new ProductDBContext();
        productDBContext.insertProduct(product);
        
        //insert v??o bill
        Bill bill = new Bill();
        bill.setItime(itime);
        bill.setIdate(idate);
        bill.setSeller(seller);
        bill.setPhone(phone);
        bill.setIdate(idate);
        bill.setTotal(pprice*quantity);
        bill.setPid(pid);
        bill.setDescription(desB);
        BillDBContext billDBContext = new BillDBContext();
        billDBContext.insertBill(bill);
        

        //insert v??o store product
        // insert v??o store product c??? ng??y c??ng v???i t??n s???n ph???m ????? c?? th??? edit v?? delete
        StoreProduct storeProduct = new StoreProduct();
        storeProduct.setPname(pname);
        storeProduct.setQuantity(quantity);
        storeProduct.setIdate(idate);
        storeProduct.setDescription(desP);

        StoreProductDBContext storeProductDBContext = new StoreProductDBContext();
        storeProductDBContext.insertStoreProduct(storeProduct);
        
        response.getWriter().println("???? Nh???p Th??ng Tin Th??nh C??ng!");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
