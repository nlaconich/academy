/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.productos.boundary;

import business.dao.GenericImpl;
import business.productos.entity.Iva;
import business.utils.UtilLogger;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.inject.Stereotype;
import javax.persistence.Query;

/**
 *
 * @author pinchi
 */
@Stateless
public class IvaManager extends GenericImpl<Iva, Integer>{
    
    public Iva getByNombre(String iva) {
        try {
            
            Query query = em.createNamedQuery("Iva.findByIva").setParameter("iva", iva);
            return ((Iva) query.getSingleResult());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName()+ ".getByNombre", e);
            return null;
        }
    }
    
    public List<Iva> getIvaByQuery(String query){
        try {
            Query q = em.createQuery("SELECT i FROM Iva i WHERE i.iva like '%"+query+"%'");
            List<Iva> ivaResult = q.getResultList();
            return ivaResult;
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName()+ "getIvaByQuery", e);
            return null;
        }
    }
    
}
