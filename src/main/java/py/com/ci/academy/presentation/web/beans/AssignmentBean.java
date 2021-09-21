package py.com.ci.academy.presentation.web.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import py.com.ci.academy.assignment.boundary.*;
import py.com.ci.academy.assignment.entities.Assignment;
import py.com.ci.academy.courseassignment.boundary.CourseAssignmentManager;

/**
 *
 * @author CI-IAcosta
 */
@Named("assignmentBean")
@SessionScoped
public class AssignmentBean implements Serializable {

    private AssignmentManager assignmentManager;
    private Assignment assignment;
    private List<Assignment> assignmentList;
    private CourseAssignmentManager cxa;

    @PostConstruct
    public void init() {
        assignmentManager = new AssignmentManager();
        assignmentList = assignmentManager.getAll();
        assignment = new Assignment();
        cxa = new CourseAssignmentManager();

    }
    @Inject
    CourseBean courseBean;
    
    public void generateAssignmentList() { 
        System.out.println(courseBean.getCourse().getCourseId());
        assignmentList = cxa.getAssignmentByIdCourse(courseBean.getCourse().getCourseId());
        System.out.println(assignmentList);
        
    }

    private void logAssigments() {
        if (assignmentList != null && !assignmentList.isEmpty()) {
            System.out.println("AssignmentBean  - init > " + assignmentList.size());
        } else {
            System.out.println("AssignmentBean  - init > no result found");
        }
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

    public void agregarAssigment() {
        assignmentManager.addAssignment(assignment);
        init();

    }
}
