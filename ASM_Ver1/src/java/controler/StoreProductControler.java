package controler;

import dal.StoreProductDBContext;
import java.io.IOException;
import java.io.PrintWriter;
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
public class StoreProductControler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account adminSession = (Account) session.getAttribute("account");
        //check uesr login or not
        if (adminSession != null) {
            String page = request.getParameter("page");
            if (page == null || page.trim().length() == 0) {
                page = "1";
            }
            int pagesize = 10;
            int pageindex = Integer.parseInt(page);
            //get store product with page
            StoreProductDBContext storeDBContext = new StoreProductDBContext();
            ArrayList<StoreProduct> listStoreProduct = storeDBContext.getStoreByPage(pageindex, pagesize);
            int numofrecords = storeDBContext.count();
            int totalpage = (numofrecords % pagesize == 0) ? (numofrecords / pagesize)
                    : (numofrecords / pagesize) + 1;
            request.setAttribute("totalpage", totalpage);
            request.setAttribute("pagesize", pagesize);
            request.setAttribute("pageindex", pageindex);
            request.setAttribute("listStoreProduct", listStoreProduct);
            request.getRequestDispatcher("../view/store.jsp").forward(request, response);
        } else {
            response.sendRedirect("../login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
