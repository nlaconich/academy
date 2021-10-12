/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ci.academy.customer.entities;

/**
 *
 * @author jmendez
 */
public class Customer {
    
    private int idCustomer;
    private int idStudent;
    private String descripcion;
    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    @Override
    public String toString() {
        return "Customer{" + "idCustomer=" + idCustomer + ", idStudent=" + idStudent + ", descripcion=" + descripcion + '}';
    }

    
    
    
    
}
