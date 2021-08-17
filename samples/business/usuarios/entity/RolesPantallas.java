/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.usuarios.entity;

import business.usuarios.entity.Roles;
import business.usuarios.entity.Pantallas;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author pinchi
 */
@Entity
@Table(name = "roles_pantallas")
@NamedQueries({
    @NamedQuery(name = "RolesPantallas.findAll", query = "SELECT r FROM RolesPantallas r"),
    @NamedQuery(name = "RolesPantallas.findByRolesPantallaId", query = "SELECT r FROM RolesPantallas r WHERE r.rolesPantallaId = :rolesPantallaId")})
public class RolesPantallas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "roles_pantalla_id", nullable = false)
    private Integer rolesPantallaId;
    @JoinColumn(name = "pantalla_id", referencedColumnName = "pantalla_id")
    @ManyToOne
    private Pantallas pantallaId;
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
    @ManyToOne
    private Roles rolId;

    public RolesPantallas() {
    }

    public RolesPantallas(Integer rolesPantallaId) {
        this.rolesPantallaId = rolesPantallaId;
    }

    public Integer getRolesPantallaId() {
        return rolesPantallaId;
    }

    public void setRolesPantallaId(Integer rolesPantallaId) {
        this.rolesPantallaId = rolesPantallaId;
    }

    public Pantallas getPantallaId() {
        return pantallaId;
    }

    public void setPantallaId(Pantallas pantallaId) {
        this.pantallaId = pantallaId;
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
        hash += (rolesPantallaId != null ? rolesPantallaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolesPantallas)) {
            return false;
        }
        RolesPantallas other = (RolesPantallas) object;
        if ((this.rolesPantallaId == null && other.rolesPantallaId != null) || (this.rolesPantallaId != null && !this.rolesPantallaId.equals(other.rolesPantallaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.entitys.RolesPantallas[ rolesPantallaId=" + rolesPantallaId + " ]";
    }
    
}
