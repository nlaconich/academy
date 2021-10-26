/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ci.academy.presentation.console;

import java.util.List;
import java.util.Scanner;
import py.com.ci.academy.customer.boundary.CustomerManager;
import py.com.ci.academy.customer.entities.Customer;
import py.com.ci.academy.product.boundary.ProductManager;
import py.com.ci.academy.product.entities.Product;
import py.com.ci.academy.students.boundary.StudentManager;
import py.com.ci.academy.teacher.boundary.TeacherManager;

/**
 *
 * @author jmendez
 */
public class CustomerUI {

    Scanner sc = new Scanner(System.in);
    CustomerManager manager = new CustomerManager();
    Customer customer = new Customer();

    public static void main(String[] args) {
        CustomerUI test = new CustomerUI();
        test.mainMenu();
    }

    public void mainMenu() {
        Integer selectedOption = 1;
        do {
            System.out.println("Welcome to CustomerUI beta 0.0");
            System.out.println("----------------------------------------");
            System.out.println("Choose an option ");
            System.out.println("1 : List all customer");
            System.out.println("2 : Add the customer");
            System.out.println("3 : Delete the customer");
            System.out.println("4 : Updadate the customer");
            System.out.println("5 : Exit");
            System.out.println("Option: ");
            String option = sc.next();
            try {
                selectedOption = Integer.parseInt(option);
                switch (selectedOption) {
                    case 1:
                        listAllCustomer();
                        break;
                    case 2:
                        registerCustomer();
                        break;
                    case 3:
                        deleteCustomer();
                        break;
                    case 4:
                        //updateCustomer();
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

    void listAllCustomer() {

        List<Customer> customeres = manager.getAll();
        if (!customeres.isEmpty()) {
            for (Customer customer : customeres) {
                System.out.println(customer);
            }
        } else {
            System.out.println("No customer found");
        }

    }

    private void registerCustomer() {

        StudentManager sm = new StudentManager();
        StudentUI sui = new StudentUI();
        TeacherManager tm = new TeacherManager();
        TeacherUI tui = new TeacherUI();

        String description = "";
        try {
            sc.nextLine();
            System.out.println("Insert the option (0= Student, 1= Teacher)");
            int option = sc.nextInt();
            if (option == 0) {
                sui.listAllStudents();
                System.out.println("Insert the student Id");
                int idStudent = sc.nextInt();
                customer.setIdStudent(idStudent);
                description = "Student";
            } else {
                if (option == 1) {
                    tui.listAllTeachers();
                    System.out.println("Insert the teacher Id");
                    int idTeacher = sc.nextInt();
                    customer.setIdTeacher(idTeacher);
                    description = "Teacher";
                }
            }

            customer.setIdCustomer(option);
            //customer.setIdStudent(option);
           // customer.setIdTeacher(option);
            customer.setDescription(description);
            manager.add(customer);

            //    manager.addProduct(product);
        } catch (Exception ex) {

            System.err.println(ex.getMessage());

        }
    }

    private void deleteCustomer() {
        this.listAllCustomer();
        System.out.println("Insert Id");
        int id = sc.nextInt();
        customer.setIdCustomer(id);
        boolean ban = manager.deleteById(customer);
        if (ban == true) {
            System.out.println("Delete successful");
        } else {
            System.out.println("Error");
        }
    }

    private void updateCustomer() {

        StudentManager sm = new StudentManager();
        StudentUI sui = new StudentUI();
        TeacherManager tm = new TeacherManager();
        TeacherUI tui = new TeacherUI();

        String description = "";
        
        this.listAllCustomer();
        sc.nextLine();
        System.out.println("Insert the new customer description");
        String descprtion = sc.nextLine();
        
        customer.setDescription(description);
        
       /* try {
            this.listAllCustomer();
            System.out.println("Insert the Customer Id");
            int id = sc.nextInt();

            sc.nextLine();
            System.out.println("Insert the option (0= Student, 1= Teacher)");
            int option = sc.nextInt();
            if (option == 0) {
                sui.listAllStudents();
                System.out.println("Insert the new student Id");
                int idStudent = sc.nextInt();
                customer.setIdStudent(idStudent);
                description = "Student";
            } else {
                if (option == 1) {
                    tui.listAllTeachers();
                    System.out.println("Insert the new teacher Id");
                    int idTeacher = sc.nextInt();
                    customer.setIdStudent(idTeacher);
                    description = "Teacher";
                }
            }

            customer.setIdCustomer(option);
            customer.setIdStudent(option);
            customer.setIdTeacher(option);
            customer.setDescription(description);

            //    manager.addProduct(product);
        } catch (Exception ex) {

            System.err.println(ex.getMessage());

        }*/
       
    }
}
