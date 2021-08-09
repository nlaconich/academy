package py.com.ci.academy.Assignment.boundary;

import py.com.ci.academy.Assignment.entities.Assignment;
import py.com.ci.academy.utils.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class AssignmentManager {

    private String getStatement() {
        String statement = "SELECT id_assignment, name_assignment FROM public.assignment";
        return statement;
    }

    private Assignment getFromRsAssignment(ResultSet rs) {
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(getStatement())) {
            Assignment data = new Assignment();
            data.setIdAssignment(rs.getInt("id_assignment"));
            data.setNameAssignment(rs.getString("name_assignment"));
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean addAssignment(Assignment assignment) {
        String sql = " INSERT INTO public.assignment(name_assignment) VALUES (?);";

        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setString(1, assignment.getNameAssignment());
            s1.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Assignment> getAll() {
        List<Assignment> assignments = new ArrayList<>();

        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(getStatement())) {
            s1.setMaxRows(10);
            ResultSet rs = s1.executeQuery();
            while (rs.next()) {
                assignments.add(getFromRsAssignment(rs));
            }
            return assignments;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean updateAssignment(Assignment assignment) {
        String sql = "UPDATE public.assignment SET name_assignment=? WHERE id_assignment=?";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setString(1, assignment.getNameAssignment());
            s1.setInt(2, assignment.getIdAssignment());
            s1.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean deleteAssignment(Assignment assignment) {
        String sql = "DELETE FROM public.assignment WHERE id_assignment=?;";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setInt(1, assignment.getIdAssignment());
            s1.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
