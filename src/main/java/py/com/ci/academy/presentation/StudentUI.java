package py.com.ci.academy.presentation;

import py.com.ci.academy.students.boundary.StudentManager;
import py.com.ci.academy.students.entities.Student;

import java.util.List;
import java.util.Scanner;

public class StudentUI {
    Scanner sc= new Scanner(System.in);
    StudentManager studentManager= new StudentManager();
    public static void main(String[] args) {
        StudentUI test = new StudentUI();
        test.mainMenu();
    }
    private  void mainMenu(){
        System.out.println("Welcome to Student Academy beta 0.0");
        System.out.println("----------------------------------------");
        System.out.println("Choose an option ");
        System.out.println("1 : List all students");
        System.out.println("2 : Add a student");
        System.out.println("3 : Delete a student");
        System.out.println("4 : Update a student");
        System.out.println("5 : Exit");
        System.out.println("Option: ___");
        String option =     sc.next();
        try{
            Integer selectedOption = Integer.parseInt(option);
            switch (selectedOption){
                case 1:
                    //DoList
                    listAllStudents();
                    break;
                case 2:
                    registerStudent();
                    break;
                case 5:
                    return;
            }
            mainMenu();
        }catch (Exception ex){
            mainMenu();
        }
    }
    private  void listAllStudents() {
        List<Student> listStudents = studentManager.getAll();
        if (!listStudents.isEmpty()){
            for(Student student : listStudents){
                System.out.println("Name: " + student.getName() );
            }
        }
        else{
            System.out.println("No student found");
        }
    }
    private  void registerStudent() {
        String name = "", lastName = null, cellphone = null, address = null, email = null;

        System.out.println("Introduzca nombre");
        name= sc.next();
        System.out.println("Introduzca apellido");
        lastName= sc.next();
        System.out.println("Introduzca telefono");
        cellphone= sc.next();
        System.out.println("Introduzca direccion");
        address= sc.next();
        System.out.println("Introduzca email");
        email= sc.next();
        Student student = new Student();
        student.setName(name);
        student.setLastName(lastName);
        student.setCellphone(cellphone);
        student.setAddress(address);
        student.setEmail(email);

        studentManager.add(student);
    }
}
