/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ci.academy.product.boundary;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import py.com.ci.academy.product.entities.Mark;
import py.com.ci.academy.utils.ConnectionManager;

/**
 *
 * @author jmendez
 */
public class MarkManager {
     private String getStatement() //trae los datos de las columnas de la tabla 
    {
        String sql = "SELECT * FROM mark";
        return sql;// pasar datos a la bd 
    }
     
       public void add(Mark mark) {
        String sql = "INSERT INTO public.mark(name) VALUES (?)";

        try ( PreparedStatement sj = ConnectionManager.getConnection().prepareStatement(sql)) {
           
            sj.setString(1, mark.getName());

            sj.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    
    }
       
        public Mark getById(Integer idMark) {
        String sql = getStatement() + " where id_mark =" + idMark;
        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setMaxRows(100);
            try ( ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    return getFromRsMark(rs);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
  public List<Mark> getAll() {
        List<Mark> listMark = new ArrayList();
        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(getStatement())) {
            s1.setMaxRows(100);
            try ( ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    listMark.add(getFromRsMark(rs));
                }
            }
            return listMark;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }
     public boolean deleteById(Mark mark) {
        String sql = "DELETE FROM public.mark WHERE id_mark= ?";
        int rows = 0;
        try ( PreparedStatement sj = ConnectionManager.getConnection().prepareStatement(sql)) {
            sj.setInt(1, mark.getId_mark());
            rows = sj.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
     
    private Mark getFromRsMark(ResultSet rs) {
       try {
            Mark data = new Mark();
            data.setId_mark(rs.getInt("id_mark"));
            data.setName(rs.getString("name"));
            return data;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
     public static void main(String[] args) {
        MarkManager markManager = new MarkManager();
         List<Mark> listOfMark = markManager.getAll();
        System.out.println("List of mark >" + listOfMark .size());
    }

    public boolean updateMark(Mark mark) {
        String sql = "UPDATE public.mark SET name=? WHERE id_mark=?";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setString(1, mark.getName());
            s1.setInt(2, mark.getId_mark());
            
            s1.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
}
