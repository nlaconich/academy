package py.com.ci.academy.presentation.web.beans;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import py.com.ci.academy.teacher.boundary.TeacherManager;
import py.com.ci.academy.teacher.entities.Teacher;

/**
 *
 * @author martin
 */
@Named("teacherBean")
@SessionScoped
public class TeacherBean implements Serializable {


    private Teacher teacher;
    private TeacherManager teacherManager;
    private List<Teacher> teacherList;

    @PostConstruct
    public void init(){
        teacherManager= new TeacherManager();
        teacherList= teacherManager.getAll();
        teacher= new Teacher();
        logTeacher();

    }
    
    public  void addTeacher(){
        teacherManager.add(teacher);
        init();    
    }
    
    public void updateTeacher(){
        teacherManager.updateTeacher(teacher);
        init();
    }
        
    public void deleteTeacher(){
        teacherManager.deleteTeacher(teacher);
        init();
    }

    public void logTeacher(){
        if (teacherList != null && !teacherList.isEmpty()){
            System.out.println("TeacherBean  - init > "+ teacherList);
        }else{
            System.out.println("TeacherBean  - init > no result fount");
        }
    }
    
    public void alSeleccionarFila(SelectEvent event) {
                this.teacher = (Teacher) event.getObject();

        FacesMessage msg = new FacesMessage("Teacher Selected ", String.valueOf(teacher.getIdTeacher()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("TeachersBean > Seleccionar Fila > " + this.teacher);

    }
    
    
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }  
    
    
    
}

