/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ci.academy.sale.entities;

import java.sql.Date;
import py.com.ci.academy.customer.entities.Customer;

/**
 *
 * @author jmendez
 */
public class Sale {
    private int idSale;
   // private int idCustomer;
    private Customer customer;
    private Date date_sale;
    private String descripcion;
    private int totalSale;
    

    
 
    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDate_sale() {
        return date_sale;
    }

    public void setDate_sale(Date date_sale) {
        this.date_sale = date_sale;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    } 

    public int getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(int totalSale) {
        this.totalSale = totalSale;
    }

    @Override
    public String toString() {
        return "Sale{" + "idSale=" + idSale + ", customer=" + customer + ", date_sale=" + date_sale + ", descripcion=" + descripcion + ", totalSale=" + totalSale + '}';
    }

   
    
    
}
