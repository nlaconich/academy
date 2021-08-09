package py.com.ci.academy.CourseAssignment.entities;

public class CourseAssignment {
    private int idCourseAssignment;
    private int idCourse;
    private String nameCourse;
    private int idAssignment;
    private String nameAssignment;

    public int getIdCourseAssignment() {
        return idCourseAssignment;
    }

    public void setIdCourseAssignment(int idCourseAssignment) {
        this.idCourseAssignment = idCourseAssignment;
    }

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

    public int getIdAssignment() {
        return idAssignment;
    }

    public void setIdAssignment(int idAssignment) {
        this.idAssignment = idAssignment;
    }

    public String getNameAssignment() {
        return nameAssignment;
    }

    public void setNameAssignment(String nameAssignment) {
        this.nameAssignment = nameAssignment;
    }

    @Override
    public String toString() {
        return "idCourseAssignment=" + idCourseAssignment +
                ", idCourse=" + idCourse +
                ", nameCourse=" + nameCourse +
                ", idAssignment=" + idAssignment +
                ", nameAssignment=" + nameAssignment +
                "\n----------------------------------------";

    }
}
