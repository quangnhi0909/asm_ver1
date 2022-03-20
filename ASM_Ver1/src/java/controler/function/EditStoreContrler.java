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
import model.StoreProduct;

/**
 *
 * @author Hoang Quang
 */
public class EditStoreContrler extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String raw_id = request.getParameter("id");
        int id = Integer.parseInt(raw_id);
        StoreProductDBContext storeDBContext = new StoreProductDBContext();
        StoreProduct store = storeDBContext.getProductByID(id);

        request.setAttribute("store", store);
        request.getRequestDispatcher("../viewfunction/editstore.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String raw_id = request.getParameter("id");
        String raw_pname = request.getParameter("productName");
        String raw_quantity = request.getParameter("quantity");
        String raw_date = request.getParameter("idate");
        
        int id = Integer.parseInt(raw_id);
        String pname = raw_pname;
        int quantity = Integer.parseInt(raw_quantity);
        Date idate = Date.valueOf(raw_date);
        
        StoreProduct store = new StoreProduct();
        store.setId(id);
        store.setProductName(pname);
        store.setQuantity(quantity);
        store.setIdate(idate);
        
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
