/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ci.academy.product.entities;

/**
 *
 * @author jmendez
 */
public class Mark {
   private int id_mark ;
   private String name;

    public int getId_mark() {
        return id_mark;
    }

    public void setId_mark(int id_mark) {
        this.id_mark = id_mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Mark{" + "id_mark=" + id_mark + ", name=" + name + '}';
    }
   
    
}
