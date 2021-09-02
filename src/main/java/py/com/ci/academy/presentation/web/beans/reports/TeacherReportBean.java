/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ci.academy.presentation.web.beans.reports;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import py.com.ci.academy.teacher.boundary.TeacherReportManager;
import py.com.ci.academy.teacher.entities.TeacherReport;

/**
 *
 * @author martin
 */
@Named("teacherReportBean")
@SessionScoped
public class TeacherReportBean implements Serializable {


    private TeacherReport teacherReport;
    private TeacherReportManager teacherReportManager;
    private List<TeacherReport> teacherReportList;

    @PostConstruct
    public void init(){
        teacherReportManager = new TeacherReportManager();
        teacherReport = new TeacherReport();
        teacherReportList = teacherReportManager.getAll();
        logTeacherReport();
        RequestContext.getCurrentInstance().update("teacherReport-form:dtTeachersReport");
    }
    
        public void logTeacherReport(){
        if (teacherReport != null ){
            System.out.println("TeacherReportBean  - init > "+ teacherReport);
        }else{
            System.out.println("TeacherReportBean  - init > no result fount");
        }
    }

  
        
    public TeacherReport getTeacherReport() {
        return teacherReport;
    }

    public void setTeacherReport(TeacherReport teacherReport) {
        this.teacherReport = teacherReport;
    }

    public List<TeacherReport> getTeacherReportList() {
        return teacherReportList;
    }

    public void setTeacherReportList(List<TeacherReport> teacherReportList) {
        this.teacherReportList = teacherReportList;
    }
        
  public void alSeleccionarFila(SelectEvent event) {
                this.teacherReport = (TeacherReport) event.getObject();

        FacesMessage msg = new FacesMessage("Teacher Report Selected id", String.valueOf(teacherReport.getIdTeacher()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("TeachersReportBean > Seleccionar Fila > " + this.teacherReport);

    }      
    
}
