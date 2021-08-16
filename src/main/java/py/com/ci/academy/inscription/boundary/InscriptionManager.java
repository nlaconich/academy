package py.com.ci.academy.inscription.boundary;

import py.com.ci.academy.inscription.entities.Inscription;
import py.com.ci.academy.utils.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InscriptionManager {
    private String getStatement() {
        String sql = "SELECT i.id_inscription, i.id_student, s.name FROM public.inscription i, public.student s WHERE (i.id_student=s.id_student)";
        return sql;
    }

    private Inscription getFromRsInscription(ResultSet rs) {
        try {
            Inscription inscription = new Inscription();
            inscription.setIdInscription(rs.getInt("id_inscription"));
            inscription.setIdStudent(rs.getInt("id_student"));
            inscription.setNameStudent(rs.getString("name"));
            return inscription;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addInscription(Inscription report) {
        String sql = "INSERT INTO public.inscription(id_student) VALUES (?)";
        try (PreparedStatement s1= ConnectionManager.getConnection().prepareStatement(sql)){
            s1.setInt(1,report.getIdStudent());
            s1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Inscription> getAll() {
        List<Inscription> inscriptions = new ArrayList<>();
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(getStatement())) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    inscriptions.add(getFromRsInscription(rs));
                }
            }
            return inscriptions;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateInscription(Inscription inscription) {
        String sql = "UPDATE public.inscription SET id_student= ? WHERE id_inscription=?";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setInt(1, inscription.getIdStudent());
            s1.setInt(2, inscription.getIdInscription());
            s1.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean deleteInscription(Inscription inscription) {
        String sql = "DELETE FROM public.inscription WHERE id_inscription= ?";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setInt(1, inscription.getIdInscription());
            s1.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
}
