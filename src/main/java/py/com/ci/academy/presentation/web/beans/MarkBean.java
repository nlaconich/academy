/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ci.academy.presentation.web.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import py.com.ci.academy.product.boundary.MarkManager;
import py.com.ci.academy.product.entities.Mark;

/**
 *
 * @author jmendez
 */

@Named("markBean")
@SessionScoped
public class MarkBean implements Serializable {

    private MarkManager markManager;
    private Mark mark;
    private List<Mark> markList;

    @PostConstruct
    public void init() {

        markManager = new MarkManager();
        markList = markManager.getAll();
        mark = new Mark();
    }
        
    private void logMark() {
        if (markList != null && !markList.isEmpty()) {
            System.out.println("MarkBean  - init > " + markList.size());
        } else {
            System.out.println("MarkBean  - init > no result found");
        }
    }

    public List<Mark> getMarkList() {
        return markManager.getAll();
    }

    public void setMarktList(List<Mark> markList) {
        this.markList = markList;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }
    
    public void updateMark() {
        markManager.updateMark(mark);
        init();
    }
    
    public void deleteMark(){
       markManager.deleteById(mark);
       init();
    }

    public void agregarMark() {
        markManager.add(mark);
        init();

    }
        
        public void onSelect(SelectEvent event) {
                this.mark = (Mark) event.getObject();

        FacesMessage msg = new FacesMessage("Mark Selected id", String.valueOf(mark.getId_mark()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("MarkBean > Seleccionar Fila > " + this.mark);

    
    }

}
