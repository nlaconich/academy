package py.com.ci.academy.presentation;

import py.com.ci.academy.studentReport.boundary.StudentReportManager;
import py.com.ci.academy.studentReport.entities.StudentReport;

import java.util.List;
import java.util.Scanner;

public class StudentReportUI {
    Scanner sc = new Scanner(System.in);
    StudentReportManager manager = new StudentReportManager();
    StudentReport studentReport = new StudentReport();
    py.com.ci.academy.presentation.StudentUI studentUI = new StudentUI();
    AssignmentUI assignmentui = new AssignmentUI();


    public static void main(String[] args){
        StudentReportUI test = new StudentReportUI();
        test.mainMenu();
    }

    public void mainMenu() {
        System.out.println("Welcome to CourseAssignmentUI beta 0.0");
        System.out.println("----------------------------------------");
        System.out.println("Choose an option ");
        System.out.println("1 : List all Students with Assignments");
        System.out.println("2 : Set an Assignment to a Student");
        System.out.println("3 : Update a Student's Assignment");
        System.out.println("4 : Delete a Student's Assignment");
        System.out.println("5 : Exit");
        System.out.print("Option: ");
        String option = sc.next();
        try {
            Integer selectedOption = Integer.parseInt(option);
            switch (selectedOption) {
                case 1:
                    listAllStudentReport();
                    break;
                case 2:
                    registerStudentReport();
                    break;
                case 3:
                    updateStudentReport();
                    break;
                case 4:
                    deleteStudentReport();
                    break;
                case 5:
                    return;
            }
            mainMenu();
        } catch (Exception ex) {

            mainMenu();
        }
    }

    public void listAllStudentReport() {
        List<StudentReport> listStudent = manager.getAll();
        if (!listStudent.isEmpty()) {
            for (StudentReport student : listStudent) {
                System.out.println(student);
            }
        } else {
            System.out.println("No Relationship Found ");
        }
    }

    private void registerStudentReport() {
        System.out.println("List of Student");
        studentUI.listAllStudents();

        System.out.println("Insert Student Id");
        int idStudent = sc.nextInt();
        System.out.println("----------------------------------------");

        System.out.println("List of Assignments");
        assignmentui.listAllAssignment();

        System.out.println("Insert Assignment Id");
        int idAssignment = sc.nextInt();

        studentReport.setIdStudent(idStudent);
        studentReport.setIdAssignment(idAssignment);

        boolean ban = manager.addStudentReport(studentReport);
        if (ban == true) {
            System.out.println("Added successfully");
        } else {
            System.out.println("Error");
        }
    }

    private void updateStudentReport() {
        System.out.println("List of all Students with Assignments");
        this.listAllStudentReport();

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

        studentReport.setIdStudentReport(id);
        studentReport.setIdStudent(idStudent);
        studentReport.setIdAssignment(idAssignment);

        boolean ban = manager.updateStudentReport(studentReport);
        if (ban == true) {
            System.out.println("Update successful");
        } else {
            System.out.println("Error");
        }
    }

    private void deleteStudentReport() {
        manager.getAll();
        System.out.println("Insert Report Id");
        int id = sc.nextInt();
        studentReport.setIdStudentReport(id);

        boolean ban = manager.deleteStudentReport(studentReport);
        if (ban == true) {
            System.out.println("Delete successful");
        } else {
            System.out.println("Error");
        }

    }

}
