package py.com.ci.academy.Presentation;

import py.com.ci.academy.CourseAssignment.entities.CourseAssignment;

import java.util.Scanner;

public class AcademyUI {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        AcademyUI main = new AcademyUI();
        main.mainMenu();
    }

    private void mainMenu() {
        System.out.println("Welcome to AcademyUI beta 0.0");
        System.out.println("----------------------------------------");
        System.out.println("Choose an option ");
        System.out.println("1 : Assignment Management");
        System.out.println("2 : Course Management");
        System.out.println("3 : Inscription Management");
        System.out.println("4 : Student Management");
        System.out.println("5 : Teacher Management");
        System.out.println("6 : Course with Assignment Management");
        System.out.println("7 : Exit");
        System.out.print("Option: ");
        String option = sc.next();
        try {
            Integer selectedOption = Integer.parseInt(option);
            switch (selectedOption) {
                case 1:
                    assignmentManagement();
                    break;
                case 2:
                    courseManagement();
                    break;
                case 3:
                    inscriptionManagement();
                    break;
                case 4:
                    studentManagement();
                    break;
                case 5:
                    teacherManagement();
                    break;
                case 6:
                    curseAssignmentManagement();
                    break;
                case 7:
                    return;
            }
            mainMenu();
        } catch (Exception ex) {
            mainMenu();
        }
    }

    private void assignmentManagement() {
        AssignmentUI ui = new AssignmentUI();
        ui.mainMenu();
    }

    private void courseManagement() {
        CourseUI ui = new CourseUI();
        ui.mainMenu();
    }

    private void inscriptionManagement() {
        InscriptionUI ui = new InscriptionUI();
        ui.mainMenu();
    }

    private void studentManagement() {
        StudentUI ui = new StudentUI();
        ui.mainMenu();
    }

    private void teacherManagement() {
        TeacherUI ui = new TeacherUI();
        ui.mainMenu();
    }

    private void curseAssignmentManagement() {
        CourseAssignmentUI ui = new CourseAssignmentUI();
        ui.mainMenu();
    }
}