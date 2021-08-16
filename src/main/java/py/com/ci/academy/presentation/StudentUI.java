package py.com.ci.academy.presentation;

import py.com.ci.academy.students.boundary.StudentManager;
import py.com.ci.academy.students.entities.Student;

import java.util.List;
import java.util.Scanner;

public class StudentUI {
    Scanner sc = new Scanner(System.in);
    StudentManager studentManager = new StudentManager();
    Student student = new Student();

    public static void main(String[] args) {
        StudentUI test = new StudentUI();
        test.mainMenu();
    }

    public void mainMenu() {
        System.out.println("Welcome to Student Academy beta 0.0");
        System.out.println("----------------------------------------");
        System.out.println("Choose an option ");
        System.out.println("1 : List all students");
        System.out.println("2 : Add a student");
        System.out.println("3 : Delete a student");
        System.out.println("4 : Update a student");
        System.out.println("5 : Exit");
        System.out.print("Option: ");
        String option = sc.next();
        try {
            Integer selectedOption = Integer.parseInt(option);
            switch (selectedOption) {
                case 1:
                    listAllStudents();
                    break;
                case 2:
                    registerStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    return;
            }
            mainMenu();
        } catch (Exception ex) {

            mainMenu();
        }
    }

    public void listAllStudents() {
        List<Student> listStudents = studentManager.getAll();
        if (!listStudents.isEmpty()) {
            for (Student student : listStudents) {
                System.out.println(student);
            }
        } else {
            System.out.println("No student found");
        }
    }

    private void registerStudent() {

        sc.nextLine();
        System.out.println("Insert Name");
        String name = sc.nextLine();
        System.out.println("Insert Last Name");
        String lastName = sc.nextLine();
        System.out.println("Insert Phone");
        String cellphone = sc.nextLine();
        System.out.println("Insert Address");
        String address = sc.nextLine();
        System.out.println("Insert Mail");
        String email = sc.nextLine();

        student.setName(name);
        student.setLastName(lastName);
        student.setCellphone(cellphone);
        student.setAddress(address);
        student.setEmail(email);

        studentManager.add(student);
    }

    private void deleteStudent() {
        this.listAllStudents();

        System.out.println("Insert Id ");
        int id = sc.nextInt();
        student.setIdStudent(id);

        int rows = studentManager.deleteById(student);
        System.out.println("Applied, " + rows + " affected");
    }

    private void updateStudent() {
        int id = 0, rows = 0;
        String name = null, lastName = null, cellphone = null, address = null, email = null;

        this.listAllStudents();
        System.out.println("Insert Id ");
        id = sc.nextInt();

        sc.nextLine();
        System.out.println("Insert new Name");
        name = sc.nextLine();
        System.out.println("Insert new Last Name");
        lastName = sc.nextLine();
        System.out.println("Insert new Phone");
        cellphone = sc.nextLine();
        System.out.println("Insert new Address");
        address = sc.nextLine();
        System.out.println("Insert new Mail ");
        email = sc.nextLine();
        student.setIdStudent(id);
        student.setName(name);
        student.setLastName(lastName);
        student.setCellphone(cellphone);
        student.setAddress(address);
        student.setEmail(email);

        rows = studentManager.updateById(student);
        System.out.println("Applied, " + rows + " affected");
    }
}
