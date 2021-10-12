package py.com.ci.academy.customer.boundary;

import py.com.ci.academy.utils.ConnectionManager;
import py.com.ci.academy.customer.entities.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author jmendez
 */
public class CustomerManager {

    private String getStatement() //trae los datos de las columnas de la tabla 
    {
        String sql = "SELECT * FROM public.customer";
        return sql;// pasar datos a la bd 
    }

    public void add(Customer customer) {
        String sql = "INSERT INTO public.customer(id_student_teacher,descripcion) VALUES (?,?)";

        try ( PreparedStatement sj = ConnectionManager.getConnection().prepareStatement(sql)) {
           // sj.setInt(1, customer.getIdCustomer());
            sj.setInt(1, customer.getIdStudent());
            sj.setString(2, customer.getDescripcion());

            sj.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Customer getById(Integer idCustomer) {
        String sql = getStatement() + " where id_customer =" + idCustomer;
        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setMaxRows(100);
            try ( ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    return getFromRsCustomer(rs);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Customer> getAll() {
        List<Customer> listCustomer = new ArrayList();
        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(getStatement())) {
            s1.setMaxRows(100);
            try ( ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    listCustomer.add(getFromRsCustomer(rs));
                }
            }
            return listCustomer;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }

    public boolean deleteById(Customer customer) {
        String sql = "DELETE FROM public.customer WHERE id_customer= ?";
        int rows = 0;
        try ( PreparedStatement sj = ConnectionManager.getConnection().prepareStatement(sql)) {
            sj.setInt(1, customer.getIdStudent());
            rows = sj.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public int updateById(Customer customer) {
        int rows = 0;
        String sql = "UPDATE public.customer SET  id_student_teacher=?,id_teacher=? WHERE id_customer=?";
        try ( PreparedStatement sj = ConnectionManager.getConnection().prepareStatement(sql)) {
            
            sj.setInt(1, customer.getIdStudent());
            sj.setString(2, customer.getDescripcion());
            sj.setInt(3, customer.getIdCustomer());

            rows = sj.executeUpdate();
            return rows;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }

    public Customer getFromRsCustomer(ResultSet rs) {
        try {
            Customer data = new Customer();
            data.setIdCustomer(rs.getInt("id_customer"));
            data.setIdStudent(rs.getInt("id_student_teacher"));
            data.setDescripcion(rs.getString("descripcion"));
            //data.setIdTeacher(rs.getInt("id_teacher"));
            return data;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

   public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManager();
        List<Customer> listOfCustomers = customerManager.getAll();
        System.out.println("List of customers >" + listOfCustomers.size());
    
 }
}