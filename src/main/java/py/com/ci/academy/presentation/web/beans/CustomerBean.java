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
import py.com.ci.academy.customer.boundary.CustomerManager;
import py.com.ci.academy.customer.entities.Customer;
import py.com.ci.academy.product.boundary.ProductManager;
import py.com.ci.academy.product.entities.Product;

/**
 *
 * @author jmendez
 */


@Named("customerBean")
@SessionScoped

public class CustomerBean implements Serializable{
     @Inject
    MarkBean studentBean; @Inject MarkBean teacherBean;
      
    private CustomerManager customerManager;
    private Customer customer;
    private List<Customer> customerList;
    
    
    @PostConstruct
    public void init() {

        customerManager = new CustomerManager();
        customerList = customerManager.getAll();
        customer = new Customer();
   }
    
      private void logProduct() {
        if (customerList != null && !customerList.isEmpty()) {
            System.out.println("CustomerBean  - init > " + customerList.size());
        } else {
            System.out.println("CustomerBean  - init > no result found");
        }
    }

    public List<Customer> getCustomerList() {
        return customerManager.getAll();
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
   
    public void updateCustomer() {
        customerManager.updateById(customer);
        init();
    }
    
    public void deleteCustomer(){
       customerManager.deleteById(customer);
       init();
    }

    
    public void agregarCustomer() {
        
        customerManager.add(customer);
        init();
        

    }
        
        public void onSelect(SelectEvent event) {
                this.customer = (Customer) event.getObject();

        FacesMessage msg = new FacesMessage("Customer Selected id", String.valueOf(customer.getIdCustomer()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("CustomerBean > Seleccionar Fila > " + this.customer);

    
    }   
}
