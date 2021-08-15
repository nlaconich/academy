package py.com.ci.academy.inscription.entities;

public class Inscription {
    private int idInscription;
    private int idCourse;
    private int idCxA;
    private int idAssignment;
    private int idStudent;
    private String nameCourse;
    private String nameAssignment;
    private String nameStudent;

    public int getIdInscription() {
        return idInscription;
    }

    public void setIdInscription(int idInscription) {
        this.idInscription = idInscription;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public int getIdCxA() {
        return idCxA;
    }

    public void setIdCxA(int idCxA) {
        this.idCxA = idCxA;
    }

    public int getIdAssignment() {
        return idAssignment;
    }

    public void setIdAssignment(int idAssignment) {
        this.idAssignment = idAssignment;
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

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    @Override
    public String toString() {
        return "idInscription= " + idInscription +
                ", idCoursexAssignment= " + idCxA +
                ", idStudent= " + idStudent +
                ", nameCourse= " + nameCourse +
                ", nameAssignment= " + nameAssignment +
                ", nameStudent= " + nameStudent +
                "\n----------------------------------------";
    }
}
