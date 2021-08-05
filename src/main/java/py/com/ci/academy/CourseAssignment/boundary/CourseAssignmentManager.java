package py.com.ci.academy.CourseAssignment.boundary;

import py.com.ci.academy.CourseAssignment.entities.CourseAssignment;
import py.com.ci.academy.utils.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseAssignmentManager {

    private String getStatement() {
        String sql = "SELECT ca.id_cxa, ca.id_course, c.name_course, ca.id_assignment, a.name_assignment FROM public.courseassignment ca, public.course c, public.assignment a WHERE (ca.id_course = c.id_course) AND (ca.id_assignment = a.id_assignment)";
        return sql;
    }

    private CourseAssignment getFromRsInscription(ResultSet rs) {
        try {
            CourseAssignment courseAssignment = new CourseAssignment();
            courseAssignment.setIdCourseAssignment(rs.getInt("id_cxa"));
            courseAssignment.setIdCourse(rs.getInt("id_course"));
            courseAssignment.setNameCourse(rs.getString("name_course"));
            courseAssignment.setIdAssignment(rs.getInt("id_assignment"));
            courseAssignment.setNameAssignment(rs.getString("name_assignment"));
            return courseAssignment;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addCourseAssignment(CourseAssignment report) {
        String sql = "INSERT INTO public.courseassignment(id_course, id_assignment) VALUES (?,?)";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setInt(1, report.getIdCourse());
            s1.setInt(2, report.getIdAssignment());
            s1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CourseAssignment> getAll() {
        List<CourseAssignment> courseAssignments = new ArrayList<>();
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(getStatement())) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    courseAssignments.add(getFromRsInscription(rs));
                }
            }
            return courseAssignments;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateCourseAssignment(CourseAssignment courseAssignment) {
        String sql = "UPDATE public.courseassignment SET id_course= ?, id_assignment=? WHERE id_cxa=?";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setInt(1, courseAssignment.getIdCourse());
            s1.setInt(2, courseAssignment.getIdAssignment());
            s1.setInt(3, courseAssignment.getIdCourseAssignment());
            s1.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean deleteCourseAssignment(CourseAssignment courseAssignment) {
        String sql = "DELETE FROM public.courseassignment WHERE id_cxa= ?";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setInt(1, courseAssignment.getIdCourseAssignment());
            s1.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
}