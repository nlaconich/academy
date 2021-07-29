package py.com.ci.academy.students.boundary;

import py.com.ci.academy.students.entities.Student;

import java.util.List;

public class TestStudentManagement {
    public static void main(String[] args) {
        StudentManager studentManager= new StudentManager();
        //Student student= new Student();

        /*student= studentManager.getById(2);
        System.out.println(student);*/



        List<Student> students= studentManager.getAll();
        for (Student student: students) {
            System.out.println(student);
        }
    }
}
