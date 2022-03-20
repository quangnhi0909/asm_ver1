package model;

import java.sql.Date;

/**
 *
 * @author Hoang Quang
 */
public class Product {
    private String pid;
    private int itime;
    private String pname;
    private double price;
    private int quantity;

    public Product() {
    }

    public Product(String pid, int itime, String pname, double price, int quantity) {
        this.pid = pid;
        this.itime = itime;
        this.pname = pname;
        this.price = price;
        this.quantity = quantity;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getItime() {
        return itime;
    }

    public void setItime(int itime) {
        this.itime = itime;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
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
