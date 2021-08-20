package py.com.ci.academy.presentation.web.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import py.com.ci.academy.teacher.boundary.TeacherManager;
import py.com.ci.academy.teacher.entities.Teacher;

/**
 *
 * @author martin
 */
@Named("teacherBean")
@SessionScoped
public class TeacherBean implements Serializable {

    private TeacherManager teacherManager;
    private Teacher teacher;
    private List<Teacher> teacherList;

    @PostConstruct
    public void init(){
        teacherManager = new TeacherManager();
        teacherList = teacherManager.getAll();
        teacher = new Teacher();
        logTeacher();

    }

    private void logTeacher() {
        if ( teacherList != null && !teacherList.isEmpty())
        System.out.println("TeacherBean  - init > "+ teacherList.size());
        else
            System.out.println("TeacherBean  - init > no result found");
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
   public String agregarTeacher() {
       System.out.println("Add Teacher");
init();
        return "";
    }
}
