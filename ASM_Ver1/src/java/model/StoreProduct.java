package model;

import java.sql.Date;

/**
 *
 * @author Hoang Quang
 */
public class StoreProduct {
    private int id;
    private String productName;
    private int quantity;
    private Date idate;

    public StoreProduct() {
    }

    public StoreProduct(int id, String productName, int quantity, Date idate) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.idate = idate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getIdate() {
        return idate;
    }

    public void setIdate(Date idate) {
        this.idate = idate;
    }
    

    
}
