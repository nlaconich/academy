package py.com.ci.academy.Presentation;

import py.com.ci.academy.Teacher.boundary.TeacherManager;
import py.com.ci.academy.TeacherReport.boundary.TeacherReportManager;
import py.com.ci.academy.TeacherReport.entities.TeacherReport;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class TeacherReportUI {

    Scanner sc= new Scanner(System.in);
    TeacherReportManager manager= new TeacherReportManager();
    TeacherUI teacherUI= new TeacherUI();
    TeacherReport teacherReport= new TeacherReport();

    public static void main(String[] args) {
        TeacherReportUI ui= new TeacherReportUI();
        ui.mainMenu();
    }
    public void mainMenu() {
        System.out.println("Welcome to CourseAssignmentUI beta 0.0");
        System.out.println("----------------------------------------");
        System.out.println("Choose an option ");
        System.out.println("1 : Get all Teacher");
        System.out.println("2 : Filter Teacher by Id");
        System.out.println("3 : Filter Teacher by Name");
        System.out.println("4 : Filter Teacher by Lastname");
        System.out.println("5 : Exit");
        System.out.print("Option: ");
        String option = sc.next();
        try {
            Integer selectedOption = Integer.parseInt(option);
            switch (selectedOption) {
                case 1:
                    ListAllTeacher();
                    break;

                case 2:
                    GetById();
                    break;
                case 3:
                    GetByName();
                    break;
                case 4:
                    GetByLastName();
                    break;
                case 5:
                    return;
            }
            mainMenu();
        } catch (Exception ex) {

            mainMenu();
        }
    }

    public void ListAllTeacher(){
        List<TeacherReport> teacherReports= new ArrayList<>();
        teacherReports= manager.getAll();
        for (TeacherReport teacherReport: teacherReports) {
            System.out.println(teacherReport);
        }
    }

    private void GetById(){

        teacherUI.listAllTeachers();
        System.out.println("Insert Teacher Id");
        int idTeacher= sc.nextInt();

        List<TeacherReport> teacherReports = manager.getById(idTeacher);
        for (TeacherReport teacherReport: teacherReports) {
            System.out.println(teacherReport);
        }
    }

    private void GetByName(){

        teacherUI.listAllTeachers();
        sc.nextLine();
        System.out.println("Insert Teacher's Name");
        String nameTeacher= sc.nextLine();

        String firstLtr = nameTeacher.substring(0, 1);
        String restLtrs = nameTeacher.substring(1, nameTeacher.length());
        firstLtr = firstLtr.toUpperCase();
        restLtrs= restLtrs.toLowerCase();
        nameTeacher = firstLtr + restLtrs;

        List<TeacherReport> teacherReports = manager.getByName(nameTeacher);
        for (TeacherReport teacherReport: teacherReports) {
            System.out.println(teacherReport);
        }
    }

    private void GetByLastName(){

        teacherUI.listAllTeachers();
        sc.nextLine();
        System.out.println("Insert Teacher's Lastname");
        String lastNameTeacher= sc.nextLine();

        String firstLtr = lastNameTeacher.substring(0, 1);
        String restLtrs = lastNameTeacher.substring(1, lastNameTeacher.length());
        firstLtr = firstLtr.toUpperCase();
        restLtrs= restLtrs.toLowerCase();
        lastNameTeacher = firstLtr + restLtrs;

        List<TeacherReport> teacherReports = manager.getByLastName(lastNameTeacher);
        for (TeacherReport teacherReport: teacherReports) {
            System.out.println(teacherReport);
        }
    }
}
