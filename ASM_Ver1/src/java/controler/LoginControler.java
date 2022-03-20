package controler;

import dal.AccountDBContext;
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
public class LoginControler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("view/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AccountDBContext adminDBContext = new AccountDBContext();
        Account account = adminDBContext.getAccounts(username, password);
        if (account == null) {
            response.getWriter().println("Login Flase!!");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("account", account);
            response.sendRedirect("home");
        }
    }
}
