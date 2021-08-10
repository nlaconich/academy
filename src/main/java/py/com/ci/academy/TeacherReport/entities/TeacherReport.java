package py.com.ci.academy.TeacherReport.entities;

public class TeacherReport {
    private int idTeacher;
    private int idAssignment;
    private int idCourse;
    private String nameTeacher;
    private String lastNameTeacher;
    private String nameAssignment;
    private String nameCourse;

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public int getIdAssignment() {
        return idAssignment;
    }

    public void setIdAssignment(int idAssignment) {
        this.idAssignment = idAssignment;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }

    public String getLastNameTeacher() {
        return lastNameTeacher;
    }

    public void setLastNameTeacher(String lastNameTeacher) {
        this.lastNameTeacher = lastNameTeacher;
    }

    public String getNameAssignment() {
        return nameAssignment;
    }

    public void setNameAssignment(String nameAssignment) {
        this.nameAssignment = nameAssignment;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    @Override
    public String toString() {
        return "idTeacher=" + idTeacher +
                ", nameTeacher= " + nameTeacher +
                ", lastNameTeacher= " + lastNameTeacher +
                ", idAssignment=" + idAssignment +
                ", nameAssignment =" + nameAssignment +
                ", idCourse=" + idCourse +
                ", nameCourse= " + nameCourse ;
    }
}
