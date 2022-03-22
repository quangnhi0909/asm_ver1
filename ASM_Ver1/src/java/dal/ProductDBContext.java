package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

/**
 *
 * @author Hoang Quang
 */
public class ProductDBContext extends DBContext {

    public void insertProduct(Product product) {
        String sql = "INSERT INTO [dbo].[Product]\n"
                + "           ([pid]\n"
                + "           ,[itime]\n"
                + "           ,[pname]\n"
                + "           ,[price]\n"
                + "           ,[quantity]\n"
                + "           ,[descriptionP])\n"
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
            stm.setString(1, product.getPid());
            stm.setString(2, product.getItime());
            stm.setString(3, product.getPname());
            stm.setDouble(4, product.getPrice());
            stm.setInt(5, product.getQuantity());
            stm.setString(6, product.getDescription());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public ArrayList<Product> getProductWithPage(int pageindex, int pagesize) {
        ArrayList<Product> listProducts = new ArrayList<>();
        try {
            String sql = "SELECT * FROM (SELECT *,ROW_NUMBER() OVER (ORDER BY itime desc) as row_index from Product) pro\n"
                    + "WHERE row_index >= (? -1)* ? +1 AND row_index <= ? * ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pageindex);
            stm.setInt(2, pagesize);
            stm.setInt(3, pageindex);
            stm.setInt(4, pagesize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setPid(rs.getString("pid"));
                p.setItime(rs.getString("itime"));
                p.setPname(rs.getString("pname"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setDescription(rs.getString("descriptionP"));
                listProducts.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProducts;
    }

    public int count() {
        try {
            String sql = "SELECT count(*) as Total FROM Product";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

}
