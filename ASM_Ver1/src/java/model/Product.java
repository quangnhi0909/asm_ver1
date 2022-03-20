package model;

import java.sql.Date;

/**
 *
 * @author Hoang Quang
 */
public class Product {
    private int id;
    private int itime;
    private Date idate;
    private String seller,phone;
    private String pName;
    private double price;
    private int quantity;

    public Product() {
    }

    public Product(int id, int itime, Date idate, String seller, String phone, String pName, double price, int quantity) {
        this.id = id;
        this.itime = itime;
        this.idate = idate;
        this.seller = seller;
        this.phone = phone;
        this.pName = pName;
        this.price = price;
        this.quantity = quantity;
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

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
