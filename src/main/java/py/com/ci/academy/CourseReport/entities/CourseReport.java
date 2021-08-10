package py.com.ci.academy.CourseReport.entities;

public class CourseReport {
    private int idCourse;
    private int idAssignment;
    private int idTeacher;
    private int idStudent;
    private String nameCourse;
    private String nameAssignment;
    private String nameTeacher;
    private String lastnameTeacher;
    private String nameStudent;
    private String lastnameStudent;

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public int getIdAssignment() {
        return idAssignment;
    }

    public void setIdAssignment(int idAssignment) {
        this.idAssignment = idAssignment;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public String getNameAssignment() {
        return nameAssignment;
    }

    public void setNameAssignment(String nameAssignment) {
        this.nameAssignment = nameAssignment;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }

    public String getLastnameTeacher() {
        return lastnameTeacher;
    }

    public void setLastnameTeacher(String lastnameTeacher) {
        this.lastnameTeacher = lastnameTeacher;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getLastnameStudent() {
        return lastnameStudent;
    }

    public void setLastnameStudent(String lastnameStudent) {
        this.lastnameStudent = lastnameStudent;
    }

    @Override
    public String toString() {
        return "idCourse=" + idCourse +
                ", nameCourse= " + nameCourse +
                ", idAssignment=" + idAssignment +
                ", nameAssignment= " + nameAssignment +
                ", idTeacher=" + idTeacher +
                ", nameTeacher= " + nameTeacher +
                ", lastnameTeacher=" + lastnameTeacher +
                ", idStudent=" + idStudent +
                ", nameStudent=" + nameStudent +
                ", lastnameStudent=" + lastnameStudent +
                '}';
    }
}
