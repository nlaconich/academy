package py.com.ci.academy.course.boundary;

import py.com.ci.academy.course.entities.CourseReport;
import py.com.ci.academy.utils.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseReportManager {
    private String getStatement(){
        String sql= "SELECT co.id_course, co.name_course, a.id_assignment, a.name_assignment, s.id_student, s.name, s.lastname, t.id_teacher, t.name_teacher, t.lastname FROM public.course co, public.assignment a, public.student s, public.courseassignment ca, public.teacher t WHERE co.id_course= ca.id_course AND a.id_assignment= ca.id_assignment and t.id_teacher= co.id_teacher";
        return sql;
    }

    private CourseReport getFromRsTeacherManager(ResultSet rs){
        try {
            CourseReport courseReport= new CourseReport();
            courseReport.setIdCourse(rs.getInt("id_course"));
            courseReport.setNameCourse(rs.getString("name_course"));
            courseReport.setIdAssignment(rs.getInt("id_assignment"));
            courseReport.setNameAssignment(rs.getString("name_assignment"));
            courseReport.setIdStudent(rs.getInt("id_student"));
            courseReport.setNameStudent(rs.getString("name"));
            courseReport.setLastnameStudent(rs.getString(7));
            courseReport.setIdTeacher(rs.getInt("id_teacher"));
            courseReport.setNameTeacher(rs.getString("name_teacher"));
            courseReport.setLastnameTeacher(rs.getString(10));
            return courseReport;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<CourseReport> getAll() {
        List<CourseReport> courseReports = new ArrayList();
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(getStatement())) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    courseReports.add(getFromRsTeacherManager(rs));
                }
            }
            return courseReports;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }

    public List<CourseReport> getById(int idCourse) {
        List<CourseReport> courseReports = new ArrayList();
        String sql = getStatement() + " AND co.id_course =" + idCourse;
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    courseReports.add(getFromRsTeacherManager(rs));
                }
            }
            return courseReports;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public List<CourseReport> getByName(String nameCourse) {
        List<CourseReport> courseReports = new ArrayList();
        String sql = getStatement() + " AND co.name_course ILIKE" +"'"+ nameCourse+"'";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    courseReports.add(getFromRsTeacherManager(rs));
                }
            }
            return courseReports;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

}