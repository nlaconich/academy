package py.com.ci.academy.course.boundary;

import py.com.ci.academy.utils.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseManager {

    private String getStatement() {
        String sql = "SELECT c.id_course, c.name_course, c.id_teacher, t.name_teacher FROM public.course c, public.teacher t WHERE c.id_teacher = t.id_teacher;";
        return sql;
    }

    private Course getFromRsCourse(ResultSet rs) {
        try {
            Course course = new Course();
            course.setIdCourse(rs.getInt("id_course"));
            course.setNameCourse(rs.getString("name_course"));
            course.setIdTeacher(rs.getInt("id_teacher"));
            course.setNameTeacher(rs.getString("name_teacher"));
            return course;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addCourse(Course course) {
        String sql = "INSERT INTO public.course(name_course, id_teacher) VALUES(?,?);";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setString(1, course.getNameCourse());
            s1.setInt(2, course.getIdTeacher());
            s1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Course> getAll() {
        List<Course> courses = new ArrayList<>();
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(getStatement())) {
            s1.setMaxRows(10);
            try (ResultSet rs = s1.executeQuery()) {
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

    public boolean updateCourse(Course course) {
        String sql = "UPDATE public.course SET name_course=?, id_teacher=? WHERE id_course=?";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setString(1, course.getNameCourse());
            s1.setInt(2, course.getIdTeacher());
            s1.setInt(3, course.getIdCourse());
            s1.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean deleteCourse(Course course) {
        String sql = "DELETE FROM public.course WHERE id_course= ?";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setInt(1, course.getIdCourse());
            s1.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public static class Course {
        private int idCourse;
        private String nameCourse;
        private int idTeacher;
        private String nameTeacher;

        public int getIdCourse() {
            return idCourse;
        }

        public void setIdCourse(int idCourse) {
            this.idCourse = idCourse;
        }

        public String getNameCourse() {
            return nameCourse;
        }

        public void setNameCourse(String nameCourse) {
            this.nameCourse = nameCourse;
        }

        public int getIdTeacher() {
            return idTeacher;
        }

        public void setIdTeacher(int idTeacher) {
            this.idTeacher = idTeacher;
        }

        public String getNameTeacher() {
            return nameTeacher;
        }

        public void setNameTeacher(String nameTeacher) {
            this.nameTeacher = nameTeacher;
        }

        @Override
        public String toString() {
            return "idCourse=" + idCourse +
                    " nameCourse=" + nameCourse +
                    " idTeacher=" + idTeacher +
                    " nameTeacher=" + nameTeacher +
                    "\n----------------------------------------";
        }
    }
}
