package model;

import java.sql.Date;

/**
 *
 * @author Hoang Quang
 */
public class Bill {
    private int id;
    private int importTimes;
    private Date dateImport;
    private int total;
    private int productID;

    public Bill() {
    }

    public Bill(int id, int importTimes, Date dateImport, int total, int productID) {
        this.id = id;
        this.importTimes = importTimes;
        this.dateImport = dateImport;
        this.total = total;
        this.productID = productID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImportTimes() {
        return importTimes;
    }

    public void setImportTimes(int importTimes) {
        this.importTimes = importTimes;
    }

    public Date getDateImport() {
        return dateImport;
    }

    public void setDateImport(Date dateImport) {
        this.dateImport = dateImport;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
    
    
    
    
}
