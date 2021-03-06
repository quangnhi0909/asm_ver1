package controler.function;

import dal.StoreProductDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author Hoang Quang
 */
public class DeleteProductInStore extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account adminSession = (Account) session.getAttribute("account");
        //check user login or not
        if (adminSession != null) {
            //get id user want to delete
            String raw_sid = request.getParameter("sid");
            int id = Integer.parseInt(raw_sid);
            //delete into store product
            StoreProductDBContext storeProductDBContext = new StoreProductDBContext();
            storeProductDBContext.deleteProduct(id);
            response.sendRedirect("../product/store");
        } else {
            response.sendRedirect("../login");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
