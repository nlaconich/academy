package py.com.ci.academy.inscription.entities;

public class Inscription {
    private int idInscription;
    private int idStudent;
    private String nameStudent;
    private  int idCourse;
    private String nameCourse;
    private int idAssignment;
    private String nameAssignment;
    private int idCxA;

    public int getIdCxA() {
        return idCxA;
    }

    public void setIdCxA(int idCxA) {
        this.idCxA = idCxA;
    }

    public int getIdInscription() {
        return idInscription;
    }

    public void setIdInscription(int idInscription) {
        this.idInscription = idInscription;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
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
        return "idInscription=" + idInscription +
                ", idStudent=" + idStudent +
                ", nameStudent='" + nameStudent + '\'' +
                ", idCourse=" + idCourse +
                ", nameCourse='" + nameCourse + '\'' +
                ", idAssignment=" + idAssignment +
                ", nameAssignment='" + nameAssignment + '\'' +
                "\n---------------------------------------";
    }
}
