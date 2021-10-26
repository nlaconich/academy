package py.com.ci.academy.inscription.boundary;

import py.com.ci.academy.account.boundary.AccountManager;
import py.com.ci.academy.account.entities.Account;
import py.com.ci.academy.inscription.entities.Inscription;
import py.com.ci.academy.utils.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InscriptionManager {

    private static final String GET_SIZE_STATEMENT = "SELECT COUNT(id_inscription) AS 'size' FROM public.inscription";

    private String getStatement() {
        String sql = "SELECT i.id_inscription, i.id_student, s.name, co.id_course, co.name_course, a.id_assignment, a.name_assignment FROM public.inscription i, public.student s, public.courseassignment ca, public.course co, public.assignment  a WHERE i.id_student=s.id_student and ca.id_course = co.id_course and ca.id_assignment= a.id_assignment and i.id_cxa = ca.id_cxa";
        return sql;
    }

    public Integer getSize() {

        try ( PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(GET_SIZE_STATEMENT)) {
            ResultSet rs = stmt.executeQuery();
            return rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 9999;
    }

    private Inscription getFromRsInscription(ResultSet rs) {
        try {
            Inscription inscription = new Inscription();
            inscription.setIdInscription(rs.getInt("id_inscription"));
            inscription.setIdStudent(rs.getInt("id_student"));
            inscription.setNameStudent(rs.getString("name"));
            inscription.setIdCourse(rs.getInt("id_course"));
            inscription.setNameCourse(rs.getString("name_course"));
            inscription.setIdAssignment(rs.getInt("id_assignment"));
            inscription.setNameAssignment(rs.getString("name_assignment"));
            return inscription;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addInscription(Inscription report) {
        String sql = "INSERT INTO public.inscription(id_student, id_cxa) VALUES (?,?)";
        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            s1.setInt(1, report.getIdStudent());
            s1.setInt(2, report.getIdCxA());
            s1.executeUpdate();
            ResultSet generatedKeys = s1.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                Account account = new Account();
                account.setIdInscription(id);
                AccountManager accountManager = new AccountManager();
                accountManager.addAccount(account);
                System.out.println(account.getIdInscription());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Inscription> getAll() {
        List<Inscription> inscriptions = new ArrayList<>();
        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(getStatement())) {
            s1.setMaxRows(100);
            try ( ResultSet rs = s1.executeQuery()) {
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
        String sql = "UPDATE public.inscription SET id_student= ?, id_cxa= ? WHERE id_inscription=?";
        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setInt(1, inscription.getIdStudent());
            s1.setInt(2, inscription.getIdCxA());
            s1.setInt(3, inscription.getIdInscription());
            s1.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean deleteInscription(Inscription inscription) {
        String sql = "DELETE FROM public.accounts WHERE id_inscription= ?";
        String sql2 = "DELETE FROM public.inscription WHERE id_inscription= ?";
        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql);  PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(sql2)) {
            s1.setInt(1, inscription.getIdInscription());
            s1.executeUpdate();
            stmt.setInt(1, inscription.getIdInscription());
            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
}
