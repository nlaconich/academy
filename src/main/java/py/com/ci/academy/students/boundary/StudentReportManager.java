package py.com.ci.academy.students.boundary;

import py.com.ci.academy.students.entities.StudentReport;
import py.com.ci.academy.utils.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentReportManager {
    private String getStatement() {
        String sql = "SELECT sr.id_studentreport, s.lastname_student, sr.id_sxa, sr.id_student, sr.id_assignment, a.name_assignment, s.name FROM  public.studentreport sr, public.student s, public.assignment a WHERE (sr.id_student= s.id_student) and (sr.id_assignment = a.id_assignment)";
        return sql;
    }
    private StudentReport getFromRsStudentReport(ResultSet rs) {
        try {
            StudentReport studentReport = new StudentReport();
            studentReport.setIdStudentReport(rs.getInt("id_studentreport"));
            studentReport.setIdStudent(rs.getInt("id_assignment"));
            studentReport.setIdStudent(rs.getInt("id_student"));
            studentReport.setNameStudent(rs.getString("name"));
            studentReport.setLastname(rs.getString("lastname_student"));
            studentReport.setNameAssignment(rs.getString("name_assignment"));
            return studentReport;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean addStudentReport(StudentReport student) {
        String sql = "INSERT INTO public.studentreport(id_student, id_assignment) VALUES(?,?);";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setInt(1, student.getIdStudent());
            s1.setInt(2, student.getIdAssignment());
            s1.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<StudentReport> getAll() {
        List<StudentReport> studentReport = new ArrayList<>();
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(getStatement())) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    studentReport.add(getFromRsStudentReport(rs));
                }
            }
            return studentReport;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateStudentReport(StudentReport studentReport) {
        String sql = "UPDATE public.studentreport SET id_student=?, id_assignment=? WHERE id_sxa=?";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setInt(1, studentReport.getIdStudent());
            s1.setInt(2, studentReport.getIdAssignment());
            s1.setInt(3, studentReport.getIdStudentReport());
            s1.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteStudentReport(StudentReport studentReport) {
        String sql = "DELETE FROM public.studentreport WHERE id_sxa= ?";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setInt(1, studentReport.getIdStudentReport());
            s1.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }


}
