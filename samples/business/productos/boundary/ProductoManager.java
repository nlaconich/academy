/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.productos.boundary;

import business.dao.GenericImpl;
import business.productos.entity.Producto;
import business.utils.UtilLogger;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author pinchi
 */
@Stateless
public class ProductoManager extends GenericImpl<Producto, Integer>{
    
    public Producto getByNombre(String descripcion) {
        try {
            
            Query query = em.createNamedQuery("Producto.findByDescripcion").setParameter("descripcion", descripcion);
            return ((Producto) query.getSingleResult());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName()+ ".getByNombre", e);
            return null;
        }
    }
    
    public List<Producto> getProductoByDescripcion(String query){
        try {
            Query q = em.createQuery("SELECT p FROM Producto p WHERE p.descripcion like '%"+query+"%'");
            List<Producto> productoResult = q.getResultList();
            return productoResult;
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName()+ "getServiciosByQuery", e);
            return Collections.emptyList();
        }
    }
    
    
    public List<Producto> getListaOrdenada(){
        try {
            Query q = em.createQuery("SELECT p FROM Producto p order by p.descripcion");
            List<Producto> productoResult = q.getResultList();
            return productoResult;
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName()+ "getServiciosByQuery", e);
            return null;
        }
    }
    
       public List<Producto> getByProductoId(Producto value) {
         try {
            return (List<Producto>) em.createNamedQuery("Producto.findByProductoId").setParameter("productoId", value).getResultList();
        } catch (Exception ex) {
            UtilLogger.error("CLASS: "+this.getClass().getName() + ".getByProductoId", ex);
            return null;
        }
    }
    
}
