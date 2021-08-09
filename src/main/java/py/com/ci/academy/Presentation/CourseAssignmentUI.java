package py.com.ci.academy.Presentation;


import py.com.ci.academy.CourseAssignment.boundary.CourseAssignmentManager;
import py.com.ci.academy.CourseAssignment.entities.CourseAssignment;

import java.util.List;
import java.util.Scanner;

public class CourseAssignmentUI {
    Scanner sc = new Scanner(System.in);
    CourseAssignmentManager manager = new CourseAssignmentManager();
    CourseAssignment courseAssignment = new CourseAssignment();

    CourseUI courseUI= new CourseUI();
    AssignmentUI assignmentUI= new AssignmentUI();

    public static void main(String[] args) {
        CourseAssignmentUI test = new CourseAssignmentUI();
        test.mainMenu();
    }

    public void mainMenu() {
        System.out.println("Welcome to CourseAssignmentUI beta 0.0");
        System.out.println("----------------------------------------");
        System.out.println("Choose an option ");
        System.out.println("1 : List all Courses with Assignments");
        System.out.println("2 : Set an Assignment to a Course");
        System.out.println("3 : Delete a Relationship");
        System.out.println("4 : Update a Relationship");
        System.out.println("5 : Exit");
        System.out.print("Option: ");
        String option = sc.next();
        try {
            Integer selectedOption = Integer.parseInt(option);
            switch (selectedOption) {
                case 1:
                    listAllCourseAssignments();
                    break;
                case 2:
                    registerCourseAssignment();
                    break;
                case 3:
                    deleteCourseAssignment();
                    break;
                case 4:
                    updateCourseAssignment();
                    break;
                case 5:
                    return;
            }
            mainMenu();
        } catch (Exception ex) {

            mainMenu();
        }
    }

    public void listAllCourseAssignments() {
        List<CourseAssignment> courses = manager.getAll();
        if (!courses.isEmpty()) {
            for (CourseAssignment course : courses) {
                System.out.println(course);
            }
        } else {
            System.out.println("No Relationship Found ");
        }
    }

    private void registerCourseAssignment() {
        System.out.println("List of Courses");
        courseUI.listAllCourses();

        System.out.println("Insert Course Id");
        int idCourse = sc.nextInt();
        System.out.println("----------------------------------------");

        System.out.println("List of Assignments");
        assignmentUI.listAllAssignment();

        System.out.println("Insert Assignment Id");
        int idAssignment = sc.nextInt();

        courseAssignment.setIdCourse(idCourse);
        courseAssignment.setIdAssignment(idAssignment);

        boolean ban = manager.addCourseAssignment(courseAssignment);
        if (ban == true) {
            System.out.println("Added successfully");
        } else {
            System.out.println("Error");
        }
    }

    private void deleteCourseAssignment() {
        System.out.println("Relationship List");
        this.listAllCourseAssignments();
        //System.out.println("------------------------------");

        System.out.println("Insert Id");
        int id = sc.nextInt();
        courseAssignment.setIdCourseAssignment(id);

        boolean ban = manager.deleteCourseAssignment(courseAssignment);
        if (ban == true) {
            System.out.println("Delete successful");
        } else {
            System.out.println("Error");
        }

    }

    private void updateCourseAssignment() {
        System.out.println("List of all Courses with Assignments");
        this.listAllCourseAssignments();

        System.out.println("Insert Id");
        int id = sc.nextInt();
        System.out.println("----------------------------------------");

        System.out.println("List of Courses");
        courseUI.listAllCourses();
        System.out.println("Insert new Course Id");
        int idCourse = sc.nextInt();
        System.out.println("----------------------------------------");

        System.out.println("List of Assignments");
        assignmentUI.listAllAssignment();
        System.out.println("----------------------------------------");

        System.out.println("Insert new Assignment Id");
        int idAssignment = sc.nextInt();

        courseAssignment.setIdCourseAssignment(id);
        courseAssignment.setIdCourse(idCourse);
        courseAssignment.setIdAssignment(idAssignment);

        boolean ban = manager.updateCourseAssignment(courseAssignment);
        if (ban == true) {
            System.out.println("Update successful");
        } else {
            System.out.println("Error");
        }
    }
}
