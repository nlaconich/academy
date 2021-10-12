/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ci.academy.presentation.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import py.com.ci.academy.assignment.boundary.AssignmentManager;
import py.com.ci.academy.assignment.entities.Assignment;
import py.com.ci.academy.courseassignment.boundary.CourseAssignmentManager;
import py.com.ci.academy.courseassignment.entities.CourseAssignment;
import py.com.ci.academy.inscription.controller.InscriptionController;

/**
 *
 * @author matias
 */
@Named("courseAssignmentBean")
@SessionScoped
public class CourseAssignmentBean implements Serializable {

    private CourseAssignmentManager courseAssignmentManager;
    private CourseAssignment courseAssignment;
    private List<CourseAssignment> courseAssignmentList;
    private AssignmentManager assignmentManager;
    private List<Assignment> assignmentList;
    private Assignment assignment;
    private InscriptionController inscriptionController;

    @PostConstruct
    public void init() {
        courseAssignmentManager = new CourseAssignmentManager();
        courseAssignmentList = courseAssignmentManager.getAll();
        courseAssignment = new CourseAssignment();
        assignmentList = new ArrayList<Assignment>();
        assignmentManager = new AssignmentManager();
        assignment = new Assignment();
        inscriptionController = new InscriptionController();
    }

    public void generateAssignmentList() {
        assignmentList = inscriptionController.getAssignmentByIdCourse(courseAssignment.getIdCourse());
    }

    private void logAssigments() {
        if (courseAssignmentList != null && !courseAssignmentList.isEmpty()) {
            System.out.println("AssignmentBean  - init > " + courseAssignmentList.size());
        } else {
            System.out.println("AssignmentBean  - init > no result found");
        }
    }

    public List<CourseAssignment> getCourseAssignmentList() {
        return courseAssignmentList;
    }

    public List<Assignment> getAssignmentList() {
        return assignmentList;
    }

    public void setAssignmentList(List<Assignment> assignmentList) {
        this.assignmentList = assignmentList;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
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

    public CourseAssignmentManager getCourseAssignmentManager() {
        return courseAssignmentManager;
    }

    public void setCourseAssignmentManager(CourseAssignmentManager courseAssignmentManager) {
        this.courseAssignmentManager = courseAssignmentManager;
    }

    public AssignmentManager getAssignmentManager() {
        return assignmentManager;
    }

    public void setAssignmentManager(AssignmentManager assignmentManager) {
        this.assignmentManager = assignmentManager;
    }
    
    

    public void agregarCourseAssigment() {
        courseAssignmentManager.addCourseAssignment(courseAssignment);
        init();

    }
}
