/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ci.academy.presentation.console;

import java.util.List;
import java.util.Scanner;
import py.com.ci.academy.product.boundary.MarkManager;
import py.com.ci.academy.product.entities.Mark;
/**
 *
 * @author jmendez
 */
public class MarkUI {
    Scanner sc = new Scanner(System.in);
    MarkManager manager = new MarkManager();
    Mark mark = new Mark();
    
    public static void main(String[] args) {
        MarkUI test = new MarkUI();
        test.mainMenu();
       //test.listAllMarks();
    }
    public void mainMenu() {
        Integer selectedOption = 1;
        do {
            System.out.println("Welcome to the MarksUI beta 0.0");
            System.out.println("----------------------------------------");
            System.out.println("Choose an option ");
            System.out.println("1 : List all mark");
            System.out.println("2 : Add a mark");
            System.out.println("3 : Delete a mark");
            System.out.println("4 : Update a mark");
            System.out.println("5 : Exit");
            System.out.println("Option: ");
            String option = sc.next();
            try {
                selectedOption = Integer.parseInt(option);
                switch (selectedOption) {
                    case 1:
                        listAllMarks();
                        break;
                    case 2:
                        registerMarks();
                        break;
                    case 3:
                        deleteMarks();
                        break;
                    case 4:
                        updateMarks();
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
      public void listAllMarks() {
        List<Mark> markes = manager.getAll();
        if (!markes.isEmpty()) {
            for (Mark mark : markes) {
                System.out.println(mark.getId_mark()+" :  "+mark.getName());
            }
        } else {
            System.out.println("No mark found");
        }
    }

    private void registerMarks() {
        /*sc.nextLine();
        System.out.println("Insert the mark id");
        int idMark = sc.nextInt();*/
        try{
        sc.nextLine();
        System.out.println("Insert the Mark Name");
        String nameMark = sc.nextLine();
        
        //mark.setId_mark(idMark);
        mark.setName(nameMark);
        
        manager.add(mark);
   }catch (Exception ex) {
            
            System.err.println(ex.getMessage());
        
        }  
  }

    private void deleteMarks() {
        this.listAllMarks();
        sc.nextLine();
        System.out.println("Select the mark id");
        int idMark = sc.nextInt();
       
        mark.setId_mark(idMark);
        boolean ban = manager.deleteById(mark);
        if (ban == true) {
            System.out.println("Delete successful");
        } else {
            System.out.println("Error");
        }
 }

    private void updateMarks() {
        this.listAllMarks();       
        sc.nextLine();
        System.out.println("Select the mark id");
        int idMark = sc.nextInt();
        
        sc.nextLine();
        System.out.println("Insert the New Mark Name");
        String nameMark = sc.nextLine();
        
        mark.setId_mark(idMark);
        mark.setName(nameMark);
        
         boolean ban = manager.updateMark(mark);
        if (ban == true) {
            System.out.println("Update successful");
        } else {
            System.out.println("Error");
        }
   }
}
