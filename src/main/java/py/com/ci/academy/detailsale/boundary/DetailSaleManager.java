/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ci.academy.detailsale.boundary;


import py.com.ci.academy.utils.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import py.com.ci.academy.detailsale.entities.DetailSale;
import py.com.ci.academy.product.boundary.ProductManager;
import py.com.ci.academy.sale.boundary.SaleManager;
/**
 *
 * @author jmendez
 */
public class DetailSaleManager {
    
    public static SaleManager sm= new SaleManager ();
    public static ProductManager pm= new ProductManager ();
    
     private String getStatement() //trae los datos de las columnas de la tabla 
    {
        String sql = "SELECT * FROM detailsale";
        return sql;// pasar datos a la bd 
    }
    
    public void add(DetailSale detailsale) {
        String sql = "INSERT INTO public.detailsale(id_sale,id_product,amount_product,price_historical) VALUES ( ?,?,?,?)";

        try ( PreparedStatement sj = ConnectionManager.getConnection().prepareStatement(sql)) {
            
            sj.setInt(1, detailsale.getSale().getIdSale());
            sj.setInt(2, detailsale.getProduct().getIdProduct());
            sj.setInt(3, detailsale.getAmount_product());
            sj.setDouble(4, detailsale.getPrice_historical());
           
            

            sj.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    
    }
    
     public DetailSale getById(Integer idDetailSale) {
        String sql = getStatement() + " where id_detailsale =" + idDetailSale;
        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setMaxRows(100);
            try ( ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    return getFromRsDetailSale(rs);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
     
      public List<DetailSale> getAll() {
        List<DetailSale> listdetailsale = new ArrayList();
        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(getStatement())) {
            s1.setMaxRows(100);
            try ( ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    listdetailsale.add(getFromRsDetailSale(rs));
                }
            }
            return listdetailsale;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }
     public int deleteById(DetailSale detailsale) {
        String sql = "DELETE FROM public.detailsale WHERE id_sale= ?";
        int rows = 0;
        try ( PreparedStatement sj = ConnectionManager.getConnection().prepareStatement(sql)) {
            sj.setInt(1, detailsale.getIdDetailSale());
            rows = sj.executeUpdate();
            return rows;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }
     
     public DetailSale getFromRsDetailSale(ResultSet rs) {
        try {
            DetailSale data = new DetailSale();
            data.setIdDetailSale(rs.getInt("id_detailsale"));
            data.setSale(sm.getById(rs.getInt("id_sale"))); 
            data.setProduct(pm.getById(rs.getInt("id_product"))); 
            data.setAmount_product(rs.getInt("amount_product")); 
            data.setPrice_historical(rs.getDouble("price_historical")); 
            
            return data;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
     
    public static void main(String[] args) {
        DetailSaleManager detailsaleManager = new DetailSaleManager();
        List<DetailSale> listOfDetailSale = detailsaleManager.getAll();
        System.out.println("List of detailsale >" + listOfDetailSale.size());
    }
}
