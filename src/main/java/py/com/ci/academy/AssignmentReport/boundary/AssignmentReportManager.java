package py.com.ci.academy.AssignmentReport.boundary;

import py.com.ci.academy.AssignmentReport.entities.AssignmentReport;
import py.com.ci.academy.utils.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AssignmentReportManager {

    private String getStatement(){
        String sql="SELECT a.id_assignment, a.name_assignment, co.id_course, co.name_course, s.id_student, s.name, s.lastname FROM public.assignment a, public.course co, public.student s, public.courseassignment ca WHERE a.id_assignment = ca.id_assignment AND co.id_course = ca.id_course";
        return sql;
    }

    private AssignmentReport getFromRsTeacherManager(ResultSet rs){
        try {
            AssignmentReport assignmentReport= new AssignmentReport();
            assignmentReport.setIdAssignment(rs.getInt("id_assignment"));
            assignmentReport.setNameAssignment(rs.getString("name_assignment"));
            assignmentReport.setIdCourse(rs.getInt("id_course"));
            assignmentReport.setNameCourse(rs.getString("name_course"));
            assignmentReport.setIdStudent(rs.getInt("id_student"));
            assignmentReport.setNameStudent(rs.getString("name"));
            assignmentReport.setLastnameStudent(rs.getString("lastname"));
            return assignmentReport;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<AssignmentReport> getAll() {
        List<AssignmentReport> assignmentReports = new ArrayList();
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(getStatement())) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    assignmentReports.add(getFromRsTeacherManager(rs));
                }
            }
            return assignmentReports;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }

    public List<AssignmentReport> getById(int idAssignment) {
        List<AssignmentReport> assignmentReports = new ArrayList();
        String sql = getStatement() + " AND a.id_assignment =" + idAssignment;
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    assignmentReports.add(getFromRsTeacherManager(rs));
                }
            }
            return assignmentReports;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public List<AssignmentReport> getByName(String nameAssignment) {
        List<AssignmentReport> assignmentReports = new ArrayList();
        String sql = getStatement() + " AND a.name_assignment=" +"'"+ nameAssignment+"'";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    assignmentReports.add(getFromRsTeacherManager(rs));
                }
            }
            return assignmentReports;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
