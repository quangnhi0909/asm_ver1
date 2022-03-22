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

    public ArrayList<StoreProduct> getStoreByPage(int pageindex, int pagesize) {
        ArrayList<StoreProduct> listStoreProducts = new ArrayList<>();
        try {
            String sql = "SELECT * FROM (SELECT *,ROW_NUMBER() OVER (ORDER BY idate desc) as row_index FROM StoreProduct) storeproduct\n"
                    + "WHERE row_index >= (? -1)* ? +1 AND row_index <= ? * ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pageindex);
            stm.setInt(2, pagesize);
            stm.setInt(3, pageindex);
            stm.setInt(4, pagesize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                StoreProduct s = new StoreProduct();
                s.setSid(rs.getInt("sid"));
                s.setPname(rs.getString("pname"));
                s.setIdate(rs.getDate("idate"));
                s.setQuantity(rs.getInt("quantity"));
                s.setDescription(rs.getString("descriptionP"));
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

    public void insertStoreProduct(StoreProduct storeProduct) {
        String sql = "INSERT INTO [dbo].[StoreProduct]\n"
                + "           ([pname]\n"
                + "           ,[idate]\n"
                + "           ,[quantity]\n"
                + "           ,[descriptionP])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        PreparedStatement stm = null;

        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, storeProduct.getPname());
            stm.setDate(2, storeProduct.getIdate());
            stm.setInt(3, storeProduct.getQuantity());
            stm.setString(4, storeProduct.getDescription());
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

    public StoreProduct getProductByID(int sid) {
        try {
            //select query
            String spl1 = "SELECT * FROM StoreProduct \n"
                    + "WHERE sid = ?";
            PreparedStatement stm = connection.prepareStatement(spl1);
            stm.setInt(1, sid);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                StoreProduct store = new StoreProduct();
                store.setSid(rs.getInt("sid"));
                store.setPname(rs.getString("pname"));
                store.setIdate(rs.getDate("idate"));
                store.setQuantity(rs.getInt("quantity"));
                store.setDescription(rs.getString("descriptionP"));
                return store;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StoreProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateStoreProduct(StoreProduct store) {
        String sql1 = "UPDATE [dbo].[StoreProduct]\n"
                + "   SET [pname] = ?\n"
                + "      ,[idate] = ?\n"
                + "      ,[quantity] = ?\n"
                + "      ,[descriptionP] = ?\n"
                + " WHERE [sid] = ?";

        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql1);
            stm.setString(1, store.getPname());
            stm.setDate(2, store.getIdate());
            stm.setInt(3, store.getQuantity());
            stm.setString(4, store.getDescription());
            stm.setInt(5, store.getSid());
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

    public void deleteProduct(int sid) {
        String spl1 = "DELETE FROM [dbo].[StoreProduct]\n"
                + "WHERE sid = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(spl1);
            stm.setInt(1, sid);
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
}
