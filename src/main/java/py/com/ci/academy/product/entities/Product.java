/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ci.academy.product.entities;

/**NewClass
 *
 * @author jmendez
 */
public class Product {
    
    private int idProduct;
    private Double price;
    private Mark mark;
    private String productdescription;

   
    

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public String getProductdescription() {
        return productdescription;
    }

    public void setProductdescription(String productdescription) {
        this.productdescription = productdescription;
    }

    @Override
    public String toString() {
        return "Product{" + "idProduct=" + idProduct + ", price=" + price + ", mark=" + mark + ", productdescription=" + productdescription + '}';
    }



  
   
    
    
}
