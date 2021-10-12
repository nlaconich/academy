/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ci.academy.detailsale.entities;
import  py.com.ci.academy.sale.entities.Sale;
import  py.com.ci.academy.product.entities.Product;
/**
 *
 * @author jmendez
 */
public class DetailSale {
    private int idDetailSale;
    private Sale sale;
    private Product  product;
  
    private int amount_product;
    private double price_historical;

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount_product() {
        return amount_product;
    }

    public void setAmount_product(int amount_product) {
        this.amount_product = amount_product;
    }

    public double getPrice_historical() {
        return price_historical;
    }

    public void setPrice_historical(double price_historical) {
        this.price_historical = price_historical;
    }

    public int getIdDetailSale() {
        return idDetailSale;
    }

    public void setIdDetailSale(int idDetailSale) {
        this.idDetailSale = idDetailSale;
    }
    
    public double subtotal (){
      return (this.getAmount_product()*this.getPrice_historical());
    }

    @Override
    public String toString() {
        return "DetailSale{" + "idDetailSale=" + idDetailSale + ", sale=" + sale + ", product=" + product + ", amount_product=" + amount_product + ", price_historical=" + price_historical + '}';
    }

  
}
