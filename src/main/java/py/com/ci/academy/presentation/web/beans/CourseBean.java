package py.com.ci.academy.presentation.web.beans;

import py.com.ci.academy.course.boundary.CourseManager;
import py.com.ci.academy.course.entities.Course;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import py.com.ci.academy.teacher.boundary.TeacherManager;
import py.com.ci.academy.teacher.entities.Teacher;

@Named("courseBean")
@SessionScoped
public class CourseBean implements Serializable {
    
    
    private List<Integer> teacherList;
    private Teacher teacher;
    private TeacherManager teacherManager;
    
    private List<Course> courseList;
    private Course course;
    private CourseManager courseManager;

    @PostConstruct
    public void init() {
        courseManager = new CourseManager();
        courseList = courseManager.getAll();
        course = new Course();
        
        teacher= new Teacher();
        teacherManager= new TeacherManager();
        teacherList= teacherManager.getTeacherId();
        
        logCourses();
        RequestContext.getCurrentInstance().update("course-form:dtCourse");
    }

    public void logCourses() {
        if (courseList != null && !courseList.isEmpty()) {
            System.out.println("CourseBean  - init > " + courseList);
        } else {
            System.out.println("CourseBean  - init > no result fount");
        }
    }

    public List<Integer> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Integer> teacherList) {
        this.teacherList = teacherList;
    }

    

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    
    
    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    //---------C R U D
    public void addCourse() {
        courseManager.addCourse(course);
        init();
    }

    public void deleteCourse() {
        courseManager.deleteCourse(course);
        init();
    }

    public void updateCourse() {
        courseManager.updateCourse(course);
        init();
    }
    
    public void confirm() {
        addMessage("Confirmed", "You have accepted");
    }

    public void deleteDialog() {
        deleteCourse();
        addMessage("Confirmed", "Record deleted");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    //---------TABLE MANAGEMENT
    public void onRowSelected(SelectEvent event) {
        this.course = (Course) event.getObject();

        FacesMessage msg = new FacesMessage("Course Selected id", String.valueOf(course.getCourseId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("CourseBean > Select Row > " + this.course);

    }

}
