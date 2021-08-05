package py.com.ci.academy.Presentation;

import py.com.ci.academy.Assignment.boundary.AssignmentManager;
import py.com.ci.academy.Assignment.entities.Assignment;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class AssignmentUI {
    Scanner sc = new Scanner(System.in);
    AssignmentManager manager = new AssignmentManager();
    Assignment assignment = new Assignment();

    public static void main(String[] args) {
        AssignmentUI test = new AssignmentUI();
        test.mainMenu();
    }

    private void mainMenu() {
        System.out.println("Welcome to AssignmentUI beta 0.0");
        System.out.println("----------------------------------------");
        System.out.println("Choose an option ");
        System.out.println("1 : List all assignments");
        System.out.println("2 : Add a assignment");
        System.out.println("3 : Delete a assignment");
        System.out.println("4 : Update a assignment");
        System.out.println("5 : Exit");
        System.out.println("Option: ___");
        String option = sc.next();
        try {
            Integer selectedOption = Integer.parseInt(option);
            switch (selectedOption) {
                case 1:
                    listAllAssignment();
                    break;
                case 2:
                    registerAssignment();
                    break;
                case 3:
                    deleteAssignment();
                    break;
                case 4:
                    updateAssignment();
                    break;
                case 5:
                    return;
            }
            mainMenu();
        } catch (Exception ex) {

            mainMenu();
        }
    }

    public void listAllAssignment() {
        List<Assignment> assignments = manager.getAll();
        if (!assignments.isEmpty()) {
            for (Assignment assignment : assignments) {
                System.out.println(assignment);
            }
        } else {
            System.out.println("No assignment found");
        }
    }

    private void registerAssignment() {
        String name = JOptionPane.showInputDialog("Insert Name");

        assignment.setNameAssignment(name);

        manager.addAssignment(assignment);
    }

    private void deleteAssignment() {

        System.out.println("Insert Id ");
        int id = sc.nextInt();
        assignment.setIdAssignment(id);

        boolean ban = manager.deleteAssignment(assignment);
        if (ban == true) {
            System.out.println("Delete successful");
        } else {
            System.out.println("Error");
        }

    }

    private void updateAssignment() {

        System.out.println("Insert Id");
        int id = sc.nextInt();

        sc.nextLine();
        System.out.println("Insert new Name");
        String name = sc.nextLine();

        assignment.setIdAssignment(id);
        assignment.setNameAssignment(name);


        boolean ban = manager.updateAssignment(assignment);
        if (ban == true) {
            System.out.println("Update successful");
        } else {
            System.out.println("Error");
        }
    }
}
