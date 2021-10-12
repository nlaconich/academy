/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ci.academy.presentation.console;

import java.util.List;
import java.util.Scanner;
import py.com.ci.academy.detailsale.boundary.DetailSaleManager;
import py.com.ci.academy.detailsale.entities.DetailSale;
import py.com.ci.academy.product.boundary.ProductManager;
import py.com.ci.academy.product.entities.Product;
import py.com.ci.academy.sale.entities.Sale;
import py.com.ci.academy.sale.boundary.SaleManager;

/**
 *
 * @author jmendez
 */
public class DetailSaleUI {
     Scanner sc = new Scanner(System.in);
    DetailSaleManager manager = new DetailSaleManager();
    SaleManager managerr = new SaleManager();
    DetailSale items = new DetailSale();
    Product product = new Product ();
    Sale sale ;
    double subtotal;

    public DetailSaleUI() {
    }

   
    
    public DetailSaleUI(Sale sale) {
        this.sale = sale;
    }


    public static void main(String[] args) {
        DetailSaleUI test = new DetailSaleUI();
        test.mainMenu();
    }
    public void mainMenu() {
        Integer selectedOption = 1;
        do {
            System.out.println("Welcome to the DetailSaleUI beta 0.0");
            System.out.println("----------------------------------------");
            System.out.println("Choose an option ");
            System.out.println("1: Add new detailsale");
            System.out.println("2 : Exit");
            System.out.println("Option: ");
            String option = sc.next();
            try {
                selectedOption = Integer.parseInt(option);
                switch (selectedOption) {
                 
                    case 1:
                        
                        registerItems();
                        break;
                   
                    default:
                        System.out.println("** Fin del proceso **");
                }
                break;
                // mainMenu();
            } catch (NumberFormatException ex) {
                System.err.println(ex.getMessage());
                // mainMenu();
            }
        } while (selectedOption < 5);

    }

    private void registerItems() {
    ProductUI productUI = new ProductUI();
    ProductManager pm = new ProductManager();
    DetailSaleUI detailsaleUI = new DetailSaleUI();
    Product p = null;
        int idproduct = 0;
        
        try  {
          sc.nextLine();
          System.out.println("Insert the amount of product");
          int amount_product = sc.nextInt();
        
        sc.nextLine();
        productUI.listAllProduct();
        System.out.println("Insert the product Id");
        idproduct = sc.nextInt();
         List<Product> productes = pm.getAll();
        if (!productes.isEmpty()) {
              for (Product product : productes){
                if(product.getIdProduct()== idproduct){
                   p = product;
                }
              }
            }
              
       
        sc.nextLine();
        System.out.println("Insert the historical price of product");
        double  price_historical = sc.nextDouble();
        
        items.setSale(sale);

        items.setProduct(p);
        items.setAmount_product(amount_product);
        items.setPrice_historical(price_historical);
      
        
        this.subtotal=items.subtotal();

        manager.add(items);
        
        
        
        } catch (Exception ex) {
            
            //System.err.println(ex.getMessage());
            
        }  
            
  
 }
    
}
