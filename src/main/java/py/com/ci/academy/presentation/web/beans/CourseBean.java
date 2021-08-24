package py.com.ci.academy.presentation.web.beans;

import py.com.ci.academy.course.boundary.CourseManager;
import py.com.ci.academy.course.entities.Course;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("courseBean")
@SessionScoped

public class CourseBean implements Serializable {
    private List<Course> courseList;
    private Course course;
    private CourseManager courseManager= new CourseManager();

    @PostConstruct
    public void init(){
        course= new Course();
        courseList= courseManager.getAll();
        logCourses();
    }

    public void logCourses(){
        if (courseList != null && !courseList.isEmpty()){
            System.out.println("CourseBean  - init > "+ courseList);
        }else{
            System.out.println("CourseBean  - init > no result fount");
        }
    }
    public  void addCourse(Course course){
        courseManager.addCourse(course);
        init();
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
}
