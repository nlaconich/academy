/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.usuarios.boundary.RolesManager;
import business.usuarios.entity.Roles;
import business.utils.UtilLogger;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author pinchi
 */
@Model
public class RolesBean implements Serializable{
    
    private Roles rol;
    private List<Roles> rolesList;
    private boolean bloquearBotones = true;
    
    @Inject
    RolesManager rolesMgr;
    
    public RolesBean(){
        
    }
    
    @PostConstruct
    public void init() {
        UtilLogger.info("Roles init: obteniendo lista de los roles " );
        limpVariable();
        
        UtilLogger.info("Roles init: se econtraron " + rolesList.size());
    }
    
    public void limpVariable(){
        
        rol = new Roles();
        rolesList = rolesMgr.getAll();   
    }
    
    public String agregarRoles() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {

            if (null != rol) {
                for (Roles roles : rolesList) {
                    if (roles.getDescripcion().trim().equalsIgnoreCase(rol.getDescripcion().trim())
                            && (rol.getRolId()== null || rol.getRolId()== 0)) {
                            context.addMessage(null, new FacesMessage("Advertencia",
                                "La rol " + rol.getDescripcion()
                                + " ya se encuentra registrado"));
                        RequestContext.getCurrentInstance().execute("PF('dlgRolAdd').hide()");
                        return "rol";
                    }
                }
                if (rol != null & rol.getRolId()== null)
                {
                    rol = rolesMgr.add(rol);
                }
                else if (rol != null & rol.getRolId()>0)
                {
                    rol = rolesMgr.update(rol);
                }
            }               
        } catch (Exception e) {
        context.addMessage(null, new FacesMessage("Error",
                "Ocurrió un error al intentar guardar la rol "));
        UtilLogger.error("Problemas al insertar el rol", e);
        }
        RequestContext.getCurrentInstance().update("rol-form:dtRol");
        return "roles";
    }
    
    public String update() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {

            rolesMgr.update(rol);

            ExternalContext eContext = FacesContext.getCurrentInstance().getExternalContext();
            eContext.redirect("roles.jsf");

        } catch (Exception e) {

            context.addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar actualizar el rol"));
            UtilLogger.error("Problemas al insertar el rol", e);
        }

        return "rol";
    }
    
    public void actionClean(ActionEvent actionEvent) {
        
        this.rol = new Roles();
        RequestContext.getCurrentInstance().update("rol-form:dtRol");
    }
    
    public void alSeleccionarRoles(SelectEvent event) {
        this.rol = (Roles) event.getObject();
        
        
        this.bloquearBotones = false;
        RequestContext.getCurrentInstance().update("rol-form:dtRol");
        RequestContext.getCurrentInstance().update("rol-form:dtRol:botonEditar");          
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public List<Roles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Roles> rolesList) {
        this.rolesList = rolesList;
    }

    public boolean isBloquearBotones() {
        return bloquearBotones;
    }

    public void setBloquearBotones(boolean bloquearBotones) {
        this.bloquearBotones = bloquearBotones;
    }
}
