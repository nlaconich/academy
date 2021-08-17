/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.productos.entity;

import business.facturacion.entity.FacturasDetalle;
import business.ordenescompra.entity.OrdenCompraDetalle;
import business.ordenestrabajo.entity.Paleta;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Cacheable(false)
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findById", query = "SELECT p FROM Producto p WHERE p.productoId = :id")
    , @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Producto.findByPresentacion", query = "SELECT p FROM Producto p WHERE p.presentacion = :presentacion")
    , @NamedQuery(name = "Producto.findByPrecio", query = "SELECT p FROM Producto p WHERE p.precio = :precio")
    , @NamedQuery(name = "Producto.findByUnidad", query = "SELECT p FROM Producto p WHERE p.unidad = :unidad")
    , @NamedQuery(name = "Producto.findByStock", query = "SELECT p FROM Producto p WHERE p.stock = :stock")
    , @NamedQuery(name = "Producto.findByCosto", query = "SELECT p FROM Producto p WHERE p.costo = :costo")
    , @NamedQuery(name = "Producto.findByCodigo", query = "SELECT p FROM Producto p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Producto.findByCodigoInterno", query = "SELECT p FROM Producto p WHERE p.codigoInterno = :codigoInterno")})
public class Producto implements Serializable {

    @OneToMany(mappedBy = "producto")
    private List<ProductosDetalle> productosDetalleList;


    @OneToMany(mappedBy = "productoId")
    private Collection<OrdenCompraDetalle> ordenCompraDetalleCollection;

    @OneToMany(mappedBy = "productoId")
    private Collection<FacturasDetalle> facturasDetalleCollection;

    
   
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "producto_id")
    private Integer productoId;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 2147483647)
    @Column(name = "presentacion")
    private String presentacion;
    @Column(name = "precio")
    private BigInteger precio;
    @Column(name = "unidad")
    private BigInteger unidad;
    @Column(name = "stock")
    private BigInteger stock;
    @Column(name = "costo")
    private BigInteger costo;
    @Size(max = 2147483647)
    @Column(name = "codigo")
    private String codigo;

    @Column(name = "unidad_medida")
    private String unidadMedida;
    @Column(name = "cant_unitaria")
    private Double cantidadUnitaria;
    @Size(max = 20)
    @Column(name = "codigo_interno")
    private String codigoInterno;
    @JoinColumn(name = "iva_id", referencedColumnName = "iva_id")
    @ManyToOne(optional = false)
    private Iva ivaId;
    @JoinColumn(name = "paleta_id", referencedColumnName = "paleta_id")
    @ManyToOne
    private Paleta paletaId;
    @JoinColumn(name = "tipo_control_stock_id", referencedColumnName = "tipo_control_stock_id")
    @ManyToOne(optional = false)
    private TipoControlStock tipoControlStockId;
    @JoinColumn(name = "tipo_producto_id", referencedColumnName = "tipo_id")
    @ManyToOne(optional = false)
    private TipoProducto tipoProductoId;
    
    
    @JoinColumn(name = "producto_menudeo", referencedColumnName = "producto_id")
    @ManyToOne(optional = true)
    private Producto productoMenudeo;

    public Producto() {
    }

    public Producto(Integer productoId) {
        this.productoId = productoId;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion.toUpperCase();
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public BigInteger getPrecio() {
        return precio;
    }

    public void setPrecio(BigInteger precio) {
        this.precio = precio;
    }

    public BigInteger getUnidad() {
        return unidad;
    }

    public void setUnidad(BigInteger unidad) {
        this.unidad = unidad;
    }

    

    public BigInteger getCosto() {
        return costo;
    }

    public void setCosto(BigInteger costo) {
        this.costo = costo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public Iva getIvaId() {
        return ivaId;
    }

    public void setIvaId(Iva ivaId) {
        this.ivaId = ivaId;
    }

    public Paleta getPaletaId() {
        return paletaId;
    }

    public void setPaletaId(Paleta paletaId) {
        this.paletaId = paletaId;
    }

    public TipoControlStock getTipoControlStockId() {
        return tipoControlStockId;
    }

    public void setTipoControlStockId(TipoControlStock tipoControlStockId) {
        this.tipoControlStockId = tipoControlStockId;
    }

    public TipoProducto getTipoProductoId() {
        return tipoProductoId;
    }

    public void setTipoProductoId(TipoProducto tipoProductoId) {
        this.tipoProductoId = tipoProductoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productoId != null ? productoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.productoId == null && other.productoId != null) || (this.productoId != null && !this.productoId.equals(other.productoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.productos.entity.Producto[ productoId=" + productoId + " ]";
    }

    @XmlTransient
    public Collection<FacturasDetalle> getFacturasDetalleCollection() {
        return facturasDetalleCollection;
    }

    public void setFacturasDetalleCollection(Collection<FacturasDetalle> facturasDetalleCollection) {
        this.facturasDetalleCollection = facturasDetalleCollection;
    }

   
    @XmlTransient
    public Collection<OrdenCompraDetalle> getOrdenCompraDetalleCollection() {
        return ordenCompraDetalleCollection;
    }

    public void setOrdenCompraDetalleCollection(Collection<OrdenCompraDetalle> ordenCompraDetalleCollection) {
        this.ordenCompraDetalleCollection = ordenCompraDetalleCollection;
    }

  

    public List<ProductosDetalle> getProductosDetalleList() {
        return productosDetalleList;
    }

    public void setProductosDetalleList(List<ProductosDetalle> productosDetalleList) {
        this.productosDetalleList = productosDetalleList;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Double getCantidadUnitaria() {
        return cantidadUnitaria;
    }

    public void setCantidadUnitaria(Double cantidadUnitaria) {
        this.cantidadUnitaria = cantidadUnitaria;
    }

    public BigInteger getStock() {
        return stock;
    }

    public void setStock(BigInteger stock) {
        this.stock = stock;
    }

    public Producto getProductoMenudeo() {
        return productoMenudeo;
    }

    public void setProductoMenudeo(Producto productoMenudeo) {
        this.productoMenudeo = productoMenudeo;
    }
    
    
}
