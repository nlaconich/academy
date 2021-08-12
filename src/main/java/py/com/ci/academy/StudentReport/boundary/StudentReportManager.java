package py.com.ci.academy.StudentReport.boundary;

import py.com.ci.academy.StudentReport.entities.StudentReport;
import py.com.ci.academy.utils.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentReportManager {

    private String getStatement(){
        String sql="SELECT s.id_student, s.name,s.lastname,a.id_assignment, a.name_assignment, co.id_course, co.name_course FROM public.student s, public.assignment a, public.course co, public.courseassignment ca  WHERE s.id_student=co.id_student AND co.id_course = ca.id_course";
        return sql;
    }

    private StudentReport getFromRsStudentManager(ResultSet rs){
        try {
            StudentReport studentReport= new StudentReport();
            studentReport.setIdStudent(rs.getInt("id_student"));
            studentReport.setName(rs.getString("name"));
            studentReport.setLastName(rs.getString("lastname"));
            studentReport.setIdAssignment(rs.getInt("id_assignment"));
            studentReport.setNameAssignment(rs.getString("name_assignment"));
            studentReport.setIdCourse(rs.getInt("id_course"));
            studentReport.setNameCourse(rs.getString("name_course"));
            return studentReport;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<StudentReport> getAll() {
        List<StudentReport> listStudent = new ArrayList();
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(getStatement())) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    listStudent.add(getFromRsStudentManager(rs));
                }
            }
            return listStudent;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }

    public List<StudentReport> getById(int idStudent) {
        List<StudentReport> listStudent = new ArrayList();
        String sql = getStatement() + " AND s.id_Student =" + idStudent;
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    listStudent.add(getFromRsStudentManager(rs));
                }
            }
            return listStudent;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public List<StudentReport> getByName(String nameStudent) {
        List<StudentReport> listStudent = new ArrayList();
        String sql = getStatement() + " AND s.name=" +"'"+ nameStudent+"'";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    listStudent.add(getFromRsStudentManager(rs));
                }
            }
            return listStudent;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public List<StudentReport> getByLastName(String lastName) {
        List<StudentReport> listStudent = new ArrayList();
        String sql = getStatement() + " AND s.lastname=" +"'"+ lastName+"'";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    listStudent.add(getFromRsStudentManager(rs));
                }
            }
            return listStudent;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
