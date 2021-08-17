/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.usuarios.boundary;

import business.dao.GenericImpl;
import business.usuarios.entity.Usuarios;
import business.utils.MD5Generator;
import business.utils.UtilLogger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author pinchi
 */
@Stateless
public class UsuariosManager extends GenericImpl<Usuarios, Integer> {
    
    public Usuarios authenticate(String username, String password) {
            try
            {
                @SuppressWarnings("unchecked")
//                List<Usuarios> usuarios = (List<Usuarios>) DaoFactory.getEm().createNamedQuery("Usuarios.findAll").getResultList();
                List<Usuarios> listaUsuarios = this.getAll();
                @SuppressWarnings("rawtypes")
                        
                String newPassword = MD5Generator.MD5(password);
                
               for( Usuarios us : listaUsuarios)
               {
                    if(null != us.getPassword() && us.getPassword().equals(newPassword) && us.getUsername().equals(username))
                    return us;
                    
                }
                return null;
            }
            catch(Exception ex)
            {
                UtilLogger.error("UsuariosImpl.authenticate", ex);
                return null;
            }   
    }
    
    public Usuarios getById(String id) {
        try {

            //String nroEntrada = String.valueOf(nro);
            Query query = em.createQuery("Usuarios.findByUsuarioId ").setParameter("usuarioId", id.trim());

            return ((Usuarios) query.getSingleResult());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".getById", e);
            return null;
        }
    }
    
}
