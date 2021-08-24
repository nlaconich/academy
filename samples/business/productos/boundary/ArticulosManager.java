/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.productos.boundary;

import business.dao.GenericImpl;
import business.ordenestrabajo.entity.Articulos;
import business.productos.entity.Producto;
import business.utils.UtilLogger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author pinchi
 */
@Stateless
public class ArticulosManager extends GenericImpl<Articulos, Integer>{
    
    public Articulos getByNombre(String nombreArticulo) {
        try {
            
            Query query = em.createNamedQuery("Articulos.findByDescripcion").setParameter("descripcion", nombreArticulo);
            return ((Articulos) query.getSingleResult());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName()+ ".getByNombre", e);
            return null;
        }
    }
     public List<Articulos> getArticulosByQuery(String query){
        try {
            Query q = em.createQuery("SELECT a FROM Articulos a WHERE a.descripcion like '%"+query.toUpperCase()+"%' order by a.descripcion");
            List<Articulos> articulosResult = q.getResultList();
            return articulosResult;
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName()+ "getArticulosByQuery", e);
            return null;
        }
    }

    
}
