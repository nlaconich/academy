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
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import py.com.ci.academy.courseassignment.boundary.CourseAssignmentManager;
import py.com.ci.academy.courseassignment.entities.CourseAssignment;
import py.com.ci.academy.inscription.boundary.InscriptionManager;
import py.com.ci.academy.inscription.entities.Inscription;

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
    private CourseAssignmentManager courseAssignmentManager;
    private CourseAssignment courseAssignment;

    @PostConstruct
    public void init() {
        inscriptionManager = new InscriptionManager();
        inscriptionList = inscriptionManager.getAll();
        inscription = new Inscription();
        logInscription();

    }

    private void logInscription() {
        if (inscriptionList != null && !inscriptionList.isEmpty()) {
            System.out.println("InscriptionBean  - init > " + inscriptionList.size());
        } else {
            System.out.println("StudentBean  - init > no result found");
        }
    }

//    public String getAssignment() {
//        return courseAssignment.();
//    }

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

    public void agregarInscription() {
        inscriptionManager.addInscription(inscription);
        init();

    }

    public void onSelect(SelectEvent event) {
        this.inscription = (Inscription) event.getObject();

        FacesMessage msg = new FacesMessage("Inscription Selected id", String.valueOf(inscription.getIdInscription()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("InscriptionBean > Seleccionar Fila > " + this.inscription);

    }

}
