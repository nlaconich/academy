package py.com.ci.academy.Assignment.boundary;

import py.com.ci.academy.Assignment.entities.Assignment;
import py.com.ci.academy.utils.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class AssignmentManager {
    Assignment assignment = new Assignment();

    private String getStatement() {
        String statement = "SELECT id_assignment, name_assignment FROM public.assignment";
        return statement;
    }

    private Assignment getFromRsAssignment(ResultSet rs) {
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(getStatement())) {
            assignment.setIdAssignment(rs.getInt("id_assignment"));
            assignment.setNameAssignment(rs.getString("name_assignment"));
            return assignment;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addAssignment(Assignment assignment) {
        String sql = " INSERT INTO public.assignment(name_assignment) VALUES (?);";

        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setString(1, assignment.getNameAssignment());
            s1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Assignment> getAll() {
        List<Assignment> assignments = new ArrayList<>();

        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(getStatement())) {
            s1.setMaxRows(100);
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
        String sql = "UPDATE public.assignment(name_assignment) WHERE id_statement=?;";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setString(1, assignment.getNameAssignment());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteAssignment(Assignment assignment){
        String sql="DELETE FROM public.assignment WHERE id_assignment=?;";
        try (PreparedStatement s1= ConnectionManager.getConnection().prepareStatement(sql)){
            s1.setInt(1,assignment.getIdAssignment());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
