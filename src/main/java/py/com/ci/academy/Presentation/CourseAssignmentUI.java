package py.com.ci.academy.Presentation;


import py.com.ci.academy.Assignment.boundary.AssignmentManager;
import py.com.ci.academy.Course.boundary.CourseManager;
import py.com.ci.academy.CourseAssignment.boundary.CourseAssignmentManager;
import py.com.ci.academy.CourseAssignment.entities.CourseAssignment;

import java.util.List;
import java.util.Scanner;

public class CourseAssignmentUI {
    Scanner sc = new Scanner(System.in);
    CourseAssignmentManager manager = new CourseAssignmentManager();
    CourseAssignment courseAssignment = new CourseAssignment();

    public static void main(String[] args) {
        CourseAssignmentUI test = new CourseAssignmentUI();
        test.mainMenu();
    }

    public void mainMenu() {
        System.out.println("Welcome to CourseUI beta 0.0");
        System.out.println("----------------------------------------");
        System.out.println("Choose an option ");
        System.out.println("1 : List all courses");
        System.out.println("2 : Add a course");
        System.out.println("3 : Delete a course");
        System.out.println("4 : Update a course");
        System.out.println("5 : Exit");
        System.out.println("Option: ___");
        String option = sc.next();
        try {
            Integer selectedOption = Integer.parseInt(option);
            switch (selectedOption) {
                case 1:
                    listAllCoursesAssignments();
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

    private void listAllCoursesAssignments() {
        List<CourseAssignment> courseAssignments = manager.getAll();
        if (!courseAssignments.isEmpty()) {
            for (CourseAssignment courseAssignment : courseAssignments) {
                System.out.println(courseAssignment);
            }
        } else {
            System.out.println("No course assignment found ");
        }
    }

    private void registerCourseAssignment() {
        CourseUI courseUI= new CourseUI();
        AssignmentUI assignmentUI= new AssignmentUI();
        System.out.println("List of Courses");
        courseUI.listAllCourses();
        System.out.println("List of Assignment");
        assignmentUI.listAllAssignment();
        sc.nextLine();
        System.out.println("Insert Course Id");
        int idCourse = sc.nextInt();
        System.out.println("Insert Assignment Id");
        int idAssignment = sc.nextInt();

        courseAssignment.setIdCourse(idCourse);
        courseAssignment.setIdAssignment(idAssignment);

        manager.addCourseAssignment(courseAssignment);
    }

    private void deleteCourseAssignment() {
        manager.getAll();
        System.out.println("Insert Id");
        int id = sc.nextInt();
        courseAssignment.setIdCourse(id);

        boolean ban = manager.deleteCourseAssignment(courseAssignment);
        if (ban == true) {
            System.out.println("Delete successful");
        } else {
            System.out.println("Error");
        }

    }

    private void updateCourseAssignment() {
        this.listAllCoursesAssignments();
        System.out.println("Insert Id");
        int id = sc.nextInt();

        sc.nextLine();
        System.out.println("Insert Course Id");
        int idCourse = sc.nextInt();
        System.out.println("Insert Assignment Id");
        int idAssignment = sc.nextInt();

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
