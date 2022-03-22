package model;

import java.sql.Date;

/**
 *
 * @author Hoang Quang
 */
public class Product {
    private String pid;
    private String itime;
    private String pname;
    private double price;
    private int quantity;
    private String description;
    public Product() {
    }

    public Product(String pid, String itime, String pname, double price, int quantity, String description) {
        this.pid = pid;
        this.itime = itime;
        this.pname = pname;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getItime() {
        return itime;
    }

    public void setItime(String itime) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
}
