package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Hoang Quang
 */
public class Bill {
    private int bid;
    private String itime;
    private String seller;
    private String phone;
    private Date idate;
    private double total;
    private String description;
    private String pid;

    public Bill() {
    }

    public Bill(int bid, String itime, String seller, String phone, Date idate, double total, String description, String pid) {
        this.bid = bid;
        this.itime = itime;
        this.seller = seller;
        this.phone = phone;
        this.idate = idate;
        this.total = total;
        this.description = description;
        this.pid = pid;
    }

   

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getItime() {
        return itime;
    }

    public void setItime(String itime) {
        this.itime = itime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    public String getDateFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyy");
        return simpleDateFormat.format(idate);
    }
    
}
