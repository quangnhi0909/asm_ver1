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

    public ArrayList<Bill> getAllBill() {
        ArrayList<Bill> listBills = new ArrayList<>();
        try {
            String sql1 = "SELECT importTimes, dateImport , SUM(total) as total FROM Bill\n"
                    + "GROUP BY importTimes,dateImport";
            PreparedStatement stm = connection.prepareStatement(sql1);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getInt("billID"));
                bill.setItime(rs.getInt("importTimes"));
                bill.setIdate(rs.getDate("dateImport"));
                bill.setTotal(rs.getDouble("total"));
                bill.setProductID(rs.getInt("productID"));
                listBills.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBills;

    }
}
