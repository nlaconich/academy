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
import py.com.ci.academy.detailsale.boundary.DetailSaleManager;
import py.com.ci.academy.detailsale.entities.DetailSale;
import py.com.ci.academy.product.boundary.ProductManager;
import py.com.ci.academy.product.entities.Product;

/**
 *
 * @author jmendez
 */
@Named("detailsaleBean")
@SessionScoped

public class DetailSaleBean implements Serializable{
     
    @Inject
    ProductBean productBean;
    @Inject
    SaleBean saleBean;
    
    private DetailSaleManager detailsaleManager;
    private DetailSale detailsale;
    private List<DetailSale> detailsaleList;
   // private List <Mark> listadoMarca;

    @PostConstruct
    public void init() {

        detailsaleManager = new DetailSaleManager();
        detailsaleList = detailsaleManager.getAll();
        detailsale = new  DetailSale();
       
    }
    private void logDetailSale() {
        if (detailsaleList != null && !detailsaleList.isEmpty()) {
            System.out.println("ProductBean  - init > " + detailsaleList.size());
        } else {
            System.out.println("ProductBean  - init > no result found");
        }
    }
    
    public List<DetailSale> getDetailSaleList() {
        return detailsaleManager.getAll();
    }

    public void setDetailSaleList(List<DetailSale> detailsaleList) {
        this.detailsaleList = detailsaleList;
    }

    public DetailSale getDetailSale() {
        return detailsale;
    }

    public void setDetailSale(DetailSale detailsale) {
        this.detailsale = this.detailsale;
    }
    
    public void agregarDetailSale() {
        
        detailsaleManager.add(detailsale);
        init();
        

    }
        
        public void onSelect(SelectEvent event) {
                this.detailsale= (DetailSale) event.getObject();

        FacesMessage msg = new FacesMessage("DetailSale Selected id", String.valueOf(detailsale.getIdDetailSale()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("DetailSaleBean > Seleccionar Fila > " + this.detailsale);

    
    }

}
