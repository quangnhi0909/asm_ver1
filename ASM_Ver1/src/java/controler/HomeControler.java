package controler;

import dal.StoreDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Admin;
import model.Store;

/**
 *
 * @author Hoang Quang
 */
public class HomeControler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Admin adminSession = (Admin) session.getAttribute("account");
//        if (adminSession != null) {
            StoreDBContext storeDBContext = new StoreDBContext();
            ArrayList<Store> listProduct = storeDBContext.getAllProduct();
            request.setAttribute("listProduct", listProduct);
            request.getRequestDispatcher("view/home.jsp").forward(request, response);
//        } else {
//            response.getWriter().println("You need to login!!");
//        }
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
