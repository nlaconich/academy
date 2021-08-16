package py.com.ci.academy.Presentation;


import py.com.ci.academy.InscriptionReport.boundary.InscriptionReportManager;
import py.com.ci.academy.InscriptionReport.entities.InscriptionReport;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InscriptionReportUI {

    Scanner sc= new Scanner(System.in);
    InscriptionReportManager manager= new InscriptionReportManager();

    public static void main(String[] args) {
        InscriptionReportUI ui= new InscriptionReportUI();
        ui.mainMenu();
    }
    public void mainMenu() {
        System.out.println("Welcome to CourseAssignmentUI beta 0.0 ");
        System.out.println("----------------------------------------");
        System.out.println("Choose an option ");
        System.out.println("1 : Get all Inscription");
        System.out.println("2 : Filter Inscription by Id");
        System.out.println("3 : Filter Student by Name");
        System.out.println("4 : Exit");
        System.out.print("Option: ");
        String option = sc.next();
        try {
            Integer selectedOption = Integer.parseInt(option);
            switch (selectedOption) {
                case 1:
                    ListAllInscription();
                    break;

                case 2:
                    GetById();
                    break;
                case 3:
                    GetByStudentName();
                    break;
                case 4:
                    return;
            }
            mainMenu();
        } catch (Exception ex) {

            mainMenu();
        }
    }

    public void ListAllInscription(){
        List<InscriptionReport> inscriptionReports= new ArrayList<>();
        inscriptionReports= manager.getAll();
        for (InscriptionReport inscriptionReport: inscriptionReports) {
            System.out.println(inscriptionReport);
        }
    }

    private void GetById(){
        InscriptionUI inscriptionUI= new InscriptionUI();
        inscriptionUI.listAllInscriptions();
        System.out.println("Insert Inscription Id");
        int idInscription= sc.nextInt();

        List<InscriptionReport> inscriptionReports = manager.getById(idInscription);
        for (InscriptionReport inscriptionReport: inscriptionReports) {
            System.out.println(inscriptionReport);
        }
    }

    private void GetByStudentName(){

        StudentUI studentUI= new StudentUI();
        studentUI.listAllStudents();
        sc.nextLine();
        System.out.println("Insert Student Name ");
        String nameStudent= sc.nextLine();

        String firstLtr = nameStudent.substring(0, 1);
        String restLtrs = nameStudent.substring(1, nameStudent.length());
        firstLtr = firstLtr.toUpperCase();
        restLtrs= restLtrs.toLowerCase();
        nameStudent = firstLtr + restLtrs;

        List<InscriptionReport> inscriptionReports = manager.getByNameStudent(nameStudent);
        for (InscriptionReport courseReport: inscriptionReports) {
            System.out.println(courseReport);
        }
    }
}