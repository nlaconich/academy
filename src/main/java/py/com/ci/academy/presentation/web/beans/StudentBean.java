/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ci.academy.presentation.web.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import py.com.ci.academy.assignment.boundary.*;
import py.com.ci.academy.students.boundary.StudentManager;
import py.com.ci.academy.students.entities.Student;

/**
 *
 * @author matias
 */
@Named("studentBean")
@SessionScoped
@ViewScoped

public class StudentBean implements Serializable {

    private StudentManager studentManager;
    private Student student;
    private List<Student> studentList;

    @PostConstruct
    public void init() {

        studentManager = new StudentManager();
        studentList = studentManager.getAll();
        student = new Student();
        logStudent();
    }

    private void logStudent() {
        if (studentList != null && !studentList.isEmpty()) {
            System.out.println("StudentBean  - init > " + studentList.size());
        } else {
            System.out.println("StudentBean  - init > no result found");
        }
    }

    public List<Student> getStudentList() {
        return studentManager.getAll();
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    public void updateStudent(Student student) {
        this.student = student;
    }
    
    public void deleteStudent(){
       studentManager.deleteById(student);
       init();
    }

    public void agregarStudent() {
        studentManager.add(student);
        init();

    }
}
