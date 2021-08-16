package py.com.ci.academy.inscription.boundary;

import py.com.ci.academy.inscription.entities.InscriptionReport;
import py.com.ci.academy.utils.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InscriptionReportManager {
    private String getStatement(){
        String sql="SELECT i.id_inscription,a.id_assignment,a.name_assignment,co.id_course,co.name_course, s.id_student,s.name,s.lastname,t.id_teacher,t.name_teacher,t.lastname FROM public.inscription i, public.assignment a, public.course co, public.courseassignment ca, public.student s, public.teacher t WHERE i.id_student= s.id_student AND i.id_cxa=ca.id_cxa AND a.id_assignment= ca.id_assignment AND t.id_teacher= co.id_teacher AND ca.id_course= co.id_course";
        return sql;
    }

    private InscriptionReport getFromRsInscription(ResultSet rs){
        try {
            InscriptionReport inscriptionReport= new InscriptionReport();
            inscriptionReport.setIdInscription(rs.getInt("id_inscription"));
            inscriptionReport.setIdAssignment(rs.getInt("id_assignment"));
            inscriptionReport.setNameAssignment(rs.getString("name_assignment"));
            inscriptionReport.setIdCourse(rs.getInt("id_course"));
            inscriptionReport.setNameCourse(rs.getString("name_course"));
            inscriptionReport.setIdStudent(rs.getInt("id_student"));
            inscriptionReport.setNameStudent(rs.getString("name"));
            inscriptionReport.setLastnameStudent(rs.getString("lastname"));
            inscriptionReport.setIdTeacher(rs.getInt("id_teacher"));
            inscriptionReport.setNameTeacher(rs.getString("name_teacher"));
            inscriptionReport.setLastnameTeacher(rs.getString(11));
            return inscriptionReport;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<InscriptionReport> getAll() {
        List<InscriptionReport> inscriptionReports = new ArrayList();
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(getStatement())) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    inscriptionReports.add(getFromRsInscription(rs));
                }
            }
            return inscriptionReports;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }

    public List<InscriptionReport> getById(int idInscription) {
        List<InscriptionReport> inscriptionReports = new ArrayList();
        String sql = getStatement() + " AND i.id_inscription =" + idInscription;
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    inscriptionReports.add(getFromRsInscription(rs));
                }
            }
            return inscriptionReports;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public List<InscriptionReport> getByNameStudent(String nameStudent) {
        List<InscriptionReport> inscriptionReports = new ArrayList();
        String sql = getStatement() + " AND s.name ILIKE " +"'"+ nameStudent+"'";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    inscriptionReports.add(getFromRsInscription(rs));
                }
            }
            return inscriptionReports;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public List<InscriptionReport> getByStudentLastname(String lastname) {
        List<InscriptionReport> inscriptionReports = new ArrayList();
        String sql = getStatement() + " AND s.lastname ILIKE " + "'" + lastname + "'";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    inscriptionReports.add(getFromRsInscription(rs));
                }
            }
            return inscriptionReports;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }
}
