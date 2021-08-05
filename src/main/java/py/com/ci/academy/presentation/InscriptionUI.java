package py.com.ci.academy.presentation;


import py.com.ci.academy.inscription.boundary.InscriptionManager;
import py.com.ci.academy.inscription.entities.Inscription;

import java.util.List;
import java.util.Scanner;

public class InscriptionUI {
    Scanner sc = new Scanner(System.in);
    InscriptionManager manager = new InscriptionManager();
    Inscription inscription = new Inscription();

    public static void main(String[] args) {
        InscriptionUI test = new InscriptionUI();
        test.mainMenu();
    }

    public void mainMenu() {
        System.out.println("Welcome to InscriptionUI beta 0.0");
        System.out.println("----------------------------------------");
        System.out.println("Choose an option ");
        System.out.println("1 : List all inscriptions");
        System.out.println("2 : Add a inscription");
        System.out.println("3 : Delete a inscription");
        System.out.println("4 : Update a inscription");
        System.out.println("5 : Exit");
        System.out.println("Option: ");
        String option = sc.next();
        try {
            Integer selectedOption = Integer.parseInt(option);
            switch (selectedOption) {
                case 1:
                    listAllInscriptions();
                    break;
                case 2:
                    registerInscription();
                    break;
                case 3:
                    deleteInscription();
                    break;
                case 4:
                    updateInscription();
                    break;
                case 5:
                    return;
            }
            mainMenu();
        } catch (Exception ex) {

            mainMenu();
        }
    }

    public void listAllInscriptions() {
        List<Inscription> inscriptions = manager.getAll();
        if (!inscriptions.isEmpty()) {
            for (Inscription inscription : inscriptions) {
                System.out.println(inscription);
            }
        } else {
            System.out.println("No inscription found");
        }
    }

    private void registerInscription() {
        CourseAssignmentUI courseAssignmentUI = new CourseAssignmentUI();
        StudentUI studentUI = new StudentUI();

        System.out.println("Course/Assignment List");
        courseAssignmentUI.listAllCourseAssignments();
        System.out.println("Insert Id Course/Assignment");
        int idCourse = sc.nextInt();

        System.out.println("Student List");
        studentUI.listAllStudents();
        System.out.println("Insert Id Student");
        int idStudent = sc.nextInt();

        inscription.setIdCxA(idCourse);
        inscription.setIdStudent(idStudent);

        manager.addInscription(inscription);
    }

    private void deleteInscription() {

        this.listAllInscriptions();
        System.out.println("Insert Id");
        int id = sc.nextInt();
        inscription.setIdInscription(id);

        boolean ban = manager.deleteInscription(inscription);
        if (ban == true) {
            System.out.println("Delete successful ");
        } else {
            System.out.println("Error");
        }

    }

    private void updateInscription() {
        CourseAssignmentUI courseAssignmentUI = new CourseAssignmentUI();
        StudentUI studentUI = new StudentUI();

        this.listAllInscriptions();
        System.out.println("Insert Id");
        int idInscription = sc.nextInt();

        sc.nextLine();
        courseAssignmentUI.listAllCourseAssignments();
        System.out.println("Insert new Id Course/Assignment");
        int idCourse = sc.nextInt();
        studentUI.listAllStudents();
        System.out.println("Insert new Id Student");
        int idStudent = sc.nextInt();

        inscription.setIdInscription(idInscription);
        inscription.setIdCxA(idCourse);
        inscription.setIdStudent(idStudent);

        boolean ban = manager.updateInscription(inscription);
        if (ban == true) {
            System.out.println("Update successful");
        } else {
            System.out.println("Error");
        }
    }
}
