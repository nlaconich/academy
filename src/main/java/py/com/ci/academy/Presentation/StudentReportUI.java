package py.com.ci.academy.Presentation;

import py.com.ci.academy.StudentReport.boundary.StudentReportManager;
import py.com.ci.academy.StudentReport.entities.StudentReport;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentReportUI {

    Scanner sc= new Scanner(System.in);
    StudentReportManager manager= new StudentReportManager();
    StudentUI studentUI= new StudentUI();
    StudentReport teacherReport= new StudentReport();

    public static void main(String[] args) {
        StudentReportUI ui= new StudentReportUI();
        ui.mainMenu();
    }
    public void mainMenu() {
        System.out.println("Welcome to StudentReportUI beta 0.0");
        System.out.println("----------------------------------------");
        System.out.println("Choose an option ");
        System.out.println("1 : Get all Students");
        System.out.println("2 : Filter Student by Id");
        System.out.println("3 : Filter Student by Name");
        System.out.println("4 : Filter Student by Lastname");
        System.out.println("5 : Exit");
        System.out.print("Option: ");
        String option = sc.next();
        try {
            Integer selectedOption = Integer.parseInt(option);
            switch (selectedOption) {
                case 1:
                    ListAllStudent();
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

    public void ListAllStudent(){
        List<StudentReport> studentReports= new ArrayList<>();
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
        String nameStudent= sc.nextLine();

        String firstLtr = nameStudent.substring(0, 1);
        String restLtrs = nameStudent.substring(1, nameStudent.length());
        firstLtr = firstLtr.toUpperCase();
        restLtrs= restLtrs.toLowerCase();
        nameStudent = firstLtr + restLtrs;

        List<StudentReport> studentReports = manager.getByName(nameStudent);
        for (StudentReport studentReport: studentReports) {
            System.out.println(studentReport);
        }
    }

    private void GetByLastName(){

        studentUI.listAllStudents();
        sc.nextLine();
        System.out.println("Insert Student's Lastname ");
        String lastNameStudent= sc.nextLine();

        String firstLtr = lastNameStudent.substring(0, 1);
        String restLtrs = lastNameStudent.substring(1, lastNameStudent.length());
        firstLtr = firstLtr.toUpperCase();
        restLtrs= restLtrs.toLowerCase();
        lastNameStudent = firstLtr + restLtrs;

        List<StudentReport> studentReports = manager.getByLastName(lastNameStudent);
        for (StudentReport studentReport: studentReports) {
            System.out.println(studentReport);
        }
    }
}
