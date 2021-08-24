/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.productos.boundary;

import business.dao.GenericImpl;
import business.productos.entity.TipoProducto;
import business.utils.UtilLogger;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author pinchi
 */
@Stateless
public class TipoProductoManager extends GenericImpl<TipoProducto, Integer>{
    
    public TipoProducto getByNombre(String tipoProducto) {
        
        try {            
            Query query = em.createNamedQuery("TipoProducto.findByTipoProducto").setParameter("tipoProducto", tipoProducto);
            return ((TipoProducto) query.getSingleResult());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName()+ ".getByNombre", e);
            return null;
        }
    }
    
}
