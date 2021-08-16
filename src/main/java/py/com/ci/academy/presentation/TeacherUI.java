package py.com.ci.academy.presentation;

import py.com.ci.academy.teacher.boundary.TeacherManager;
import py.com.ci.academy.teacher.entities.Teacher;

import java.util.List;
import java.util.Scanner;

public class TeacherUI {
    Scanner sc = new Scanner(System.in);
    TeacherManager teacherManager = new TeacherManager();
    Teacher teacher = new Teacher();


    public static void main(String[] args) {
        TeacherUI teacherUI = new TeacherUI();
        teacherUI.mainMenu();
    }

    public void mainMenu() {
        System.out.println("Welcome to teacher academy beta 0.0");
        System.out.println("-----------------------------------");
        System.out.println("Choose an option: ");
        System.out.println("1 : List all teachers");
        System.out.println("2 : Add a teacher");
        System.out.println("3 : Delete a teacher");
        System.out.println("4 : Update a teacher");
        System.out.println("5 : Exit");
        System.out.println("Option: ");
        String option = sc.next();
        try {
            Integer selectedOption = Integer.parseInt(option);
            switch (selectedOption) {
                case 1:
                    listAllTeachers();
                    break;
                case 2:
                    registerTeacher();
                    break;
                case 3:
                    deleteTeacher();
                    break;
                case 4:
                    updateTeacher();
                    break;
                case 5:
                    return;
            }
            mainMenu();
        } catch (Exception ex) {

            mainMenu();
        }
    }

    public void listAllTeachers() {
        List<Teacher> listTeachers = teacherManager.getAll();
        if (!listTeachers.isEmpty()) {
            for (Teacher teacher : listTeachers) {
                System.out.println(teacher);
            }
        } else {
            System.out.println("No teacher found");
        }
    }

    private void registerTeacher() {
        String name = null, lastName = null, cellphone = null, address = null, email = null;

        sc.nextLine();
        System.out.println("Insert Name");
        name = sc.nextLine();
        System.out.println("Insert Last Name");
        lastName = sc.nextLine();
        System.out.println("Insert Phone");
        cellphone = sc.nextLine();
        System.out.println("Insert Address");
        address = sc.nextLine();
        System.out.println("Insert Mail");
        email = sc.nextLine();

        teacher.setNameTeacher(name);
        teacher.setLastName(lastName);
        teacher.setCellphone(cellphone);
        teacher.setAddress(address);
        teacher.setEmail(email);

        boolean tm = teacherManager.add(teacher);
        if (tm == true) {
            System.out.println("Operation successfully");

        } else {
            System.out.println("Error");
        }
    }

    private void deleteTeacher() {
        this.listAllTeachers();
        System.out.println("Insert Id ");
        int id = sc.nextInt();
        teacher.setIdTeacher(id);

        int rows = teacherManager.deleteById(teacher);
        System.out.println("Applied, " + rows + " affected");
    }

    private void updateTeacher() {
        this.listAllTeachers();
        System.out.println("Insert Id ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Insert new Name");
        String name = sc.nextLine();
        System.out.println("Insert new Last Name");
        String lastName = sc.nextLine();
        System.out.println("Insert new Phone");
        String cellphone = sc.nextLine();
        System.out.println("Insert new Address");
        String address = sc.nextLine();
        System.out.println("Insert new Mail");
        String email = sc.nextLine();
        teacher.setIdTeacher(id);
        teacher.setNameTeacher(name);
        teacher.setLastName(lastName);
        teacher.setCellphone(cellphone);
        teacher.setAddress(address);
        teacher.setEmail(email);

        int rows = teacherManager.updateById(teacher);
        System.out.println("Applied, " + rows + " affected");
    }


}
