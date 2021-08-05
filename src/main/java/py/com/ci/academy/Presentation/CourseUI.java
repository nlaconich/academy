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
            System.out.println("No course found ");
        }
    }

    private void registerCourse() {
        sc.nextLine();
        System.out.println("Insert Course Name");
        String nameCourse = sc.nextLine();
        System.out.println("Insert Teacher Id");
        int teacherId = sc.nextInt();
        System.out.println("Insert Teacher Name");
        String nameTeacher = sc.nextLine();

        course.setNameCourse(nameCourse);
        course.setIdTeacher(teacherId);
        course.setNameTeacher(nameTeacher);

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
        System.out.println("Insert new Course Name");
        String nameCourse = sc.nextLine();
        System.out.println("Insert new Teacher Id");
        int teacherId = sc.nextInt();
        System.out.println("Insert new Teacher Name");
        String nameTeacher = sc.nextLine();

        course.setNameCourse(nameCourse);
        course.setIdTeacher(teacherId);
        course.setNameTeacher(nameTeacher);


        boolean ban = manager.updateCourse(course);
        if (ban == true) {
            System.out.println("Update successful");
        } else {
            System.out.println("Error");
        }
    }
}
