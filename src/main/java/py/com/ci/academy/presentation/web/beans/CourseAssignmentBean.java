package py.com.ci.academy.presentation.web.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import py.com.ci.academy.assignment.boundary.AssignmentManager;
import py.com.ci.academy.assignment.entities.Assignment;
import py.com.ci.academy.course.boundary.CourseManager;
import py.com.ci.academy.course.entities.Course;
import py.com.ci.academy.courseassignment.boundary.CourseAssignmentManager;
import py.com.ci.academy.courseassignment.entities.CourseAssignment;

/**
 *
 * @author matias
 */
@Named("courseAssignmentBean")
@SessionScoped
public class CourseAssignmentBean implements Serializable {

    Course course;
    CourseManager courseManager;
    List<Course> courseList;
    
    Assignment assignment;
    AssignmentManager assignmentManager;
    List<Assignment> assignmentList;
    
    CourseAssignment courseAssignment;
    CourseAssignmentManager courseAssignmentManager;
    List<CourseAssignment> courseAssignmentList;

    @PostConstruct
    public void init() {
        courseAssignment = new CourseAssignment();
        courseAssignmentManager = new CourseAssignmentManager();
        courseAssignmentList = courseAssignmentManager.getAll();
        courseAssignment  = new CourseAssignment();
        logAssignments();
        
        course = new Course();
        courseManager = new CourseManager();
        courseList = courseManager.getAll();
        
        assignment = new Assignment();
        assignmentManager = new AssignmentManager();
        assignmentList = assignmentManager.getAll();

        logAssignments();
        RequestContext.getCurrentInstance().update("courseAssignment-form:dtCourseAssignment");
    }

    public void logAssignments() {
        if (courseAssignmentList != null && !courseAssignmentList.isEmpty()) {
            System.out.println("CourseassignmentBean  - init > " + courseAssignmentList);
        } else {
            System.out.println("CourseassignmentBean  - init > no result fount");
        }
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public List<Assignment> getAssignmentList() {
        return assignmentList;
    }

    public void setAssignmentList(List<Assignment> assignmentList) {
        this.assignmentList = assignmentList;
    }

    public CourseAssignment getCourseAssignment() {
        return courseAssignment;
    }

    public void setCourseAssignment(CourseAssignment courseAssignment) {
        this.courseAssignment = courseAssignment;
    }

    public List<CourseAssignment> getCourseAssignmentList() {
        return courseAssignmentList;
    }

    public void setCourseAssignmentList(List<CourseAssignment> courseAssignmentList) {
        this.courseAssignmentList = courseAssignmentList;
    }

    //------------CRUD
    public void addCourseAssignment() {
        courseAssignmentManager.addCourseAssignment(courseAssignment);
        init();
    }

    public void updateCourseAssignment() {
        courseAssignmentManager.updateCourseAssignment(courseAssignment);
        init();
    }

    public void deleteCourseAssignment() {
        courseAssignmentManager.deleteCourseAssignment(courseAssignment);
        init();
    }

    //------------TABLE MANAGEMENT
    public void onRowSelected(SelectEvent event) {
        this.courseAssignment = (CourseAssignment) event.getObject();

        FacesMessage msg = new FacesMessage("Course/Assignment Selected id", String.valueOf(courseAssignment.getIdCourseAssignment()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("CourseAssingmentBean > Select Row > " + this.courseAssignment);

    }

}
