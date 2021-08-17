package business.productos.entity;

import business.deposito.entity.Depositos;
import business.ordenescompra.entity.OrdenesCompra;
import business.stock.entity.StockDetalle;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

/**
 *
 * @author nbaez
 */
@Entity
@Table(name = "productos_detalle")
@NamedQueries({
    @NamedQuery(name = "ProductosDetalle.findAll", query = "SELECT p FROM ProductosDetalle p")
    , @NamedQuery(name = "ProductosDetalle.findByProductoDetalleId", query = "SELECT p FROM ProductosDetalle p WHERE p.productoDetalleId = :productoDetalleId")
    , @NamedQuery(name = "ProductosDetalle.findById", query = "SELECT p FROM ProductosDetalle p WHERE p.productoDetalleId = :id")
    , @NamedQuery(name = "ProductosDetalle.findByFechavencimiento", query = "SELECT p FROM ProductosDetalle p WHERE p.fechavencimiento = :fechavencimiento")
    , @NamedQuery(name = "ProductosDetalle.findByCodigounitario", query = "SELECT p FROM ProductosDetalle p WHERE p.codigounitario = :codigounitario")
    , @NamedQuery(name = "ProductosDetalle.findByCodigoproveedor", query = "SELECT p FROM ProductosDetalle p WHERE p.codigoproveedor = :codigoproveedor")
    , @NamedQuery(name = "ProductosDetalle.findByPesoActual", query = "SELECT p FROM ProductosDetalle p WHERE p.pesoActual = :pesoActual")
    , @NamedQuery(name = "ProductosDetalle.findByCantidad", query = "SELECT p FROM ProductosDetalle p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "ProductosDetalle.findByDescripcion", query = "SELECT p FROM ProductosDetalle p WHERE p.descripcion = :descripcion")})
public class ProductosDetalle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "producto_detalle_id")
    private Integer productoDetalleId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoDetalleId",orphanRemoval = true)
    private List<StockDetalle> stockDetalleList;

    private static final long serialVersionUID = 1L;

    @Column(name = "fechavencimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechavencimiento;
    @Size(max = 200)
    @Column(name = "codigounitario")
    private String codigounitario;
    @Size(max = 200)
    @Column(name = "codigoproveedor")
    private String codigoproveedor;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "abierto")
    private Boolean abierto;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "anulado")
    private Boolean anulado;
    
    @JoinColumn(name = "producto_id", referencedColumnName = "producto_id")
    @ManyToOne
    private Producto producto;

    @JoinColumn(name = "orden_compra_id", referencedColumnName = "orden_compra_id")
    @ManyToOne
    private OrdenesCompra ordenCompra;

    @JoinColumn(name = "deposito_id", referencedColumnName = "deposito_id", nullable = true)
    @ManyToOne
    private Depositos depositos;

    @Column(name = "peso_actual")
    private Double pesoActual;

    @Column(name = "fecha_actualizacion")
    private Date fechaActualizacion;
    
    @Column(name = "vigencia")
    private Boolean vigencia;
    @Transient
    private String codigoBarra;
    @Transient
    private String tipoBajaStock;
    @Transient
    private Double cantidadBajaStock;

    public ProductosDetalle() {
    }

    public ProductosDetalle(Producto producto, Integer cantidad) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.pesoActual = producto.getCantidadUnitaria();
        this.fechaActualizacion = new Date();
        this.abierto = false;
    }

    public ProductosDetalle(Integer productosDetalleId) {
        this.productoDetalleId = productosDetalleId;
    }

    public Date getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(Date fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public String getCodigounitario() {
        return codigounitario;
    }

    public void setCodigounitario(String codigounitario) {
        this.codigounitario = codigounitario;
    }

    public String getCodigoproveedor() {
        return codigoproveedor;
    }

    public void setCodigoproveedor(String codigoproveedor) {
        this.codigoproveedor = codigoproveedor;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto productoId) {
        this.producto = productoId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.productoDetalleId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProductosDetalle other = (ProductosDetalle) obj;
        if (!Objects.equals(this.productoDetalleId, other.productoDetalleId)) {
            return false;
        }
        return true;
    }

   

    @Override
    public String toString() {
        return "ProductosDetalle{" + "productoDetalleId=" + productoDetalleId + ", stockDetalleList=" + stockDetalleList + ", fechavencimiento=" + fechavencimiento + ", codigounitario=" + codigounitario + ", codigoproveedor=" + codigoproveedor + ", cantidad=" + cantidad + ", descripcion=" + descripcion + ", producto=" + producto + '}';
    }

    public Integer getProductoDetalleId() {
        return productoDetalleId;
    }

    public void setProductoDetalleId(Integer productoDetalleId) {
        this.productoDetalleId = productoDetalleId;
    }

    public List<StockDetalle> getStockDetalleList() {
        return stockDetalleList;
    }

    public void setStockDetalleList(List<StockDetalle> stockDetalleList) {
        this.stockDetalleList = stockDetalleList;
    }

    public OrdenesCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenesCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public Boolean getAbierto() {
        return abierto;
    }

    public void setAbierto(Boolean abierto) {
        this.abierto = abierto;
    }

    public Double getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(Double pesoActual) {
        this.pesoActual = pesoActual;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Depositos getDepositos() {
        return depositos;
    }

    public void setDepositos(Depositos depositos) {
        this.depositos = depositos;
    }

    public Boolean getVigencia() {
        return vigencia;
    }

    public void setVigencia(Boolean vigencia) {
        this.vigencia = vigencia;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public Boolean getAnulado() {
        return anulado;
    }

    public void setAnulado(Boolean anulado) {
        this.anulado = anulado;
    }

    public String getTipoBajaStock() {
        return tipoBajaStock;
    }

    public void setTipoBajaStock(String tipoBajaStock) {
        this.tipoBajaStock = tipoBajaStock;
    }

    public Double getCantidadBajaStock() {
        return cantidadBajaStock;
    }

    public void setCantidadBajaStock(Double cantidadBajaStock) {
        this.cantidadBajaStock = cantidadBajaStock;
    }
    
    
    
    
}
