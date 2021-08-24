package py.com.ci.academy.presentation.console;

import java.util.Scanner;

public class AcademyReports {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        AcademyReports main = new AcademyReports();
        main.mainMenu();
    }

    public void mainMenu() {
        System.out.println("Welcome to Academy Reports beta 0.0");
        System.out.println("----------------------------------------");
        System.out.println("Choose an option ");
        System.out.println("1 : Assignment Report");
        System.out.println("2 : Course Report");
        System.out.println("3 : Inscription Report");
        System.out.println("4 : Student Report");
        System.out.println("5 : Teacher Report");
        System.out.println("6 : Exit");
        System.out.print("Option: \n");
        String option = sc.next();
        try {
            int selectedOption = Integer.parseInt(option);
            switch (selectedOption) {
                case 1:
                    assignmentReport();
                    break;
                case 2:
                    courseReport();
                    break;
                case 3:
                    inscriptionReport();
                    break;
                case 4:
                    studentReport();
                    break;
                case 5:
                    teacherReport();
                    break;
                case 6:
                    return;
            }
            mainMenu();
        } catch (Exception ex) {
            mainMenu();
        }
    }


    private void assignmentReport() {
        AssignmentReportUI ui = new AssignmentReportUI();
        ui.mainMenu();
    }


    private void courseReport() {
        CourseReportUI ui = new CourseReportUI();
        ui.mainMenu();
    }

    private void inscriptionReport() {
        InscriptionReportUI ui = new InscriptionReportUI();
        ui.mainMenu();
    }

    private void studentReport() {
        StudentReportUI ui = new StudentReportUI();
        ui.mainMenu();
    }

    private void teacherReport() {
        TeacherReportUI ui = new TeacherReportUI();
        ui.mainMenu();
    }
}
