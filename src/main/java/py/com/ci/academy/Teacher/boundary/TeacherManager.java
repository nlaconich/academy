package py.com.ci.academy.Teacher.boundary;

import py.com.ci.academy.Teacher.entities.Teacher;
import py.com.ci.academy.utils.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeacherManager {
    //private static final long serialVersionUID = 1L;

    public Teacher getById(Integer idTeacher) {
        String sql = getStatement() + " where idTeacher =" + idTeacher;
        try (PreparedStatement s1 = ConnectionManager.getConnection()
                .prepareStatement(sql)) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    return getFromRsTeacher(rs);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return null;
    }

    public List<Teacher> getAll() {
        List<Teacher> listTeacher = new ArrayList();
        try (PreparedStatement s1 = ConnectionManager.getConnection()
                .prepareStatement(getStatement())) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    listTeacher.add(getFromRsTeacher(rs));
                }
            }
            return listTeacher;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }

    public String getStatement() {
        String statement = "SELECT idTeacher, nameTeacher, lastName, cellphone, address, email,  url FROM public.Teacher;";
        return statement;
    }

    public Teacher getFromRsTeacher(ResultSet rs) {
        try {
            Teacher data = new Teacher();
            data.setIdTeacher(rs.getInt("idTeacher"));
            data.setNameTeacher(rs.getString("nameTeacher"));
            data.setLastName(rs.getString("lastName"));
            data.setCellphone(rs.getString("cellphone"));
            data.setAddress(rs.getString("address"));
            data.setEmail(rs.getString("email"));
            return data;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Boolean add(Teacher entity) {
        String statement = "INSERT INTO public.Teacher; (idTeacher, nameTeacher, lastName, cellphone, address, email) VALUES ( ?, ?, ?, ?, ?)";
        try (PreparedStatement s1 = ConnectionManager.getConnection()
                .prepareStatement(statement)) {
            s1.setInt(1, entity.getIdTeacher());
            s1.setString(2, entity.getNameTeacher());
            s1.setString(3, entity.getLastName());
            s1.setString(4, entity.getCellphone());
            s1.setString(5, entity.getAddress());
            s1.setString(6, entity.getEmail());
            Integer rs = s1.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }
}
