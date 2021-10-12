/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ci.academy.presentation.console;

import java.util.List;
import java.util.Scanner;
import org.postgresql.util.PSQLException;
import py.com.ci.academy.product.boundary.MarkManager;
import py.com.ci.academy.product.boundary.ProductManager;
import py.com.ci.academy.product.entities.Product;

/**
 *
 * @author jmendez
 */
public class ProductUI {

    Scanner sc = new Scanner(System.in);
    ProductManager manager = new ProductManager();
    Product product = new Product();
    PSQLException ex1;

    public static void main(String[] args) {
        ProductUI test = new ProductUI();
        test.mainMenu();
    }
    public void mainMenu() {
        Integer selectedOption = 1;
        do {
            System.out.println("Welcome to ProductUI beta 0.0");
            System.out.println("----------------------------------------");
            System.out.println("Choose an option ");
            System.out.println("1 : List all product");
            System.out.println("2 : Add a product");
            System.out.println("3 : Delete a product");
            System.out.println("4 : Update a product");
            System.out.println("5 : Exit");
            System.out.println("Option: ");
            String option = sc.next();
            try {
                selectedOption = Integer.parseInt(option);
                switch (selectedOption) {
                    case 1:
                        listAllProduct();
                        break;
                    case 2:
                        registerProduct();
                        break;
                    case 3:
                        deleteProduct();
                        break;
                    case 4:
                        updateProduct();
                        break;
                    case 5:
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

    void listAllProduct() {
        List<Product> productes = manager.getAll();
        if (!productes.isEmpty()) {
            for (Product product : productes) {
                System.out.println(product);
            }
        } else {
            System.out.println("No product found");
        }
    }

    private void registerProduct() {
        MarkUI markUI = new MarkUI();
        MarkManager mm = new MarkManager();
        int idproduct = 0;
        
        try  {
        sc.nextLine();
           
        if(idproduct ==0){
        
         idproduct = manager.getIdProduct();
        }else{ 
            idproduct++;
        }
        markUI.listAllMarks();
        System.out.println("Insert the mark Id");
        int markId = sc.nextInt();

        sc.nextLine();
        System.out.println("Insert the price of product");
        Double price = sc.nextDouble();

        product.setIdProduct(idproduct);
        product.setPrice(price);
        product.setMark(mm.getById(markId));

        manager.addProduct(product);
        
        } catch (Exception ex) {
            
            //System.err.println(ex.getMessage());
            
        }  
        
            
            //System.err.println(ex.getMessage());
        
         
        
    }

    private void deleteProduct() {
        this.listAllProduct();
        System.out.println("Insert Id");
        int id = sc.nextInt();
        product.setIdProduct(id); 
         boolean ban = manager.deleteById(product);
        if (ban == true) {
            System.out.println("Delete successful");
        } else {
            System.out.println("Error");
        }
    }
  

    private void updateProduct() {
        MarkUI markUI = new MarkUI();
        MarkManager mm = new MarkManager();
       try{
        this.listAllProduct();
        System.out.println("Insert Id");
        int id = sc.nextInt();
        
        
        markUI.listAllMarks();
        System.out.println("Insert the new mark Id");
        int markId = sc.nextInt();

        sc.nextLine();
        System.out.println("Insert the new price of product");
        Double price = sc.nextDouble();

        product.setIdProduct(id);
        product.setPrice(price);
        product.setMark(mm.getById(markId));
        
       }catch (Exception ex) {
            
            System.err.println(ex.getMessage()); 

        boolean ban = manager.updateProduct(product);
        if (ban == true) {
            System.out.println("Update successful");
        } else {
            System.out.println("Error");
        }

    }

 }
}
