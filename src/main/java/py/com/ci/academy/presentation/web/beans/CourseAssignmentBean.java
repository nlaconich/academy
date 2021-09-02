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

/**
 *
 * @author matias
 */
@Named("courseAssignmentBean")
@SessionScoped
public class CourseAssignmentBean implements Serializable {

    private CourseAssignmentManager  courseAssignmentManager;
    private CourseAssignment courseAssignment;
    private List<CourseAssignment> courseAssignmentList;

    @PostConstruct
    public void init(){
        courseAssignmentManager = new CourseAssignmentManager();
        courseAssignmentList = courseAssignmentManager.getAll();
        courseAssignment  = new CourseAssignment();
        logAssigments();

    }

    private void logAssigments() {
        if ( courseAssignmentList != null && !courseAssignmentList.isEmpty())
        System.out.println("AssignmentBean  - init > "+ courseAssignmentList.size());
        else
            System.out.println("AssignmentBean  - init > no result found");
    }

    public List<CourseAssignment> getCourseAssignmentList() {
        return courseAssignmentList;
    }

    public void setCourseAssignmentList(List<CourseAssignment> courseAssignmentList) {
        this.courseAssignmentList = courseAssignmentList;
    }

    public CourseAssignment getCourseAssignment() {
        return courseAssignment;
    }

    public void setCourseAssignment(CourseAssignment courseAssignment) {
        this.courseAssignment = courseAssignment;
    }
   public void agregarCourseAssigment() {
    courseAssignmentManager.addCourseAssignment(courseAssignment);   
    init();
        
    }
}
