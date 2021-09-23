package py.com.ci.academy.inscription.controller;

import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import py.com.ci.academy.assignment.entities.Assignment;
import py.com.ci.academy.course.entities.Course;
import py.com.ci.academy.courseassignment.boundary.CourseAssignmentManager;
import py.com.ci.academy.inscription.boundary.InscriptionManager;
import py.com.ci.academy.inscription.entities.Inscription;
import py.com.ci.academy.students.entities.Student;

/**
 *
 * @author matias
 */
@Named

public class InscriptionController {

    private List<Inscription> inscriptionList;
    private Inscription inscription;
    private CourseAssignmentManager courseAssignmentManager = new CourseAssignmentManager();
    private InscriptionManager inscriptionManager = new InscriptionManager();
    static final int MAX_INSCRIPTIONS = 30;

    @PostConstruct
    public void init() {
        inscriptionList = inscriptionManager.getAll();
        inscription = new Inscription();
    }

    public List<Assignment> getAssignmentByIdCourse(int courseId) {
        init();
        List<Assignment> assignmentList = courseAssignmentManager.getAssignmentByIdCourse(courseId);
        return assignmentList;
    }

    public boolean inscriptionIsFull() {
        init();
        return inscriptionList.size() != MAX_INSCRIPTIONS;
    }

    public void newInscription(Student student, Course course, Assignment assignment) throws SQLException {
        if (inscriptionIsFull()) {
            inscription.setIdStudent(student.getIdStudent());
            inscription.setNameStudent(student.getName());
            inscription.setIdAssignment(assignment.getIdAssignment());
            inscription.setNameAssignment(assignment.getNameAssignment());
            inscription.setNameCourse(course.getCourseName());
            inscription.setIdCourse(course.getCourseId());
            inscription.setIdCxA(courseAssignmentManager.obtainCourseAssignmentId(course.getCourseId(), assignment.getIdAssignment()));
            System.out.println("INSCRIPTION TEST: " + inscription);
            inscriptionManager.addInscription(inscription);
        }else {System.out.println("INSCRIPTION IS FULL");}

    }
}
