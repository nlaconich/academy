/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ci.academy.presentation.web.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import py.com.ci.academy.product.boundary.MarkManager;
import py.com.ci.academy.product.boundary.ProductManager;
import py.com.ci.academy.product.entities.Mark;
import py.com.ci.academy.product.entities.Product;

/**
 *
 * @author jmendez
 */

@Named("productBean")
@SessionScoped
public class ProductBean implements Serializable {
    
    @Inject
    MarkBean markBean;
    
    private ProductManager productManager;
    private Product product;
    private List<Product> productList;
   // private List <Mark> listadoMarca;

    @PostConstruct
    public void init() {

        productManager = new ProductManager();
        productList = productManager.getAll();
        product = new Product();
        /*
        MarkManager mm = new MarkManager();
        listadoMarca =mm.getAll();
        */        
    }
        
    private void logProduct() {
        if (productList != null && !productList.isEmpty()) {
            System.out.println("ProductBean  - init > " + productList.size());
        } else {
            System.out.println("ProductBean  - init > no result found");
        }
    }

    public List<Product> getProductList() {
        return productManager.getAll();
    }

    public void setProductList(List<Product> markList) {
        this.productList = productList;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
   
    public void updateProduct() {
        productManager.updateProduct(product);
        init();
    }
    
    public void deleteProduct(){
       productManager.deleteById(product);
       init();
    }

    
    public void agregarProduct() {
        
        productManager.addProduct(product);
        init();
        

    }
        
        public void onSelect(SelectEvent event) {
                this.product = (Product) event.getObject();

        FacesMessage msg = new FacesMessage("Product Selected id", String.valueOf(product.getIdProduct()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("ProductBean > Seleccionar Fila > " + this.product);

    
    }

}
/*
<p:column headerText="Product ID">
                                    <h:outputText value="#{product.idProduct}" />
                                </p:column>


 <p:column headerText="Mark">
                                    <h:outputText value="#{product.mark.id_mark}" />
                                </p:column>



add product

<p:outputLabel for="mark" value="Mark"/>


 <p:inputText id="mark" value="#{productBean.product.mark.id_mark}"/> 




update product
  <p:outputLabel value="Mark" for="mark" />

<p:inputText id="mark" required="true" value="#{productBean.product.mark.id_mark}"  style="text-transform: none" />
*/