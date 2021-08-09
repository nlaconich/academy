package py.com.ci.academy.Course.entities;

public class Course {
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
                ", nameCourse=" + nameCourse +
                ", idTeacher=" + idTeacher +
                ", nameTeacher=" + nameTeacher +
                "\n----------------------------------------";
    }
}
