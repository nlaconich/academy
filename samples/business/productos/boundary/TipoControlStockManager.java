/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.productos.boundary;

import business.dao.GenericImpl;
import business.productos.entity.TipoControlStock;
import business.utils.UtilLogger;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author pinchi
 */
@Stateless
public class TipoControlStockManager extends GenericImpl<TipoControlStock, Integer>{
    
     public TipoControlStock getByNombre(String tipoControlStock) {
        
        try {            
            Query query = em.createNamedQuery("TipoControlStock.findByDescripcion").setParameter("descripcion", tipoControlStock);
            return ((TipoControlStock) query.getSingleResult());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName()+ ".getByNombre", e);
            return null;
        }
    }
    
}
