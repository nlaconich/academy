package py.com.ci.academy.teacher.boundary;

import py.com.ci.academy.teacher.entities.Teacher;
import py.com.ci.academy.utils.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeacherManager {

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
        String statement = "SELECT id_teacher, name_teacher, lastName, cellphone, address, email FROM public.teacher;";
        return statement;
    }

    public Teacher getFromRsTeacher(ResultSet rs) {
        try {
            Teacher data = new Teacher();
            data.setIdTeacher(rs.getInt("id_teacher"));
            data.setNameTeacher(rs.getString("name_teacher"));
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

    public Boolean add(Teacher teacher) {
        String statement = "INSERT INTO public.teacher(name_teacher, lastname, cellphone, address, email) VALUES ( ?, ?, ?, ?, ?)";
        try (PreparedStatement s1 = ConnectionManager.getConnection()
                .prepareStatement(statement)) {
            s1.setString(1, teacher.getNameTeacher());
            s1.setString(2, teacher.getLastName());
            s1.setString(3, teacher.getCellphone());
            s1.setString(4, teacher.getAddress());
            s1.setString(5, teacher.getEmail());
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

    public int deleteTeacher(Teacher teacher) {       
        String sql = "DELETE FROM public.teacher, public.course WHERE id_teacher=?";
         int rows = 0;
                try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setInt(1, teacher.getIdTeacher());
            rows = s1.executeUpdate();
            return rows;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }

    public int updateTeacher(Teacher teacher) {
        int rows = 0;
        String sql = "UPDATE public.teacher SET name_teacher=?, lastname=?,cellphone=?,address=?,email=? WHERE id_teacher=?";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setString(1, teacher.getNameTeacher());
            s1.setString(2, teacher.getLastName());
            s1.setString(3, teacher.getCellphone());
            s1.setString(4, teacher.getAddress());
            s1.setString(5, teacher.getEmail());
            s1.setInt(6, teacher.getIdTeacher());
            rows = s1.executeUpdate();
            return rows;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }

}
