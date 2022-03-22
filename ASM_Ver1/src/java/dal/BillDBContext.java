package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Bill;
import model.StoreProduct;

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
                + "           ,[description]\n"
                + "           ,[pid])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        PreparedStatement stm = null;

        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, bill.getItime());
            stm.setString(2, bill.getSeller());
            stm.setString(3, bill.getPhone());
            stm.setDate(4, bill.getIdate());
            stm.setDouble(5, bill.getTotal());
            stm.setString(6, bill.getDescription());
            stm.setString(7, bill.getPid());
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
            String sql1 = "Select * from Bill order by idate desc";
            PreparedStatement stm = connection.prepareStatement(sql1);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setBid(rs.getInt("bid"));
                bill.setItime(rs.getString("itime"));
                bill.setSeller(rs.getString("seller"));
                bill.setPhone(rs.getString("phone"));
                bill.setIdate(rs.getDate("idate"));
                bill.setTotal(rs.getDouble("total"));
                bill.setDescription(rs.getString("description"));
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
                bill.setBid(rs.getInt("bid"));
                bill.setItime(rs.getString("itime"));
                bill.setSeller(rs.getString("seller"));
                bill.setPhone(rs.getString("phone"));
                bill.setIdate(rs.getDate("idate"));
                bill.setTotal(rs.getDouble("total"));
                bill.setDescription(rs.getString("description"));
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

    public Bill getBillByID(int bid) {
        try {
            //select query
            String spl1 = "SELECT * FROM Bill \n"
                    + "WHERE bid = ?";
            PreparedStatement stm = connection.prepareStatement(spl1);
            stm.setInt(1, bid);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Bill bill = new Bill();
                bill.setBid(rs.getInt("bid"));
                bill.setItime(rs.getString("itime"));
                bill.setSeller(rs.getString("seller"));
                bill.setPhone(rs.getString("phone"));
                bill.setIdate(rs.getDate("idate"));
                bill.setTotal(rs.getDouble("total"));
                bill.setDescription(rs.getString("description"));
                bill.setPid(rs.getString("pid"));
                return bill;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void UpdateBill(Bill bill) {
        String sql1 = "UPDATE [dbo].[Bill]\n"
                + "   SET [itime] = ?\n"
                + "      ,[seller] = ?\n"
                + "      ,[phone] = ?\n"
                + "      ,[idate] = ?\n"
                + "      ,[total] = ?\n"
                + "      ,[description] = ?\n"
                + "      ,[pid] = ?\n"
                + " WHERE bid = ?";

        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql1);
            stm.setString(1, bill.getItime());
            stm.setString(2, bill.getSeller());
            stm.setString(3, bill.getPhone());
            stm.setDate(4, bill.getIdate());
            stm.setDouble(5, bill.getTotal());
            stm.setString(6, bill.getDescription());
            stm.setString(7, bill.getPid());
            stm.setInt(8, bill.getBid());
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

}
