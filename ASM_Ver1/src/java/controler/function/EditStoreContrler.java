package controler.function;

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
import model.StoreProduct;

/**
 *
 * @author Hoang Quang
 */
public class EditStoreContrler extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account adminSession = (Account) session.getAttribute("account");
        if (adminSession != null) {
        String raw_sid = request.getParameter("sid");
        int sid = Integer.parseInt(raw_sid);
        StoreProductDBContext storeDBContext = new StoreProductDBContext();
        StoreProduct store = storeDBContext.getProductByID(sid);

        request.setAttribute("store", store);
        request.getRequestDispatcher("../viewfunction/editstore.jsp").forward(request, response);
        } else {
            response.sendRedirect("../login");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String raw_sid = request.getParameter("sid");
        String raw_pname = request.getParameter("pname");
        String raw_quantity = request.getParameter("quantity");
        String raw_date = request.getParameter("idate");
        
        int id = Integer.parseInt(raw_sid);
        String pname = raw_pname;
        int quantity = Integer.parseInt(raw_quantity);
        Date idate = Date.valueOf(raw_date);
        
        StoreProduct store = new StoreProduct();
        store.setSid(id);
        store.setPname(pname);
        store.setQuantity(quantity);
        store.setIdate(idate);;
        
        StoreProductDBContext storeDBContext = new StoreProductDBContext();
        storeDBContext.updateStoreProduct(store);
        response.sendRedirect("../product/store");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
