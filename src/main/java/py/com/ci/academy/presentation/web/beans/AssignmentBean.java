package py.com.ci.academy.presentation.web.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import py.com.ci.academy.assignment.boundary.*;
import py.com.ci.academy.assignment.entities.Assignment;
/**
 *
 * @author CI-IAcosta
 */
@Named("assignmentBean")
@SessionScoped
public class AssignmentBean implements Serializable {

    private AssignmentManager  assignmentManager;
    private Assignment assignment;
    private List<Assignment> assignmentList;

    @PostConstruct
    public void init(){
        assignmentManager = new AssignmentManager();
        assignmentList = assignmentManager.getAll();
        assignment  = new Assignment();
        logAssigments();

    }

    private void logAssigments() {
        if ( assignmentList != null && !assignmentList.isEmpty())
        System.out.println("AssignmentBean  - init > "+ assignmentList.size());
        else
            System.out.println("AssignmentBean  - init > no result found");
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
