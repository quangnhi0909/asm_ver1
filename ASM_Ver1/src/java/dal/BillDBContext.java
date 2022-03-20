package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Bill;

/**
 *
 * @author Hoang Quang
 */
public class BillDBContext extends DBContext {

    public void insertBill(Bill bill) {
        String sql = "INSERT INTO [dbo].[Bill]\n"
                + "           ([itime]\n"
                + "           ,[seller]\n"
                + "           ,[phone]\n"
                + "           ,[idate]\n"
                + "           ,[total]\n"
                + "           ,[pid])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        PreparedStatement stm = null;

        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, bill.getItime());
            stm.setString(2, bill.getSeller());
            stm.setString(3, bill.getPhone());
            stm.setDate(4, bill.getIdate());
            stm.setDouble(5, bill.getTotal());
            stm.setString(6, bill.getPid());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public ArrayList<Bill> getBill() {
        ArrayList<Bill> listBills = new ArrayList<>();
        try {
            String sql1 = "SELECT itime , idate , SUM(total) as total FROM Bill GROUP BY itime,idate";
            PreparedStatement stm = connection.prepareStatement(sql1);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setItime(rs.getInt("itime"));
                bill.setIdate(rs.getDate("idate"));
                bill.setTotal(rs.getDouble("total"));
                listBills.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBills;

    }

    public ArrayList<Bill> getAllBillWithPage(int pageindex, int pagesize) {
        ArrayList<Bill> listBills = new ArrayList<>();
        try {
            String sql = "SELECT * FROM (SELECT *,ROW_NUMBER() OVER (ORDER BY idate desc) as row_index FROM Bill) bill\n"
                    + "WHERE row_index >= (? -1)* ? +1 AND row_index <= ? * ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pageindex);
            stm.setInt(2, pagesize);
            stm.setInt(3, pageindex);
            stm.setInt(4, pagesize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setBid(rs.getInt("billID"));
                bill.setItime(rs.getInt("itime"));
                bill.setIdate(rs.getDate("idate"));
                bill.setTotal(rs.getDouble("total"));
                bill.setPid(rs.getString("pid"));
                listBills.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBills;
    }

    public int count() {
        try {
            String sql = "SELECT count(*) as Total FROM Bill";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
