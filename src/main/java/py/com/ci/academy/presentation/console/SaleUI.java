/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ci.academy.presentation.console;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import py.com.ci.academy.customer.boundary.CustomerManager;
import py.com.ci.academy.sale.boundary.SaleManager;
import py.com.ci.academy.sale.entities.Sale;
import py.com.ci.academy.detailsale.boundary.DetailSaleManager;

/**
 *
 * @author jmendez
 */
public class SaleUI {

    Scanner sc = new Scanner(System.in);

    SaleManager manager = new SaleManager();
    Sale sale = new Sale();
    double total = 0;
   

    public static void main(String[] args) {
        SaleUI test = new SaleUI();
        test.mainMenu();
    }
    private Integer productId;

    public void mainMenu() {
        Integer selectedOption = 1;
        do {
            System.out.println("Welcome to SaleUI beta 0.0");
            System.out.println("----------------------------------------");
            System.out.println("Choose an option ");
            System.out.println("1 : List all sale");
            System.out.println("2 : Add  the sale");
            System.out.println("3 : Add  the new items");
            System.out.println("4 : Delete the sale");
            System.out.println("5 : Update the sale");
            System.out.println("6 : Exit");
            System.out.println("Option: ");
            String option = sc.next();
            try {
                selectedOption = Integer.parseInt(option);
                switch (selectedOption) {
                    case 1:
                        listAllSale();
                        break;
                    case 2:
                        registerSale();
                        break;
                    case 3:
                        registerSaleItems();
                        break;
                    case 4:
                        deleteSale();
                        break;
                    case 5:
                        updateSale();
                        break;
                    case 6:
                        System.out.println("** Fin del proceso **");
                }
                break;
                // mainMenu();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                // mainMenu();
            }
        } while (selectedOption < 5);

    }

    void listAllSale() {
        List<Sale> sales = manager.getAll();
        if (!sales.isEmpty()) {
            for (Sale sale : sales) {
                System.out.println(sale);
            }
        } else {
            System.out.println("Sale not found");
        }
    }

    private void registerSale() {

        CustomerUI customerUI = new CustomerUI();
        CustomerManager cm = new CustomerManager();
        Date fec = null; 
        int y = 0;
        int d = 0;
        int m = 0;
        int idsale = 0;

        try {
            /*if (idsale == 0) {

                System.out.println("Insert the sale id");
                int idSale = sc.nextInt();

            } else {
                idsale = manager.getIdSale();
            }
            sc.nextLine();*/

            sc.nextLine();
            System.out.println("Insert the year 121 actual year");
            y = sc.nextInt();

            sc.nextLine();
            System.out.println("Insert the month (0-11) of the sale");
            m = sc.nextInt();

            sc.nextLine();
            System.out.println("Insert the day (1-31) of the sale");
            d = sc.nextInt();

            if (y >= 100 && y <= 1000) {
                if (m >= 0 && m <= 11) {
                   if (m == 1) {
                       if (d >= 1 && d <= 28) {

                           System.out.println("The date entered is: "+ d+"/"+(m+1)+"/"+ (y+1900));
                           fec= new Date(y,m,d);
                           System.out.println("The date entered is: "+fec.toString());
                        }else{
                            System.out.println("not valid day ");
                       
                       }

                    }else{
                   
                         if (d >= 1 && d <= 31) {

                        System.out.println("The date entered is: "+ d+"/"+(m+1)+"/"+ (y+1900));
                        fec= new Date(y,m,d);
                        System.out.println("The date entered is: "+fec.toString());
                   
                   }else {

                        System.out.println("not valid day");
                    }
                   }

                } else {

                    System.out.println("The month is incorrect");
                }

            } else {
                System.out.println("The year is incorrect");
            }

            customerUI.listAllCustomer();
            System.out.println("Insert the customer Id");
            int customerId = sc.nextInt();

            sc.nextLine();
            System.out.println("Insert the description of sale");
            String description = sc.nextLine();

            //sale.setIdSale(idSale);
            sale.setDate_sale(fec);
            sale.setCustomer(cm.getById(customerId));
            sale.setDescripcion(description);
            manager.add(sale);

            //    manager.addProduct(product);
        } catch (Exception ex) {

            System.err.println(ex.getMessage());

        }
    }

    private void deleteSale() {
        this.listAllSale();
        System.out.println("Insert Id");
        int id = sc.nextInt();
        sale.setIdSale(id);
        boolean ban = manager.deleteById(sale);
        if (ban == true) {
            System.out.println("Delete successful");
        } else {
            System.out.println("Error");
        }
    }

    private void updateSale() {

        CustomerUI customerUI = new CustomerUI();
        CustomerManager cm = new CustomerManager();
        Date fec = null; 
        int y = 0;
        int d = 0;
        int m = 0;
        int idsale = 0;

        try {
            this.listAllSale();
            System.out.println("Insert the sale id");
            int idSale = sc.nextInt();

            sc.nextLine();

            sc.nextLine();
            System.out.println("Insert the new year 121 actual year");
            y = sc.nextInt();

            sc.nextLine();
            System.out.println("Insert the new month (0-11) of the sale");
            m = sc.nextInt();

            sc.nextLine();
            System.out.println("Insert the new day (1-31) of the sale");
            d = sc.nextInt();

            if (y >= 100 && y <= 1000) {
                if (m >= 0 && m <= 11) {
                   if (m == 1) {
                       if (d >= 1 && d <= 28) {

                           System.out.println("The date entered is: "+ d+"/"+(m+1)+"/"+ (y+1900));
                           fec= new Date(y,m,d);
                           System.out.println("The date entered is: "+fec.toString());
                        }else{
                            System.out.println("not valid day ");
                       
                       }

                    }else{
                   
                         if (d >= 1 && d <= 31) {

                        System.out.println("The date entered is: "+ d+"/"+(m+1)+"/"+ (y+1900));
                        fec= new Date(y,m,d);
                        System.out.println("The date entered is: "+fec.toString());
                   
                   }else {

                        System.out.println("not valid day");
                    }
                   }

                } else {

                    System.out.println("The month is incorrect");
                }

            } else {
                System.out.println("The year is incorrect");
            }

            customerUI.listAllCustomer();
            System.out.println("Insert the customer Id");
            int customerId = sc.nextInt();

            sc.nextLine();
            System.out.println("Insert the description of sale");
            String description = sc.nextLine();

            //sale.setIdSale(idSale);
            sale.setDate_sale(fec);
            sale.setCustomer(cm.getById(customerId));
            sale.setDescripcion(description);
            boolean ban = manager.updateSale(sale);
            if(ban){
                System.out.println("Register update");
            }

            //    manager.addProduct(product);
        } catch (Exception ex) {

            System.err.println(ex.getMessage());

        }
  }

    private void registerSaleItems() {
         Sale s = null;
         try {
          this.listAllSale();
            System.out.println("Insert the sale id");
            int idSale = sc.nextInt(); 
   
         List<Sale> sales = manager.getAll();
        if (!sales.isEmpty()) {
              for (Sale sale : sales){
                if(sale.getIdSale()== idSale){
                   s = sale;
                }
              }
            
        }
        int option = 0;
          while(option != 1){  
         DetailSaleUI items = new DetailSaleUI(s);
         
         total += items.subtotal;
         items.mainMenu();
         
              System.out.println("The items subtotal is: "+items.subtotal
              );
              System.out.println("Do you want to add more items? (0=Continue, 1= Exit )");
              option= sc.nextInt();
          }
          if(total!=0){
           boolean ban = manager.updateTotal(total, idSale );
           if(ban)
                System.out.println("Total actualizado");
          }else {
          
                 System.out.println("No actualizado");
          }
          
         
    }catch (Exception ex) {

            System.err.println(ex.getMessage());

    }
 }
}