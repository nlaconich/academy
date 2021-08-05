package py.com.ci.academy.Presentation;

import py.com.ci.academy.Course.boundary.CourseManager;
import py.com.ci.academy.Course.entities.Course;

import java.util.List;
import java.util.Scanner;

public class CourseUI {
    Scanner sc = new Scanner(System.in);
    CourseManager manager = new CourseManager();
    Course course = new Course();

    public static void main(String[] args) {
        CourseUI test = new CourseUI();
        test.mainMenu();
    }

    private void mainMenu() {
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
                    listAllCourses();
                    break;
                case 2:
                    registerCourse();
                    break;
                case 3:
                    deleteCourse();
                    break;
                case 4:
                    updateCourse();
                    break;
                case 5:
                    return;
            }
            mainMenu();
        } catch (Exception ex) {

            mainMenu();
        }
    }

    private void listAllCourses() {
        List<Course> courses = manager.getAll();
        if (!courses.isEmpty()) {
            for (Course course : courses) {
                System.out.println(course);
            }
        } else {
            System.out.println("No course found");
        }
    }

    private void registerCourse() {
        sc.nextLine();
        System.out.println("Insert Name");
        String name = sc.nextLine();
        System.out.println("Insert Assignment 1");
        int assignment = sc.nextInt();
        /*System.out.println("Insert Assignment 2");
        int assignment2 = sc.nextInt();
        System.out.println("Insert Assignment 3");
        int assignment3 = sc.nextInt();
        System.out.println("Insert Assignment 4");
        int assignment4 = sc.nextInt();*/
        System.out.println("Insert Teacher");
        int teacherId = sc.nextInt();

        course.setNameCourse(name);
        course.setIdAssignment(assignment);
        /*course.setIdAssignment2(assignment2);
        course.setIdAssignment3(assignment3);
        course.setIdAssignment4(assignment4);*/
        course.setIdTeacher(teacherId);

        manager.addCourse(course);
    }

    private void deleteCourse() {

        System.out.println("Insert Id");
        int id = sc.nextInt();
        course.setIdCourse(id);

        boolean ban = manager.deleteCourse(course);
        if (ban == true) {
            System.out.println("Delete successful");
        } else {
            System.out.println("Error");
        }

    }

    private void updateCourse() {

        System.out.println("Insert Id");
        int id = sc.nextInt();

        sc.nextLine();
        System.out.println("Insert new Name");
        String name = sc.nextLine();
        System.out.println("Insert new Assignment 1");
        int assignment = sc.nextInt();
        /*System.out.println("Insert new Assignment 2");
        int assignment2 = sc.nextInt();
        System.out.println("Insert new Assignment 3");
        int assignment3 = sc.nextInt();
        System.out.println("Insert new Assignment 4");
        int assignment4 = sc.nextInt();*/
        System.out.println("Insert new Teacher");
        int teacherId = sc.nextInt();

        course.setIdCourse(id);
        course.setNameCourse(name);
        course.setIdAssignment(assignment);
        /*course.setIdAssignment2(assignment2);
        course.setIdAssignment3(assignment3);
        course.setIdAssignment4(assignment4);*/
        course.setIdTeacher(teacherId);


        boolean ban = manager.updateCourse(course);
        if (ban == true) {
            System.out.println("Update successful");
        } else {
            System.out.println("Error");
        }
    }
}
