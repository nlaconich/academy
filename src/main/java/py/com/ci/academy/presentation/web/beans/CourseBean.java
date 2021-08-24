package py.com.ci.academy.presentation.web.beans;

import py.com.ci.academy.course.boundary.CourseManager;
import py.com.ci.academy.course.entities.Course;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;

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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
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
}
