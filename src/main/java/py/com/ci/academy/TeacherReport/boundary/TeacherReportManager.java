package py.com.ci.academy.TeacherReport.boundary;

import py.com.ci.academy.TeacherReport.entities.TeacherReport;
import py.com.ci.academy.utils.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeacherReportManager {

    private String getStatement(){
        String sql="SELECT t.id_teacher, t.name_teacher,t.lastname,a.id_assignment, a.name_assignment, co.id_course, co.name_course FROM public.teacher t, public.assignment a, public.course co, public.courseassignment ca  WHERE t.id_teacher=co.id_teacher AND co.id_course = ca.id_course";
        return sql;
    }

    private TeacherReport getFromRsTeacherManager(ResultSet rs){
        try {
            TeacherReport teacherReport= new TeacherReport();
            teacherReport.setIdTeacher(rs.getInt("id_teacher"));
            teacherReport.setNameTeacher(rs.getString("name_teacher"));
            teacherReport.setLastNameTeacher(rs.getString("lastname"));
            teacherReport.setIdAssignment(rs.getInt("id_assignment"));
            teacherReport.setNameAssignment(rs.getString("name_assignment"));
            teacherReport.setIdCourse(rs.getInt("id_course"));
            teacherReport.setNameCourse(rs.getString("name_course"));
            return teacherReport;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<TeacherReport> getAll() {
        List<TeacherReport> listTeacher = new ArrayList();
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(getStatement())) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    listTeacher.add(getFromRsTeacherManager(rs));
                }
            }
            return listTeacher;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }

    public List<TeacherReport> getById(int idTeacher) {
        List<TeacherReport> listTeacher = new ArrayList();
        String sql = getStatement() + " AND t.id_teacher =" + idTeacher;
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    listTeacher.add(getFromRsTeacherManager(rs));
                }
            }
            return listTeacher;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public List<TeacherReport> getByName(String nameTeacher) {
        List<TeacherReport> listTeacher = new ArrayList();
        String sql = getStatement() + " AND t.name_teacher=" +"'"+ nameTeacher+"'";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    listTeacher.add(getFromRsTeacherManager(rs));
                }
            }
            return listTeacher;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public List<TeacherReport> getByLastName(String lastName) {
        List<TeacherReport> listTeacher = new ArrayList();
        String sql = getStatement() + " AND t.lastname=" +"'"+ lastName+"'";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    listTeacher.add(getFromRsTeacherManager(rs));
                }
            }
            return listTeacher;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
