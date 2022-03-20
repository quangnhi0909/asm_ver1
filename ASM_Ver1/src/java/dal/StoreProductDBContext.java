package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.StoreProduct;

/**
 *
 * @author Hoang Quang
 */
public class StoreProductDBContext extends DBContext {

    public ArrayList<StoreProduct> getAllStoreProduct() {
        ArrayList<StoreProduct> listProducts = new ArrayList<>();
        try {
            String sql1 = "SELECT * FROM StoreProduct\n"
                    + "ORDER BY importDate DESC";
            PreparedStatement stm = connection.prepareStatement(sql1);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                StoreProduct s = new StoreProduct();
                s.setId(rs.getInt("storeID"));
                s.setProductName(rs.getString("productName"));
                s.setQuantity(rs.getInt("quantity"));
                s.setIdate(rs.getDate("importDate"));
                listProducts.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StoreProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProducts;

    }

    public StoreProduct getProductByID(int id) {
        try {
            //select query
            String spl1 = "SELECT * FROM StoreProduct \n"
                    + " WHERE storeID = ?";
            PreparedStatement stm = connection.prepareStatement(spl1);
            stm.setInt(1, id);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                StoreProduct store = new StoreProduct();
                store.setId(rs.getInt("storeID"));
                store.setProductName(rs.getString("productName"));
                store.setQuantity(rs.getInt("quantity"));
                store.setIdate(rs.getDate("importDate"));
                return store;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StoreProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateStoreProduct(StoreProduct store) {
        String sql1 = "UPDATE [dbo].[StoreProduct]\n"
                + "   SET [productName] = ?\n"
                + "      ,[quantity] = ?\n"
                + "      ,[importDate] = ?\n"
                + "WHERE [storeID] = ?";

        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql1);
            stm.setString(1, store.getProductName());
            stm.setInt(2, store.getQuantity());
            stm.setDate(3, store.getIdate());
            stm.setInt(4, store.getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StoreProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StoreProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StoreProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void insertStoreProduct(StoreProduct storeProduct) {
        String sql = "INSERT INTO [dbo].[StoreProduct]\n"
                + "           ([productName]\n"
                + "           ,[quantity]\n"
                + "           ,[importDate])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?)";
        PreparedStatement stm = null;

        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, storeProduct.getProductName());
            stm.setInt(2, storeProduct.getQuantity());
            stm.setDate(3, storeProduct.getIdate());
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

    public void deleteProduct(int id) {
        String spl1 = "DELETE FROM [dbo].[StoreProduct]\n"
                + "      WHERE storeID = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(spl1);
            stm.setInt(1, id);
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

    public ArrayList<StoreProduct> getStoreByPage(int pageindex, int pagesize) {
        ArrayList<StoreProduct> listStoreProducts = new ArrayList<>();
        try {
            String sql = "SELECT * FROM (SELECT *,ROW_NUMBER() OVER (ORDER BY importDate desc) as row_index FROM StoreProduct) storeproduct\n"
                    + "WHERE row_index >= (? -1)* ? +1 AND row_index <= ? * ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pageindex);
            stm.setInt(2, pagesize);
            stm.setInt(3, pageindex);
            stm.setInt(4, pagesize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
               StoreProduct s = new StoreProduct();
                s.setId(rs.getInt("storeID"));
                s.setProductName(rs.getString("productName"));
                s.setQuantity(rs.getInt("quantity"));
                s.setIdate(rs.getDate("importDate"));
                listStoreProducts.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StoreProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listStoreProducts;
    }

    public int count() {
        try {
            String sql = "SELECT count(*) as Total FROM StoreProduct";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StoreProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
