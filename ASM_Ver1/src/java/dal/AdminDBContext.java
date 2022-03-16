package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Admin;

/**
 *
 * @author Hoang Quang
 */
public class AdminDBContext extends DBContext{
     public Admin getAccounts(String username, String password) {
        try {
            String spl1 = "select username, password from Admin\n"
                    + "WHERE username = ? and password = ?";

            PreparedStatement stm = connection.prepareStatement(spl1);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Admin account = new Admin();
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
