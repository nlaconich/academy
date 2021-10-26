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
import py.com.ci.academy.product.boundary.ProductManager;
import py.com.ci.academy.product.entities.Product;
import py.com.ci.academy.sale.boundary.SaleManager;
import py.com.ci.academy.sale.entities.Sale;

/**
 *
 * @author jmendez
 */
@Named("saleBean")
@SessionScoped
public class SaleBean implements Serializable {
    @Inject
    CustomerBean customerBean;
    
    private SaleManager saleManager;
    private Sale sale;
    private List<Sale> saleList;
   

    @PostConstruct
    public void init() {

        saleManager = new SaleManager();
        saleList = saleManager.getAll();
        sale = new Sale();
        /*
        MarkManager mm = new MarkManager();
        listadoMarca =mm.getAll();
        */        
    }
        
    private void logSale() {
        if (saleList != null && !saleList.isEmpty()) {
            System.out.println("SaleBean  - init > " + saleList.size());
        } else {
            System.out.println("SaleBean  - init > no result found");
        }
    }

    public List<Sale> getSaleList() {
        return saleManager.getAll();
    }

    public void setSaleList(List<Sale> saleList) {
        this.saleList = saleList;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
   
    public void updateSale() {
        saleManager.updateSale(sale);
        init();
    }
    
    public void deleteSale(){
       saleManager.deleteById(sale);
       init();
    }

    
    public void agregarSale() {
        
        saleManager.add(sale);
        init();
        

    }
        
        public void onSelect(SelectEvent event) {
                this.sale = (Sale) event.getObject();

        FacesMessage msg = new FacesMessage("Sale Selected id", String.valueOf(sale.getIdSale()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("SaleBean > Seleccionar Fila > " + this.sale);

    
    }

}
