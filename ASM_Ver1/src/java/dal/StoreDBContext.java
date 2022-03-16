package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Store;

/**
 *
 * @author Hoang Quang
 */
public class StoreDBContext extends DBContext{
    public ArrayList<Store> getAllProduct(){
        ArrayList<Store> listProducts = new ArrayList<>();
        try {
            String sql1 = "SELECT * FROM StoreProduct";
            PreparedStatement stm = connection.prepareStatement(sql1);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Store s = new Store();
                s.setProductName(rs.getString("productName"));
                s.setQuantity(rs.getInt("quantity"));
                listProducts.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StoreDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProducts;

    }
}
