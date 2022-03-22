package controler.function;

import dal.BillDBContext;
import dal.StoreProductDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Bill;
import model.StoreProduct;

/**
 *
 * @author Hoang Quang
 */
public class EditBillControler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account adminSession = (Account) session.getAttribute("account");
        //check user login or not
        if (adminSession != null) {
            //get id user want to edit
            String raw_bid = request.getParameter("bid");
            int bid = Integer.parseInt(raw_bid);
            //lấy bill người dùng chọn để edit
            BillDBContext billDBContext = new BillDBContext();
            Bill bill = billDBContext.getBillByID(bid);
            request.setAttribute("bill", bill);
            request.getRequestDispatcher("../viewfunction/editbill.jsp").forward(request, response);
        } else {
            response.sendRedirect("../login");
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        // get value
        String raw_bid = request.getParameter("bid");
        String raw_pid = request.getParameter("pid");
        String raw_itime = request.getParameter("itime");
        String raw_idate = request.getParameter("idate");
        String raw_seller = request.getParameter("seller");
        String raw_phone = request.getParameter("phone");
        String raw_total = request.getParameter("total");
        String raw_desB = request.getParameter("desB");
        //validate value
        int bid = Integer.parseInt(raw_bid);
        String pid = raw_pid;
        String itime = raw_itime;
        Date idate = Date.valueOf(raw_idate);
        String seller = raw_seller;
        String phone = raw_phone;
        Double total = Double.parseDouble(raw_total);
        String desB = raw_desB;
        
        //Update vào bill
        Bill bill = new Bill();
        bill.setBid(bid);
        bill.setItime(itime);
        bill.setIdate(idate);
        bill.setSeller(seller);
        bill.setPhone(phone);
        bill.setIdate(idate);
        bill.setTotal(total);
        bill.setPid(pid);
        bill.setDescription(desB);
        BillDBContext billDBContext = new BillDBContext();
        billDBContext.UpdateBill(bill);
        response.sendRedirect("../product/bill");
        
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
