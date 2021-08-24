/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.productos.boundary;

import business.dao.GenericImpl;
import business.ordenestrabajo.entity.Paleta;
import business.productos.entity.ProductosDetalle;
import business.productos.entity.TipoProducto;
import business.stock.entity.StockDetalle;
import business.utils.UtilLogger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author nbaez
 */
@Stateless
public class ProductoDetalleManager extends GenericImpl<ProductosDetalle, Integer> {

    public List<ProductosDetalle> getListaProductosDetalleEnStock(Integer productoId) {

        try {

            Query query = em.createQuery("SELECT p FROM ProductosDetalle p WHERE p.producto.productoId = :productoId").setParameter("productoId", productoId);

            return ((List<ProductosDetalle>) query.getResultList());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".getListaProductosStock", e);
            return null;
        }

    }

    public List<ProductosDetalle> getListaProductosDetalleVigentesEnStock(Integer productoId) {

        try {

            Query query = em.createQuery("SELECT p FROM ProductosDetalle p WHERE p.producto.productoId = :productoId and p.vigencia = true").setParameter("productoId", productoId);

            return ((List<ProductosDetalle>) query.getResultList());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".getListaProductosStock", e);
            return null;
        }

    }

    public List<ProductosDetalle> getListaProductosDetalleByPaleta(Paleta paleta) {

        try {

            Query query = em.createQuery("SELECT p FROM ProductosDetalle p WHERE p.producto.paletaId.paletaId = :paletaId and p.producto.tipoProductoId.tipoId = 2 and p.vigencia=true").setParameter("paletaId", paleta.getPaletaId());

            return ((List<ProductosDetalle>) query.getResultList());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".getListaProductosStock", e);
            return null;
        }

    }

    public List<ProductosDetalle> getListaProductosDetalleByPeso(Double peso, Boolean vigente) {

        try {

            Query query = em.createQuery("SELECT p FROM ProductosDetalle p WHERE p.pesoActual  <= :peso and p.producto.tipoProductoId.tipoId = 2 and p.vigencia= :vigencia")
                    .setParameter("peso", peso)
                    .setParameter("vigencia", vigente);

            return ((List<ProductosDetalle>) query.getResultList());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".getListaProductosStock", e);
            return null;
        }

    }

    public List<ProductosDetalle> getListaProductosDetalleByCodigoBarraYTipoProducto(Integer codigoBarra, TipoProducto tipoProducto) {

        try {
            Query query = null;
            if (codigoBarra != null) {
                query = em.createQuery("SELECT p FROM ProductosDetalle p WHERE p.producto.tipoProductoId.tipoId = :tipoProductoId  and p.productoDetalleId= :codigoProductoDetalle")
                        .setParameter("tipoProductoId", tipoProducto.getTipoId())
                        .setParameter("codigoProductoDetalle", codigoBarra);
            } else {
                query = em.createQuery("SELECT p FROM ProductosDetalle p WHERE p.producto.tipoProductoId.tipoId = :tipoProductoId ")
                        .setParameter("tipoProductoId", tipoProducto.getTipoId());                
            }

            return ((List<ProductosDetalle>) query.getResultList());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".getListaProductosStock", e);
            return null;
        }

    }

    public List<StockDetalle> getDeletStockDetalleEnStock(Integer stock_detalle_id) {

        Query query = em.createQuery("Delete p FROM ProductosDetalle p WHERE p.producto.productoId = :productoId").setParameter("productoId", stock_detalle_id);
        return null;

    }

    public ProductosDetalle getBypesoActual(Integer pesoActual) {
        try {

            Query query = em.createNamedQuery("ProductosDetalle.findByPesoAcutual").setParameter("iva", pesoActual);
            return ((ProductosDetalle) query.getSingleResult());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".getBypesoActual", e);
            return null;
        }
    }

}
