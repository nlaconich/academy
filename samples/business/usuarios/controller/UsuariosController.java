/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.usuarios.controller;

import business.usuarios.boundary.UsuariosManager;
import business.usuarios.entity.Usuarios;
import business.utils.MD5Generator;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.apache.log4j.Logger;

/**
 *
 * @author cbustamante
 */
@Stateless
public class UsuariosController {
      
    private transient Logger logger; 
    
    @Inject
    UsuariosManager usuariosMgr;

    public UsuariosController() {
    }
    
    public UsuariosController(UsuariosManager usuarioMgr){
        this.usuariosMgr = usuarioMgr;
    }
    
     public Usuarios authenticate(String username, String password) {
            try
            {
                @SuppressWarnings("unchecked")
                List<Usuarios> usuarios = usuariosMgr.getAll();
                @SuppressWarnings("rawtypes")
                        
                String newPassword = MD5Generator.MD5(password);
                
                Iterator it = usuarios.iterator();
                while (it.hasNext()) {
                        Usuarios us = (Usuarios) it.next();
                        if(us.getPassword().equals(newPassword) && us.getUsername().equals(username)){
                                return us;
                        }
                }
                return null;
            }
            catch(Exception ex)
            {
                logger.error("UsuariosImpl.authenticate", ex);
                return null;
            }
            
    }
   
        
            
     
}
