package model;

import java.sql.Date;

/**
 *
 * @author Hoang Quang
 */
public class Bill {
    private int bid;
    private int itime;
    private String seller;
    private String phone;
    private Date idate;
    private double total;
    private String pid;

    public Bill() {
    }

    public Bill(int bid, int itime, String seller, String phone, Date idate, double total, String pid) {
        this.bid = bid;
        this.itime = itime;
        this.seller = seller;
        this.phone = phone;
        this.idate = idate;
        this.total = total;
        this.pid = pid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getItime() {
        return itime;
    }

    public void setItime(int itime) {
        this.itime = itime;
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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
    
}
