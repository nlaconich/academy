package py.com.ci.academy.Course.entities;

public class Course {
    private int idCourse;
    private String nameCourse;
    private int idAssignment;
    private int idTeacher;
    private String nameAssignment;

    public String getNameAssignment() {
        return nameAssignment;
    }

    public void setNameAssignment(String nameAssignment) {
        this.nameAssignment = nameAssignment;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
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

    @Override
    public String toString() {
        return "Course{" +
                "idCourse=" + idCourse +
                ", nameCourse='" + nameCourse + '\'' +
                ", idAssignment=" + idAssignment +
                ", nameAssignment='" + nameAssignment + '\'' +
                ", idTeacher=" + idTeacher +
                '}';
    }
}
