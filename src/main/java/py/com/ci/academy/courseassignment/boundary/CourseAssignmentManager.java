package py.com.ci.academy.courseassignment.boundary;

import py.com.ci.academy.courseassignment.entities.CourseAssignment;
import py.com.ci.academy.utils.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import py.com.ci.academy.assignment.entities.Assignment;

public class CourseAssignmentManager {

    private String getStatement() {
        String sql = "SELECT ca.id_cxa, ca.id_course, co.name_course, ca.id_assignment, a.name_assignment FROM public.courseassignment ca, public.course co, public.assignment a WHERE (ca.id_course= co.id_course) and (ca.id_assignment = a.id_assignment) ";
        return sql;
    }

    private CourseAssignment getFromRsCourse(ResultSet rs) {
        try {
            CourseAssignment course = new CourseAssignment();
            course.setIdCourseAssignment(rs.getInt("id_cxa"));
            course.setIdCourse(rs.getInt("id_course"));
            course.setNameCourse(rs.getString("name_course"));
            course.setIdAssignment(rs.getInt("id_assignment"));
            course.setNameAssignment(rs.getString("name_assignment"));
            return course;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int obtainCourseAssignmentId(int courseId, int assignmentId) throws SQLException {
        String sql = "SELECT id_cxa FROM public.courseassignment WHERE id_assignment=? AND id_course=?";
        try ( PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, assignmentId);
            stmt.setInt(2, courseId);
            ResultSet rs = stmt.executeQuery();
            CourseAssignment courseAssignment = new CourseAssignment();
            while (rs.next()) {
                
                courseAssignment.setIdCourseAssignment(rs.getInt("id_cxa"));
            }
            return courseAssignment.getIdCourseAssignment();
        } catch (Exception e) {
            return -1;
        }
        
    }

    public List<Assignment> getAssignmentByIdCourse(int courseId) {
        String sql = "select *\n"
                + "from public.courseassignment ca\n"
                + "join public.\"assignment\" a on a.id_assignment = ca.id_assignment\n"
                + "where ca.id_course = ?";
        List<Assignment> assignmentList = new ArrayList();
        try ( PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Assignment courseAssignment = new Assignment();
                courseAssignment.setIdAssignment(rs.getInt("id_assignment"));
                courseAssignment.setNameAssignment(rs.getString("name_assignment"));
                assignmentList.add(courseAssignment);
            }
            return assignmentList;
        } catch (Exception e) {
            return assignmentList;
        }
    }

    public boolean addCourseAssignment(CourseAssignment course) {
        String sql = "INSERT INTO public.courseassignment(id_course, id_assignment) VALUES(?,?);";
        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setInt(1, course.getIdCourse());
            s1.setInt(2, course.getIdAssignment());
            s1.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<CourseAssignment> getAll() {
        List<CourseAssignment> courses = new ArrayList<>();
        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(getStatement())) {
            s1.setMaxRows(100);
            try ( ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    courses.add(getFromRsCourse(rs));
                }
            }
            return courses;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateCourseAssignment(CourseAssignment courseAssignment) {
        String sql = "UPDATE public.courseassignment SET id_course=?, id_assignment=? WHERE id_cxa=?";
        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setInt(1, courseAssignment.getIdCourse());
            s1.setInt(2, courseAssignment.getIdAssignment());
            s1.setInt(3, courseAssignment.getIdCourseAssignment());
            s1.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCourseAssignment(CourseAssignment course) {
        String sql = "DELETE FROM public.courseassignment WHERE id_cxa= ?";
        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setInt(1, course.getIdCourseAssignment());
            s1.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

}
