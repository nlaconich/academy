/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ci.academy.presentation.web.beans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;
import py.com.ci.academy.assignment.entities.Assignment;
import py.com.ci.academy.course.entities.Course;
import py.com.ci.academy.courseassignment.boundary.CourseAssignmentManager;
import py.com.ci.academy.courseassignment.entities.CourseAssignment;
import py.com.ci.academy.inscription.boundary.InscriptionManager;
import py.com.ci.academy.inscription.controller.InscriptionController;
import py.com.ci.academy.inscription.entities.Inscription;
import py.com.ci.academy.students.entities.Student;

/**
 *
 * @author matias
 */
@Named("inscriptionBean")
@SessionScoped
@ViewScoped

public class InscriptionBean implements Serializable {

    private InscriptionManager inscriptionManager;
    private Inscription inscription;
    private List<Inscription> inscriptionList;
    private InscriptionController inscriptionController;
//    private Student student;
//    private Course course;
//    private Assignment assignment;
    

    @PostConstruct
    public void init() {
        inscriptionManager = new InscriptionManager();
        inscriptionList = inscriptionManager.getAll();
        inscription = new Inscription();
        inscriptionController = new InscriptionController();
//        student = studentBean.getStudent();
//        course = courseBean.getCourse();
//        assignment = assignmentBean.getAssignment();
        logInscription();

    }
    @Inject
    StudentBean studentBean;
    @Inject
    CourseBean courseBean;
    @Inject
    AssignmentBean assignmentBean;

    private void logInscription() {
        if (inscriptionList != null && !inscriptionList.isEmpty()) {
            System.out.println("InscriptionBean  - init > " + inscriptionList.size());
        } else {
            System.out.println("StudentBean  - init > no result found");
        }
    }

    public List<Inscription> getInscriptiontList() {
        return inscriptionList;
    }

    public void setInscriptionList(List<Inscription> studentList) {
        this.inscriptionList = inscriptionList;
    }

    public Inscription getInscription() {
        return inscription;
    }

    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }

    public void updateInscription() {
        inscriptionManager.updateInscription(inscription);
        init();
    }

    public void deleteInscription() {
        inscriptionManager.updateInscription(inscription);
        init();
    }

    public void newInscription() throws SQLException {
        inscriptionController.newInscription(studentBean.getStudent(), courseBean.getCourse(), assignmentBean.getAssignment());
    }

    public void onSelect(SelectEvent event) {
        this.inscription = (Inscription) event.getObject();
        FacesMessage msg = new FacesMessage("Inscription Selected id", String.valueOf(inscription.getIdInscription()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("InscriptionBean > Seleccionar Fila > " + this.inscription);

    }

}
