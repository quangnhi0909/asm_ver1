package model;

import java.sql.Date;

/**
 *
 * @author Hoang Quang
 */
public class StoreProduct {
    private int sid;
    private String pname;
    private int quantity;
    private Date idate;

    public StoreProduct() {
    }

    public StoreProduct(int sid, String pname, int quantity, Date idate) {
        this.sid = sid;
        this.pname = pname;
        this.quantity = quantity;
        this.idate = idate;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
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
