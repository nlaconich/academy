/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.productos.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pinchi
 */
@Entity
@Table(name = "tipo_control_stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoControlStock.findAll", query = "SELECT t FROM TipoControlStock t"),
    @NamedQuery(name = "TipoControlStock.findByTipoControlStockId", query = "SELECT t FROM TipoControlStock t WHERE t.tipoControlStockId = :tipoControlStockId"),
    @NamedQuery(name = "TipoControlStock.findByDescripcion", query = "SELECT t FROM TipoControlStock t WHERE t.descripcion = :descripcion")})
public class TipoControlStock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipo_control_stock_id")
    private Integer tipoControlStockId;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoControlStockId")
    private List<Producto> productoList;

    public TipoControlStock() {
    }

    public TipoControlStock(Integer tipoControlStockId) {
        this.tipoControlStockId = tipoControlStockId;
    }

    public Integer getTipoControlStockId() {
        return tipoControlStockId;
    }

    public void setTipoControlStockId(Integer tipoControlStockId) {
        this.tipoControlStockId = tipoControlStockId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion.toUpperCase();
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoControlStockId != null ? tipoControlStockId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoControlStock)) {
            return false;
        }
        TipoControlStock other = (TipoControlStock) object;
        if ((this.tipoControlStockId == null && other.tipoControlStockId != null) || (this.tipoControlStockId != null && !this.tipoControlStockId.equals(other.tipoControlStockId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.productos.entity.TipoControlStock[ tipoControlStockId=" + tipoControlStockId + " ]";
    }
    
}
