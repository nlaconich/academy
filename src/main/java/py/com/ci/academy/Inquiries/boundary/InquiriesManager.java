package py.com.ci.academy.Inquiries.boundary;


import py.com.ci.academy.Inquiries.entities.Inquiries;
import py.com.ci.academy.utils.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InquiriesManager {
    private String getStatement() {
        String sql = "SELECT inq.id_inquiries, inq.id_sxa, inq.id_student, inq.id_assignment, a.name_assignment, s.name FROM  public.inquiries inq, public.student s, public.assignment a WHERE (inq.id_student= s.id_student) and (inq.id_assignment = a.id_assignment)";
        return sql;
    }
    private Inquiries getFromRsInquiries(ResultSet rs) {
        try {
            Inquiries inquiries = new Inquiries();
            inquiries.setIdInquiries(rs.getInt("id_inquiries"));
            inquiries.setIdInquiries(rs.getInt("id_sxa"));
            inquiries.setIdStudent(rs.getInt("id_student"));
            inquiries.setIdAssignment(rs.getInt("id_assignment"));
            inquiries.setNameAssignment(rs.getString("name_assignment"));
            inquiries.setNameStudent(rs.getString("name"));
            return inquiries;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean addInquiries(Inquiries student) {
        String sql = "INSERT INTO public.inquiries(id_student, id_assignment) VALUES(?,?);";
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

    public List<Inquiries> getAll() {
        List<Inquiries> inquiries = new ArrayList<>();
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(getStatement())) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    inquiries.add(getFromRsInquiries(rs));
                }
            }
            return inquiries;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateInquiries(Inquiries inquiries) {
        String sql = "UPDATE public.inquiries SET id_student=?, id_assignment=? WHERE id_sxa=?";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setInt(1, inquiries.getIdStudent());
            s1.setInt(2, inquiries.getIdAssignment());
            s1.setInt(3, inquiries.getIdInquiries());
            s1.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteInquirires(Inquiries assignment) {
        String sql = "DELETE FROM public.inquiries WHERE id_sxa= ?";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setInt(1, assignment.getIdAssignment());
            s1.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }


}
