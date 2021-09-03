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
import py.com.ci.academy.courseassignment.boundary.CourseAssignmentManager;
import py.com.ci.academy.courseassignment.entities.CourseAssignment;

@Named("courseAssignmentBean")
@SessionScoped
public class CourseAssignmentBean implements Serializable {

    CourseAssignment courseAssignment;
    CourseAssignmentManager courseAssignmentManager;
    List<CourseAssignment> courseAssignmentList;

    @PostConstruct
    public void init() {
        courseAssignment = new CourseAssignment();
        courseAssignmentManager = new CourseAssignmentManager();
        courseAssignmentList = courseAssignmentManager.getAll();

        logAssignmentC();
        RequestContext.getCurrentInstance().update("courseAssignment-form:dtCourseAssignment");
    }

    public void logAssignmentC() {
        if (courseAssignmentList != null && !courseAssignmentList.isEmpty()) {
            System.out.println("CourseassignmentBean  - init > " + courseAssignmentList);
        } else {
            System.out.println("CourseassignmentBean  - init > no result fount");
        }
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
    }

    public void updateCourseAssignment() {
        courseAssignmentManager.updateCourseAssignment(courseAssignment);
    }

    public void deleteCourseAssignment() {
        courseAssignmentManager.deleteCourseAssignment(courseAssignment);
    }

    //------------TABLE MANAGEMENT
    public void onRowSelected(SelectEvent event) {
        this.courseAssignment = (CourseAssignment) event.getObject();

        FacesMessage msg = new FacesMessage("Course/Assignment Selected id", String.valueOf(courseAssignment.getIdCourseAssignment()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("CourseAssingmentBean > Select Row > " + this.courseAssignment);

    }

}
