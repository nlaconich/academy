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

/**
 *
 * @author pinchi
 */
@Entity
@Table(name = "tipo_producto")
@NamedQueries({
    @NamedQuery(name = "TipoProducto.findAll", query = "SELECT t FROM TipoProducto t"),
    @NamedQuery(name = "TipoProducto.findByTipoProducto", query = "SELECT t FROM TipoProducto t WHERE t.tipoProducto = :tipoProducto"),    
    @NamedQuery(name = "TipoProducto.findByTipoId", query = "SELECT t FROM TipoProducto t WHERE t.tipoId = :tipoId"),
    @NamedQuery(name = "TipoProducto.findById", query = "SELECT t FROM TipoProducto t WHERE t.tipoId = :id")})
public class TipoProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "tipo_producto", length = 20)
    private String tipoProducto;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipo_id", nullable = false)
    private Integer tipoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoProductoId")
    private List<Producto> productoList;

    public TipoProducto() {
    }

    public TipoProducto(Integer tipoId) {
        this.tipoId = tipoId;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto.toUpperCase();
    }

    public Integer getTipoId() {
        return tipoId;
    }

    public void setTipoId(Integer tipoId) {
        this.tipoId = tipoId;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoId != null ? tipoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProducto)) {
            return false;
        }
        TipoProducto other = (TipoProducto) object;
        if ((this.tipoId == null && other.tipoId != null) || (this.tipoId != null && !this.tipoId.equals(other.tipoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.productos.entity.TipoProducto[ tipoId=" + tipoId + " ]";
    }
    
}
