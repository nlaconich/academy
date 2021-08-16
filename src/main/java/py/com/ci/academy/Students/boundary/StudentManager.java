package py.com.ci.academy.Students.boundary;

import py.com.ci.academy.Students.entities.Student;
import py.com.ci.academy.utils.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentManager {
    //Private static final long serialVersionUID = 1L;
    Student student = new Student();


    public String getStatement() {
        String statement = "SELECT id_student, name, lastname,cellphone,address,email FROM public.student";
        return statement;
    }

    public void add(Student student) {
        String sql = "INSERT INTO public.student(name, lastname,cellphone,address,email) VALUES ( ?,?,?,?,?)";

        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setString(1, student.getName());
            s1.setString(2, student.getLastName());
            s1.setString(3, student.getCellphone());
            s1.setString(4, student.getAddress());
            s1.setString(5, student.getEmail());
            s1.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Student getById(Integer idStudent) {
        String sql = getStatement() + " where id_student =" + idStudent;
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    return getFromRsStudent(rs);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Student> getAll() {
        List<Student> listStudent = new ArrayList();
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(getStatement())) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    listStudent.add(getFromRsStudent(rs));
                }
            }
            return listStudent;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }

    public int deleteById(Student student) {
        String sql = "DELETE FROM public.student WHERE id_student= ?";
        int rows = 0;
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setInt(1, student.getIdStudent());
            rows = s1.executeUpdate();
            return rows;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }

    public int updateById(Student student) {
        int rows = 0;
        String sql = "UPDATE public.student SET name=?, lastname=?,cellphone=?,address=?,email=? WHERE id_student=?";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setString(1, student.getName());
            s1.setString(2, student.getLastName());
            s1.setString(3, student.getCellphone());
            s1.setString(4, student.getAddress());
            s1.setString(5, student.getEmail());
            s1.setInt(6, student.getIdStudent());
            rows = s1.executeUpdate();
            return rows;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return 0;
        }
    }


    public Student getFromRsStudent(ResultSet rs) {
        try {
            Student data = new Student();
            data.setIdStudent(rs.getInt("id_student"));
            data.setName(rs.getString("name"));
            data.setLastName(rs.getString("lastname"));
            data.setCellphone(rs.getString("cellphone"));
            data.setAddress(rs.getString("address"));
            data.setEmail(rs.getString("email"));
            return data;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /*



    public Boolean add(Student entity) {
        String statement = "INSERT INTO public.student; (name, lastname,cellphone,address,email) VALUES ( ?,?,?,?,?)";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(statement)) {
            //s1.setInt(1,entity.getId());
            s1.setString(1, entity.getName());
            s1.setString(2, entity.getLastName());
            s1.setString(3, entity.getCellphone());
            s1.setString(4, entity.getAddress());
            s1.setString(5, entity.getEmail());
            Integer rs = s1.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }*/

}
