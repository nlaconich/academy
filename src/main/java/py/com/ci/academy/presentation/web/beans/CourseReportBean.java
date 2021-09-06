package py.com.ci.academy.presentation.web.beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import py.com.ci.academy.course.boundary.CourseReportManager;
import py.com.ci.academy.course.entities.CourseReport;

@Named("courseReportBean")
@SessionScoped
public class CourseReportBean {
    CourseReport courseReport;
    CourseReportManager courseReportManager;
    List<CourseReport> courseReportList;
    
    @PostConstruct
    public void init(){
        
        courseReport= new CourseReport();
        courseReportManager= new CourseReportManager();
        courseReportList= courseReportManager.getAll();
        
        logReport();
    }
    
    public void logReport() {
        if (courseReportList != null && !courseReportList.isEmpty()) {
            System.out.println("CourseReportBean  - init > " + courseReportList);
        } else {
            System.out.println("CourseReportBean  - init > no result fount");
        }
    }

    public CourseReport getCourseReport() {
        return courseReport;
    }

    public void setCourseReport(CourseReport courseReport) {
        this.courseReport = courseReport;
    }

    public List<CourseReport> getCourseReportList() {
        return courseReportList;
    }

    public void setCourseReportList(List<CourseReport> courseReportList) {
        this.courseReportList = courseReportList;
    }
    
}
