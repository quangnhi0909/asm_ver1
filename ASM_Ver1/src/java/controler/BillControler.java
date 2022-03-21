package controler;

import dal.BillDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Bill;

/**
 *
 * @author Hoang Quang
 */
public class BillControler extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account adminSession = (Account) session.getAttribute("account");
        if (adminSession != null) {
      
            String page = request.getParameter("page");
            if (page == null || page.trim().length() == 0) {
                page = "1";
            }
            int pagesize = 10;
            int pageindex = Integer.parseInt(page);
            BillDBContext billDBContext = new BillDBContext();
            ArrayList<Bill> listBills = billDBContext.getAllBillWithPage(pageindex, pagesize);
            int numofrecords = billDBContext.count();
            int totalpage = (numofrecords % pagesize == 0) ? (numofrecords / pagesize)
                    : (numofrecords / pagesize) + 1;
            request.setAttribute("totalpage", totalpage);
            request.setAttribute("pagesize", pagesize);
            request.setAttribute("pageindex", pageindex);
            request.setAttribute("listBills", listBills);
            request.getRequestDispatcher("../view/bill.jsp").forward(request, response);
        } else {
            response.sendRedirect("../login");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
