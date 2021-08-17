/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.usuarios.boundary.RolesManager;
import business.utils.MD5Generator;
import business.utils.UtilLogger;
import business.usuarios.boundary.UsuariosManager;
import business.usuarios.entity.Roles;
import business.usuarios.entity.Usuarios;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
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
public class UsuariosBean implements Serializable{
    
    private Usuarios usuario;    
    private List<Usuarios> usuarioList;
    private boolean bloquearBotones = true;
    private String password;
    private String repeadPassword;
    private List<Roles> rolesList;
    @Inject
    UsuariosManager usuariosMgr;
    @Inject
    RolesManager rolesMgr;
    
    
    
    public UsuariosBean(){
        
    }
    
    @PostConstruct
    public void init() {
        UtilLogger.info("Usuarios init: obteniendo lista de usuarios " );
        usuario = new Usuarios();
        usuarioList = new ArrayList<>();
        usuarioList = usuariosMgr.getAll();
        rolesList = new ArrayList<>();
        rolesList = rolesMgr.getAll();
        UtilLogger.info("Usuarios init: se econtranron " + usuarioList.size());
    }
    
    public String addUsuarios() {
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        try{
            
            if (null != usuario) {
                for (Usuarios usr : usuarioList) {
                    if (usr.getUsuario().trim().equalsIgnoreCase(usuario.getUsuario().trim())
                            && (usuario.getUsuarioId() == null || usuario.getUsuarioId() == 0)) {
                        context.addMessage(null, new FacesMessage("Advertencia",
                                "El usuario " + usuario.getUsername()
                                + " ya se encuentra registrado"));
                        RequestContext.getCurrentInstance().execute("PF('dlgUsuAdd').hide()");
                        return "usuarios";
                    }
                }      
             
//           usuario.setClave("-----");
//           usuario.setNivel(1); 
//           usuario.setAnula(BigInteger.ONE);
//           usuario.setElimina(BigInteger.ONE);
//           usuario.setCrea(BigInteger.ONE);
//           usuario.setModifica(BigInteger.ONE);
//           usuario.setCodbar("----");
//           usuario.setUsername("----");
           
                      
           if (usuario != null & usuario.getUsuarioId() == null)
            {
                usuario = usuariosMgr.add(usuario);
            }
            else if (usuario != null & usuario.getUsuarioId() >0)
            {
                usuario = usuariosMgr.update(usuario);
            }
                
                

            if (usuario != null) {
                if (null == usuario.getUsuarioId()) {
                    //cifrar password
                    usuario.setPassword(MD5Generator.MD5(usuario.getPassword()));
                    usuario = usuariosMgr.add(usuario);
                    usuarioList.add(usuario);
                } else {
                    usuario.setPassword(MD5Generator.MD5(usuario.getPassword()));
                    usuario = usuariosMgr.update(usuario);
                    usuarioList = usuariosMgr.getAll();
                }

                return "usuarios";
            }
            RequestContext.getCurrentInstance().execute("PF('dlgUsuAdd').hide()");
            if (null == usuario) {
                context.addMessage(null, new FacesMessage("Error",
                        "Ocurrió un error al intentar guardar el usuario "));
                return "usuarios";
            }
            }
                
        }
        catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el usuario "));
            UtilLogger.error("Problemas al insertar el usuario", e);
        } 
        return "usuarios";
    }
    
    public void borrar() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            usuariosMgr.delete(usuario);
            usuarioList = usuariosMgr.getAll();
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el usuario "));
            UtilLogger.error("Problemas al insertar la ciudad", e);
        }
    }
    
    public String delete() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            usuariosMgr.delete(usuario);
            ExternalContext eContext = FacesContext.getCurrentInstance().getExternalContext();
            eContext.redirect("usuarios.jsf");
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el usuario "));
            UtilLogger.error("Problemas al insertar la ciudad", e);
        }
        return "usuarios";
    }
    
    public void actionClean(ActionEvent actionEvent) {
        //addMessage("Welcome to Primefaces!!");
        usuario = new Usuarios();
        RequestContext.getCurrentInstance().update("usuario-form:dtUsuario");
    }
    
    public void onRowSelect(SelectEvent event) {
        this.usuario = (Usuarios) event.getObject();
        
        this.bloquearBotones = false;
        RequestContext.getCurrentInstance().update("usuario-form:dtUsuario");
        RequestContext.getCurrentInstance().update("usuario-form:dtUsuario:botonEditar");   
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public List<Usuarios> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuarios> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public boolean isBloquearBotones() {
        return bloquearBotones;
    }

    public void setBloquearBotones(boolean bloquearBotones) {
        this.bloquearBotones = bloquearBotones;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeadPassword() {
        return repeadPassword;
    }

    public void setRepeadPassword(String repeadPassword) {
        this.repeadPassword = repeadPassword;
    }

    public UsuariosManager getUsuariosMgr() {
        return usuariosMgr;
    }

    public void setUsuariosMgr(UsuariosManager usuariosMgr) {
        this.usuariosMgr = usuariosMgr;
    } 

    public List<Roles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Roles> rolesList) {
        this.rolesList = rolesList;
    }
    
}
