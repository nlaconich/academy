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
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import py.com.ci.academy.teacher.entities.Teacher;

@Named("courseBean")
@SessionScoped
public class CourseBean implements Serializable {
    private List<Course> courseList;
    private Course course;
    private CourseManager courseManager;

    @PostConstruct
    public void init(){
        courseManager= new CourseManager();
        courseList= courseManager.getAll();
        course= new Course();
        logCourses();
        RequestContext.getCurrentInstance().update("course-form:dtCourse");
    }

    public void logCourses(){
        if (courseList != null && !courseList.isEmpty()){
            System.out.println("CourseBean  - init > "+ courseList);
        }else{
            System.out.println("CourseBean  - init > no result fount");
        }
    }
   
    public List<Course> getCourseList() {
        init();
        return this.courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public Course getCourse(int courseId) {
        for (Course course1 : courseList) {
            if(course1.getCourseId() == courseId) return course1;
        }
        return null;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
    ///C R U D
    public  void addCourse(){
        courseManager.addCourse(course);
        init();
    }
    
    public void deleteCourse(){
        courseManager.deleteCourse(course);
        init();
    }
    
    public void updateCourse(){
        courseManager.updateCourse(course);
        init();
    }
    
    ///TABLE MANAGEMENT
    
    public void onRowSelected(SelectEvent event) {
                this.course = (Course) event.getObject();

        FacesMessage msg = new FacesMessage("Course Selected id", String.valueOf(course.getCourseId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("CourseBean > Seleccionar Fila > " + this.course);

    }
    
    
}
