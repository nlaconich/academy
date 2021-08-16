package py.com.ci.academy.presentation;

import py.com.ci.academy.students.boundary.StudentReportManager;
import py.com.ci.academy.students.entities.Student;
import py.com.ci.academy.students.entities.StudentReport;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentReportUI {

    Scanner sc= new Scanner(System.in);
    StudentReportManager manager= new StudentReportManager();
    StudentUI studentUI = new StudentUI();

    public static void main(String[] args) {
        StudentReportUI ui= new StudentReportUI();
        ui.mainMenu();
    }
    public void mainMenu() {
        System.out.println("Welcome to StudentReportUI beta 0.0");
        System.out.println("----------------------------------------");
        System.out.println("Choose an option ");
        System.out.println("1 : List All Students");
        System.out.println("2 : Filter Student by Id");
        System.out.println("3 : Filter Student by Name");
        System.out.println("4 : Filter Student by Lastname");
        System.out.println("5 : Exit");
        System.out.println("Option: ");
        String option = sc.next();
        try {
            Integer selectedOption = Integer.parseInt(option);
            switch (selectedOption) {
                case 1:
                    ListAllStudents();
                    break;
                case 2:
                    GetById();
                    break;
                case 3:
                    GetByName();
                    break;
                case 4:
                    GetByLastName();
                    break;
                case 5:
                    return;
            }
            mainMenu();
        } catch (Exception ex) {

            mainMenu();
        }
    }

    public void ListAllStudents(){
        List<StudentReport> studentReports = new ArrayList<>();
        studentReports= manager.getAll();
        for (StudentReport studentReport: studentReports) {
            System.out.println(studentReport);
        }
    }

    private void GetById(){

        studentUI.listAllStudents();
        System.out.println("Insert Student Id");
        int idStudent= sc.nextInt();

        List<StudentReport> studentReports = manager.getById(idStudent);
        for (StudentReport studentReport: studentReports) {
            System.out.println(studentReport);
        }
    }

    private void GetByName(){

        studentUI.listAllStudents();
        sc.nextLine();
        System.out.println("Insert Student's Name");
        String name= sc.nextLine();

        String firstLtr = name.substring(0, 1);
        String restLtrs = name.substring(1, name.length());
        firstLtr = firstLtr.toUpperCase();
        restLtrs= restLtrs.toLowerCase();
        name = firstLtr + restLtrs;

        List<StudentReport> studentReports = manager.getByName(name);
        for (StudentReport studentReport: studentReports) {
            System.out.println(studentReport);
        }
    }

    private void GetByLastName(){

        studentUI.listAllStudents();
        sc.nextLine();
        System.out.println("Insert Student's Lastname ");
        String lastName = sc.nextLine();

        String firstLtr = lastName.substring(0, 1);
        String restLtrs = lastName.substring(1, lastName.length());
        firstLtr = firstLtr.toUpperCase();
        restLtrs= restLtrs.toLowerCase();
        lastName = firstLtr + restLtrs;

        List<StudentReport> studentReports = manager.getByLastName(lastName);
        for (StudentReport studentReport: studentReports) {
            System.out.println(studentReport);
        }
    }
}
