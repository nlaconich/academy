package py.com.ci.academy.Presentation;


import py.com.ci.academy.Inscription.boundary.InscriptionManager;
import py.com.ci.academy.Inscription.entities.Inscription;

import java.util.List;
import java.util.Scanner;

public class InscriptionUI {
    Scanner sc = new Scanner(System.in);
    InscriptionManager manager= new InscriptionManager();
    Inscription inscription= new Inscription();

    public static void main(String[] args) {
        InscriptionUI test = new InscriptionUI();
        test.mainMenu();
    }

    private void mainMenu() {
        System.out.println("Welcome to InscriptionUI beta 0.0");
        System.out.println("----------------------------------------");
        System.out.println("Choose an option ");
        System.out.println("1 : List all inscriptions");
        System.out.println("2 : Add a inscription");
        System.out.println("3 : Delete a inscription");
        System.out.println("4 : Update a inscription");
        System.out.println("5 : Exit");
        System.out.println("Option: ___");
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

    private void listAllInscriptions() {
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
        sc.nextLine();
        System.out.println("Insert Id Course");
        int idCourse = sc.nextInt();
        System.out.println("Insert Id Student");
        int idStudent = sc.nextInt();

        inscription.setIdCourse(idCourse);
        inscription.setIdStudent(idStudent);

        manager.addInscription(inscription);
    }

    private void deleteInscription() {

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

        System.out.println("Insert Id");
        int idInscription = sc.nextInt();

        sc.nextLine();
        System.out.println("Insert new Id Course");
        int idCourse = sc.nextInt();
        System.out.println("Insert new Id Student");
        int idStudent = sc.nextInt();

        inscription.setIdInscription(idInscription);
        inscription.setIdCourse(idCourse);
        inscription.setIdStudent(idStudent);

        boolean ban = manager.updateInscription(inscription);
        if (ban == true) {
            System.out.println("Update successful");
        } else {
            System.out.println("Error");
        }
    }
}
