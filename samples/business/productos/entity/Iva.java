/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.productos.entity;

import business.facturacion.entity.FacturasDetalle;
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
@Table(name = "iva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Iva.findAll", query = "SELECT i FROM Iva i"),
    @NamedQuery(name = "Iva.findByIvaId", query = "SELECT i FROM Iva i WHERE i.ivaId = :ivaId"),
    @NamedQuery(name = "Iva.findByIva", query = "SELECT i FROM Iva i WHERE i.iva = :iva"),
    @NamedQuery(name = "Iva.findByPorcentaje", query = "SELECT i FROM Iva i WHERE i.porcentaje = :porcentaje")})
public class Iva implements Serializable {

    @OneToMany(mappedBy = "ivaId")
    private List<FacturasDetalle> facturasDetalleList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iva_id")
    private Integer ivaId;
    @Size(max = 20)
    @Column(name = "iva")
    private String iva;
    @Column(name = "porcentaje")
    private Short porcentaje;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ivaId")
    private List<Producto> productoList;

    public Iva() {
    }

    public Iva(Integer ivaId) {
        this.ivaId = ivaId;
    }

    public Integer getIvaId() {
        return ivaId;
    }

    public void setIvaId(Integer ivaId) {
        this.ivaId = ivaId;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public Short getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Short porcentaje) {
        this.porcentaje = porcentaje;
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
        hash += (ivaId != null ? ivaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Iva)) {
            return false;
        }
        Iva other = (Iva) object;
        if ((this.ivaId == null && other.ivaId != null) || (this.ivaId != null && !this.ivaId.equals(other.ivaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.productos.entity.Iva[ ivaId=" + ivaId + " ]";
    }

    public List<FacturasDetalle> getFacturasDetalleList() {
        return facturasDetalleList;
    }

    public void setFacturasDetalleList(List<FacturasDetalle> facturasDetalleList) {
        this.facturasDetalleList = facturasDetalleList;
    }
    
}
