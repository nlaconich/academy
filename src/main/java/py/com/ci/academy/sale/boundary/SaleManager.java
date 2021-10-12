/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ci.academy.sale.boundary;

import java.sql.Date;
import py.com.ci.academy.sale.entities.Sale;
import py.com.ci.academy.utils.ConnectionManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import py.com.ci.academy.customer.boundary.CustomerManager;





public class SaleManager {
    public static CustomerManager cm= new CustomerManager ();
    
    
    private String getStatement() //trae los datos de las columnas de la tabla 
    {
        String sql = "SELECT *  FROM sale";
        return sql;// pasar datos a la bd 
    }
    
    public void add(Sale sale) {
        String sql = "INSERT INTO public.sale(date_sale,id_customer,descripcion) VALUES ( ?,?,?)";

        try ( PreparedStatement sj = ConnectionManager.getConnection().prepareStatement(sql)) {
            //sj.setInt(1, sale.getIdSale());
            sj.setDate(1, (Date) sale.getDate_sale());
            sj.setInt(2, sale.getCustomer().getIdCustomer());
            sj.setString(3, sale.getDescripcion());
          
            

            sj.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    
    }
    
     public Sale getById(int idSale) {
        String sql = getStatement() + " where id_sale=" + idSale;
        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setMaxRows(100);
            try ( ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    return getFromRsSale(rs);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
     
     public List<Sale> getAll() {
        List<Sale> listSale = new ArrayList();
        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(getStatement())) {
            s1.setMaxRows(100);
            try ( ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    listSale.add(getFromRsSale(rs));
                }
            }
            return listSale;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }
     
      public boolean updateSale(Sale sale) {
        String sql = "UPDATE public.sale SET  date_sale=?, id_customer=?, descripcion=? WHERE id_sale=?";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
           
            s1.setInt(2, sale.getCustomer().getIdCustomer());
            s1.setDate(1,sale.getDate_sale());
            s1.setString(3,sale.getDescripcion());
             s1.setInt(4, sale.getIdSale());
           
            //s1.setInt(4, product.getIdProduct());
            s1.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

     
     public boolean deleteById(Sale sale) {
        String sql = "DELETE FROM public.sale WHERE id_sale= ?";
        int rows = 0;
        try ( PreparedStatement sj = ConnectionManager.getConnection().prepareStatement(sql)) {
            sj.setInt(1, sale.getIdSale());
            rows = sj.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
     
     public Sale getFromRsSale(ResultSet rs) {
        try {
            Sale data = new Sale();
            data.setIdSale(rs.getInt("id_sale"));
            data.setDate_sale(rs.getDate("date_sale"));
           //data.setIdCustomer(rs.getInt("id_customer"));
           // asignamos todos los datos de customer a la venta (sale)
           data.setCustomer(cm.getById(rs.getInt("id_customer")));
           if(data.getCustomer() == null){
               data.getCustomer().setIdCustomer(rs.getInt("id_customer"));
           }
                   
            data.setDescripcion(rs.getString("descripcion"));
            return data;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        
       
    }
     
      public int getIdSale( ) {
        try {
            ResultSet rs;
            Sale data = new Sale();
            String StatementSQL = "SELECT max(id_sale) AS id_sale FROM db_academy.public.sale";
            PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(StatementSQL);
            s1.setMaxRows(1);
            rs = s1.executeQuery();
               data.setIdSale(rs.getInt("id_sale"));
               rs.next();
                
                
            return data.getIdSale();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }
      
      
      public Sale getSale(int id){
      Sale s = null;
      s = this.getAll().get(id);
          
        return s;
      
      }
      
      public boolean updateTotal(double total,int id) {
        String sql = "UPDATE public.sale SET  total_sale=? WHERE id_sale=?";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
           
            s1.setDouble(1,total);
     
             s1.setInt(2,id);
           
            //s1.setInt(4, product.getIdProduct());
            s1.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

      
     
    public static void main(String[] args) {
        SaleManager saleManager = new SaleManager();
        List<Sale> listOfSale = saleManager.getAll();
        System.out.println("List of product >" + listOfSale.size());
    }

   
}

    
    
