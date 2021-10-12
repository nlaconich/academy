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
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import py.com.ci.academy.students.boundary.StudentManager;
import py.com.ci.academy.students.entities.Student;

/**
 *
 * @author matias
 */
@Named("studentBean")
@SessionScoped
public class StudentBean implements Serializable {

    private StudentManager studentManager;
    private Student student;
    private List<Student> studentList;

    @PostConstruct
    public void init() {

        studentManager = new StudentManager();
        studentList = studentManager.getAll();
        student = new Student();
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
    
    public void updateStudent() {
        studentManager.updateById(student);
        init();
    }
    
    public void deleteStudent(){
       studentManager.deleteById(student);
       init();
    }

    public void agregarStudent() {
        studentManager.add(student);
        init();

    }
        
        public void onSelect(SelectEvent event) {
                this.student = (Student) event.getObject();

        FacesMessage msg = new FacesMessage("Student Selected id", String.valueOf(student.getIdStudent()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("StudentBean > Seleccionar Fila > " + this.student);

    }
}
