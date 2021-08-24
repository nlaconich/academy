/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.usuarios.entity;

import business.cajas.entity.Cajas;
import business.cajas.entity.CajasGastos;
import business.clientes.entity.Rubro;
import business.facturacion.entity.Facturas;
import business.facturacion.entity.FacturasEstado;
import business.movimiento.entity.MovimientoDetalle;
import business.ordenescompra.entity.OrdenCompraDetalle;
import business.ordenescompra.entity.OrdenesCompra;
import business.ordenestrabajo.entity.OrdenesTrabajoEstados;
import business.stock.entity.StockPesable;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pinchi
 */
@Entity
@Table(name = "usuarios")
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByUsuarioId", query = "SELECT u FROM Usuarios u WHERE u.usuarioId = :usuarioId"),
    @NamedQuery(name = "Usuarios.findByUsuario", query = "SELECT u FROM Usuarios u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "Usuarios.findByUsername", query = "SELECT u FROM Usuarios u WHERE u.username = :username"),
    @NamedQuery(name = "Usuarios.findByPassword", query = "SELECT u FROM Usuarios u WHERE u.password = :password"),
    @NamedQuery(name = "Usuarios.findByRolId", query = "SELECT u FROM Usuarios u WHERE u.rolId = :rolId")})
public class Usuarios implements Serializable {

    @OneToMany(mappedBy = "usuarioId")
    private Collection<MovimientoDetalle> movimientoDetalleCollection;


    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private List<CajasGastos> cajasGastosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private List<Cajas> cajasList;

    @OneToMany(mappedBy = "usuario")
    private Collection<StockPesable> stockPesableCollection;

   
    @OneToMany(mappedBy = "usuarioId")
    private List<FacturasEstado> facturasEstadoList;
    
    
    @OneToMany(mappedBy = "usuarioId")
    private List<OrdenesTrabajoEstados> ordenesTrabajoEstadosList;

    @OneToMany(mappedBy = "usuarioCarga")
    private List<OrdenesCompra> ordenesCompraList;
    @OneToMany(mappedBy = "usuarioAprobacion")
    private List<OrdenesCompra> ordenesCompraList1;
    @OneToMany(mappedBy = "usuarioRecepcion")
    private List<OrdenCompraDetalle> ordenCompraDetalleList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuario_id", nullable = false)
    private Integer usuarioId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "usuario", nullable = false, length = 2147483647)
    private String usuario;
    @Size(max = 2147483647)
    @Column(name = "username", length = 2147483647)
    private String username;
    @Size(max = 2147483647)
    @Column(name = "password", length = 2147483647)
    private String password;
    
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id", nullable = false)
    @ManyToOne(optional = false)
    private Roles  rolId;
    
    public Usuarios() {
    }

    public Usuarios(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Usuarios(Integer usuarioId, String usuario) {
        this.usuarioId = usuarioId;
        this.usuario = usuario;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRolId() {
        return rolId;
    }

    public void setRolId(Roles rolId) {
        this.rolId = rolId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioId != null ? usuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.usuarioId == null && other.usuarioId != null) || (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.usuarios.entity.Usuarios[ usuarioId=" + usuarioId + " ]";
    }
    
    public List<OrdenesTrabajoEstados> getOrdenesTrabajoEstadosList() {
        return ordenesTrabajoEstadosList;
    }

    public void setOrdenesTrabajoEstadosList(List<OrdenesTrabajoEstados> ordenesTrabajoEstadosList) {
        this.ordenesTrabajoEstadosList = ordenesTrabajoEstadosList;
    }

    public List<OrdenesCompra> getOrdenesCompraList() {
        return ordenesCompraList;
    }

    public void setOrdenesCompraList(List<OrdenesCompra> ordenesCompraList) {
        this.ordenesCompraList = ordenesCompraList;
    }

    public List<OrdenesCompra> getOrdenesCompraList1() {
        return ordenesCompraList1;
    }

    public void setOrdenesCompraList1(List<OrdenesCompra> ordenesCompraList1) {
        this.ordenesCompraList1 = ordenesCompraList1;
    }

    public List<OrdenCompraDetalle> getOrdenCompraDetalleList() {
        return ordenCompraDetalleList;
    }

    public void setOrdenCompraDetalleList(List<OrdenCompraDetalle> ordenCompraDetalleList) {
        this.ordenCompraDetalleList = ordenCompraDetalleList;
    }

    public List<FacturasEstado> getFacturasEstadoList() {
        return facturasEstadoList;
    }

    public void setFacturasEstadoList(List<FacturasEstado> facturasEstadoList) {
        this.facturasEstadoList = facturasEstadoList;
    }

    
    @XmlTransient
    public Collection<StockPesable> getStockPesableCollection() {
        return stockPesableCollection;
    }

    public void setStockPesableCollection(Collection<StockPesable> stockPesableCollection) {
        this.stockPesableCollection = stockPesableCollection;
    }

    @XmlTransient
    public List<CajasGastos> getCajasGastosList() {
        return cajasGastosList;
    }

    public void setCajasGastosList(List<CajasGastos> cajasGastosList) {
        this.cajasGastosList = cajasGastosList;
    }

    @XmlTransient
    public List<Cajas> getCajasList() {
        return cajasList;
    }

    public void setCajasList(List<Cajas> cajasList) {
        this.cajasList = cajasList;
    }

    @XmlTransient
    public Collection<MovimientoDetalle> getMovimientoDetalleCollection() {
        return movimientoDetalleCollection;
    }

    public void setMovimientoDetalleCollection(Collection<MovimientoDetalle> movimientoDetalleCollection) {
        this.movimientoDetalleCollection = movimientoDetalleCollection;
    }


}
