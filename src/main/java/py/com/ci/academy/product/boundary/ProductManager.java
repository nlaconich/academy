/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ci.academy.product.boundary;

import py.com.ci.academy.utils.ConnectionManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import py.com.ci.academy.product.entities.Product;

/**
 *
 * @author jmendez
 */
public class ProductManager {

    public static MarkManager mm = new MarkManager();

    private String getStatement() //trae los datos de las columnas de la tabla 
    {
        String sql = "SELECT * FROM product";
        return sql;// pasar datos a la bd 
    }

    public void addProduct(Product product) {
        String sql = "INSERT INTO public.product(price,id_mark,productdescription) VALUES ( ?,?,?)";

        try ( PreparedStatement sj = ConnectionManager.getConnection().prepareStatement(sql)) {
         //   sj.setInt(1, product.getIdProduct());
            sj.setDouble(1, product.getPrice());
            sj.setInt(2, product.getMark().getId_mark());
            sj.setString(3, product.getProductdescription());

            sj.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public Product getById(Integer idProduct) {
        String sql = getStatement() + " where id_product =" + idProduct;
        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setMaxRows(100);
            try ( ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    return getFromRsProduct(rs);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Product> getAll() {
        List<Product> listProduct = new ArrayList();
        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(getStatement())) {
            s1.setMaxRows(100);
            ResultSet rs = s1.executeQuery();
            while (rs.next()) {
                listProduct.add(getFromRsProduct(rs));
            }

            return listProduct;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.EMPTY_LIST;
        }

    }

    public boolean updateProduct(Product product) {
        String sql = "UPDATE public.product SET  price=?, id_mark=?, productdescription=? WHERE id_product=?";
        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setDouble(1, product.getPrice());
            s1.setInt(2, product.getMark().getId_mark());
            s1.setString(3, product.getProductdescription());
            s1.setInt(4, product.getIdProduct());
            
            //s1.setInt(4, product.getIdProduct());
            s1.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean deleteById(Product product) {
        String sql = "DELETE FROM public.product WHERE id_product= ?";
        int rows = 0;
        try ( PreparedStatement sj = ConnectionManager.getConnection().prepareStatement(sql)) {
            sj.setInt(1, product.getIdProduct());
            rows = sj.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public Product getFromRsProduct(ResultSet rs) {
        try {
            Product data = new Product();
            data.setIdProduct(rs.getInt("id_product"));
            data.setPrice(rs.getDouble("price"));
            data.setMark(mm.getById(rs.getInt("id_mark")));
            data.setProductdescription(rs.getString("productdescription"));
            if (data.getMark() == null) {
                data.getMark().setId_mark(rs.getInt("id_mark"));
            }
            return data;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public int getIdProduct() {
        try {
            ResultSet rs;
            Product data = new Product();
            String StatementSQL = "SELECT max(id_product) FROM db_academy.public.product";
            PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(StatementSQL);
            s1.setMaxRows(1);
            rs = s1.executeQuery();
            data.setIdProduct(rs.getInt("id_product"));

            return data.getIdProduct();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }
    
    
    public Product getProductoPorID(int id){
	Product product=null;
	List<Product> contenido = this.getAll();
	//verificar si retorna lista no vacia
	if (!contenido.isEmpty()){
		//Recorrer elemento por elemento
		for(Product Producto : contenido){
			if(Producto.getIdProduct()== id){
			   product = Producto;
			}
		}
	}
	return product;
        
        }
        public int getIDProduct(){
	Product product=null;
	int IDProduct=0;
	List<Product> contenido = this.getAll();
	//verificar si retorna lista no vacia
	if (!contenido.isEmpty()){
		int cantElemento = contenido.size();
		product = contenido.get(cantElemento-1);
		IDProduct = product.getIdProduct();
	}
	return IDProduct;
}
        
        
        
        


    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        List<Product> listOfProduct = productManager.getAll();
        System.out.println("List of product >" + listOfProduct.size());
    }
}
