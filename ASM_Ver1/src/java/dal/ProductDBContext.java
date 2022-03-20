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
                + "           ([importID]\n"
                + "           ,[importDate]\n"
                + "           ,[seller]\n"
                + "           ,[phone]\n"
                + "           ,[nameProduct]\n"
                + "           ,[price]\n"
                + "           ,[quantity])\n"
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
            stm.setInt(1, product.getItime());
            stm.setDate(2, product.getIdate());
            stm.setString(3, product.getSeller());
            stm.setString(4, product.getPhone());
            stm.setString(5, product.getpName());
            stm.setDouble(6, product.getPrice());
            stm.setInt(7, product.getQuantity());
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

    public ArrayList<Product> getListAllProduct() {
        ArrayList<Product> listProducts = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product\n"
                    + "ORDER BY importDate DESC";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("productID"));
                p.setItime(rs.getInt("importID"));
                p.setIdate(rs.getDate("importDate"));
                p.setSeller(rs.getString("seller"));
                p.setPhone(rs.getString("phone"));
                p.setpName(rs.getString("nameProduct"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));
                listProducts.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProducts;
    }
    
    public ArrayList<Product> getProductWithPage(int pageindex, int pagesize) {
        ArrayList<Product> listProducts = new ArrayList<>();
        try {
            String sql = "SELECT * FROM (SELECT *,ROW_NUMBER() OVER (ORDER BY importDate desc) as row_index FROM product) pro\n"
                    + "WHERE row_index >= (? -1)* ? +1 AND row_index <= ? * ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pageindex);
            stm.setInt(2, pagesize);
            stm.setInt(3, pageindex);
            stm.setInt(4, pagesize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("productID"));
                p.setItime(rs.getInt("importID"));
                p.setIdate(rs.getDate("importDate"));
                p.setSeller(rs.getString("seller"));
                p.setPhone(rs.getString("phone"));
                p.setpName(rs.getString("nameProduct"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));
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
