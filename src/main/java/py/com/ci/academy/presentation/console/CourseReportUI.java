package py.com.ci.academy.presentation.console;


import py.com.ci.academy.course.boundary.CourseReportManager;
import py.com.ci.academy.course.entities.CourseReport;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseReportUI {

    Scanner sc= new Scanner(System.in);
    CourseReportManager manager= new CourseReportManager();
    CourseUI courseUI= new CourseUI();

    public static void main(String[] args) {
        CourseReportUI ui= new CourseReportUI();
        ui.mainMenu();
    }
    public void mainMenu() {
        System.out.println("Welcome to CourseAssignmentUI beta 0.0");
        System.out.println("----------------------------------------");
        System.out.println("Choose an option ");
        System.out.println("1 : Get all Courses");
        System.out.println("2 : Filter Course by Id");
        System.out.println("3 : Filter Course by Name");
        System.out.println("4 : Exit");
        System.out.println("Option: ");
        String option = sc.next();
        try {
            Integer selectedOption = Integer.parseInt(option);
            switch (selectedOption) {
                case 1:
                    ListAllCourse();
                    break;

                case 2:
                    GetById();
                    break;
                case 3:
                    GetByName();
                    break;
                case 4:
                    return;
            }
            mainMenu();
        } catch (Exception ex) {

            mainMenu();
        }
    }

    public void ListAllCourse(){
        List<CourseReport> courseReports= new ArrayList<>();
        courseReports= manager.getAll();
        for (CourseReport courseReport: courseReports) {
            System.out.println(courseReport);
        }
    }

    private void GetById(){

        courseUI.listAllCourses();
        System.out.println("Insert Course Id");
        int idCourse= sc.nextInt();

        List<CourseReport> courseReports = manager.getById(idCourse);
        for (CourseReport courseReport: courseReports) {
            System.out.println(courseReport);
        }
    }

    private void GetByName(){

        courseUI.listAllCourses();
        sc.nextLine();
        System.out.println("Insert Course Name ");
        String nameCourse= sc.nextLine();

        /*String firstLtr = nameCourse.substring(0, 1);
        String restLtrs = nameCourse.substring(1, nameCourse.length());
        firstLtr = firstLtr.toUpperCase();
        restLtrs= restLtrs.toLowerCase();
        nameCourse = firstLtr + restLtrs;*/

        List<CourseReport> courseReports = manager.getByName(nameCourse);
        for (CourseReport courseReport: courseReports) {
            System.out.println(courseReport);
        }
    }
}
