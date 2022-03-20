package model;

import java.sql.Date;

/**
 *
 * @author Hoang Quang
 */
public class Bill {
    private int id;
    private int itime;
    private Date idate;
    private double total;
    private int productID;

    public Bill() {
    }

    public Bill(int id, int itime, Date idate, double total, int productID) {
        this.id = id;
        this.itime = itime;
        this.idate = idate;
        this.total = total;
        this.productID = productID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItime() {
        return itime;
    }

    public void setItime(int itime) {
        this.itime = itime;
    }

    public Date getIdate() {
        return idate;
    }

    public void setIdate(Date idate) {
        this.idate = idate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    
    
}
