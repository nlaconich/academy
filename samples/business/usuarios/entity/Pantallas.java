/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.usuarios.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "pantallas")
@NamedQueries({
    @NamedQuery(name = "Pantallas.findAll", query = "SELECT p FROM Pantallas p"),
    @NamedQuery(name = "Pantallas.findByPantallaId", query = "SELECT p FROM Pantallas p WHERE p.pantallaId = :pantallaId"),
    @NamedQuery(name = "Pantallas.findByDescripcion", query = "SELECT p FROM Pantallas p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Pantallas.findByCodigoPantalla", query = "SELECT p FROM Pantallas p WHERE p.codigoPantalla = :codigoPantalla")})
public class Pantallas implements Serializable, Comparable<Pantallas> {

    @OneToMany(mappedBy = "pantallaId")
    private List<RolesPantallas> rolesPantallasList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pantalla_id", nullable = false)
    private Integer pantallaId;
    @Size(max = 2147483647)
    @Column(name = "descripcion", length = 2147483647)
    private String descripcion;
    @Size(max = 2147483647)
    @Column(name = "codigo_pantalla", length = 2147483647)
    private String codigoPantalla;

    public Pantallas() {
    }

    public Pantallas(Integer pantallaId) {
        this.pantallaId = pantallaId;
    }

    public Integer getPantallaId() {
        return pantallaId;
    }

    public void setPantallaId(Integer pantallaId) {
        this.pantallaId = pantallaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoPantalla() {
        return codigoPantalla;
    }

    public void setCodigoPantalla(String codigoPantalla) {
        this.codigoPantalla = codigoPantalla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pantallaId != null ? pantallaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pantallas)) {
            return false;
        }
        Pantallas other = (Pantallas) object;
        if ((this.pantallaId == null && other.pantallaId != null) || (this.pantallaId != null && !this.pantallaId.equals(other.pantallaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.entitys.Pantallas[ pantallaId=" + pantallaId + " ]";
    }

    public List<RolesPantallas> getRolesPantallasList() {
        return rolesPantallasList;
    }

    public void setRolesPantallasList(List<RolesPantallas> rolesPantallasList) {
        this.rolesPantallasList = rolesPantallasList;
    }

    @Override
    public int compareTo(Pantallas o) {
        return descripcion.compareTo(o.descripcion);
    }
    
}
