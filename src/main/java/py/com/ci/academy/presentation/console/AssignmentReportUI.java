package py.com.ci.academy.presentation.console;

import py.com.ci.academy.assignment.boundary.AssignmentReportManager;
import py.com.ci.academy.assignment.entities.AssignmentReport;
import py.com.ci.academy.presentation.console.AssignmentUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AssignmentReportUI {

    Scanner sc= new Scanner(System.in);
    AssignmentReportManager manager= new AssignmentReportManager();
    AssignmentUI assignmentUI= new AssignmentUI();

    public static void main(String[] args) {
        AssignmentReportUI ui= new AssignmentReportUI();
        ui.mainMenu();
    }

    public void mainMenu() {
        System.out.println("Welcome to AssignmentReportUI beta 0.0");
        System.out.println("----------------------------------------");
        System.out.println("Choose an option ");
        System.out.println("1 : Get all Assignments");
        System.out.println("2 : Filter Assignment by Id");
        System.out.println("3 : Filter Assignment by Name");
        System.out.println("4 : Exit");
        System.out.println("Option: ");
        String option = sc.next();
        try {
            Integer selectedOption = Integer.parseInt(option);
            switch (selectedOption) {
                case 1:
                    ListAllAssignment();
                    break;

                case 2:
                    GetById();
                    break;
                case 3:
                    GetByName();
                    break;
                case 4:
                    return;
            }
            mainMenu();
        } catch (Exception ex) {

            mainMenu();
        }
    }

    public void ListAllAssignment(){
        List<AssignmentReport> assignmentReports= new ArrayList<>();
        assignmentReports= manager.getAll();
        for (AssignmentReport assignmentReport: assignmentReports) {
            System.out.println(assignmentReport);
        }
    }

    private void GetById(){

        assignmentUI.listAllAssignment();
        System.out.println("Insert Assignment Id");
        int idTeacher= sc.nextInt();

        List<AssignmentReport> assignmentReports = manager.getById(idTeacher);
        for (AssignmentReport assignmentReport: assignmentReports) {
            System.out.println(assignmentReport);
        }
    }

    private void GetByName(){

        assignmentUI.listAllAssignment();
        sc.nextLine();
        System.out.println("Insert Assignment Name");
        String nameAssignment= sc.nextLine();

        String firstLtr = nameAssignment.substring(0, 1);
        String restLtrs = nameAssignment.substring(1, nameAssignment.length());
        firstLtr = firstLtr.toUpperCase();
        restLtrs= restLtrs.toLowerCase();
        nameAssignment = firstLtr + restLtrs;

        List<AssignmentReport> assignmentReports = manager.getByName(nameAssignment);
        for (AssignmentReport teacherReport: assignmentReports) {
            System.out.println(teacherReport);
        }
    }

}
