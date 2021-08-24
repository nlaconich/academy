/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.usuarios.boundary;

import business.dao.GenericImpl;
import business.usuarios.entity.Roles;
import business.usuarios.entity.RolesPantallas;
import business.utils.UtilLogger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author pinchi
 */
@Stateless
public class RolesPantallasManager extends GenericImpl<RolesPantallas, Integer>{
    
     public List<RolesPantallas> getRolesByRolesPantallas(Roles rol)
   {
        try {            
            Query query = em.createQuery("SELECT r FROM RolesPantallas r WHERE r.rolId.rolId =:rolId").setParameter("rolId", rol.getRolId());
            
            return ((List<RolesPantallas>) query.getResultList());
            
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName()+ ".getByNombre", e);
            return null;
        }   
   }
}
