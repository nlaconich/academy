package py.com.ci.academy.Presentation;

import py.com.ci.academy.Inquiries.boundary.InquiriesManager;
import py.com.ci.academy.Inquiries.entities.Inquiries;

import java.util.List;
import java.util.Scanner;

public class InquiriesUI {
    Scanner sc = new Scanner(System.in);
    InquiriesManager manager = new InquiriesManager();
    Inquiries inquiries = new Inquiries();
    StudentUI studentUI = new StudentUI();
    AssignmentUI assignmentui = new AssignmentUI();


    public static void main(String[] args){
        InquiriesUI test = new InquiriesUI();
        test.mainMenu();
    }

    public void mainMenu() {
        System.out.println("Welcome to CourseAssignmentUI beta 0.0");
        System.out.println("----------------------------------------");
        System.out.println("Choose an option ");
        System.out.println("1 : List all Students with Assignments");
        System.out.println("2 : Set an Assignment to a Student");
        System.out.println("4 : Update a Student's Assignment");
        System.out.println("3 : Delete a Student's Assignment");
        System.out.println("5 : Exit");
        System.out.print("Option: ");
        String option = sc.next();
        try {
            Integer selectedOption = Integer.parseInt(option);
            switch (selectedOption) {
                case 1:
                    listAllInquiries();
                    break;
                case 2:
                    registerInquiries();
                    break;
                case 3:
                    updateInquiries();
                    break;
                case 4:
                    deleteInquiries();
                    break;
                case 5:
                    return;
            }
            mainMenu();
        } catch (Exception ex) {

            mainMenu();
        }
    }

    public void listAllInquiries() {
        List<Inquiries> listStudent = manager.getAll();
        if (!listStudent.isEmpty()) {
            for (Inquiries student : listStudent) {
                System.out.println(student);
            }
        } else {
            System.out.println("No Relationship Found ");
        }
    }

    private void registerInquiries() {
        System.out.println("List of Student");
        studentUI.listAllStudents();

        System.out.println("Insert Student Id");
        int idStudent = sc.nextInt();
        System.out.println("----------------------------------------");

        System.out.println("List of Assignments");
        assignmentui.listAllAssignment();

        System.out.println("Insert Assignment Id");
        int idAssignment = sc.nextInt();

        inquiries.setIdStudent(idStudent);
        inquiries.setIdAssignment(idAssignment);

        boolean ban = manager.addInquiries(inquiries);
        if (ban == true) {
            System.out.println("Added successfully");
        } else {
            System.out.println("Error");
        }
    }

    private void updateInquiries() {
        System.out.println("List of all Students with Assignments");
        this.listAllInquiries();

        System.out.println("Insert Id");
        int id = sc.nextInt();
        System.out.println("----------------------------------------");

        System.out.println("List of Students");
        studentUI.listAllStudents();
        System.out.println("Insert new Student Id");
        int idStudent = sc.nextInt();
        System.out.println("----------------------------------------");

        System.out.println("List of Assignments");
        assignmentui.listAllAssignment();
        System.out.println("----------------------------------------");

        System.out.println("Insert new Assignment Id");
        int idAssignment = sc.nextInt();

        inquiries.setIdInquiries(id);
        inquiries.setIdStudent(idStudent);
        inquiries.setIdAssignment(idAssignment);

        boolean ban = manager.updateInquiries(inquiries);
        if (ban == true) {
            System.out.println("Update successful");
        } else {
            System.out.println("Error");
        }
    }

    private void deleteInquiries() {
        System.out.println("Student with assignment List");
        this.listAllInquiries();

        System.out.println("Insert Id");
        int id = sc.nextInt();
        inquiries.setIdInquiries(id);

        boolean ban = manager.deleteInquirires(inquiries);
        if (ban == true) {
            System.out.println("Delete successful");
        } else {
            System.out.println("Error");
        }

    }

}
