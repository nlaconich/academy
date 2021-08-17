package py.com.ci.academy.inscription.entities;

public class InscriptionReport {

    private int idInscription;
    private int idAssignment;
    private String nameAssignment;
    private int idCourse;
    private String nameCourse;
    private int idStudent;
    private String nameStudent;
    private String lastnameStudent;
    private int idTeacher;
    private String nameTeacher;
    private String lastnameTeacher;

    public int getIdInscription() {
        return idInscription;
    }

    public void setIdInscription(int idInscription) {
        this.idInscription = idInscription;
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

    public String getLastnameStudent() {
        return lastnameStudent;
    }

    public void setLastnameStudent(String lastnameStudent) {
        this.lastnameStudent = lastnameStudent;
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

    public String getLastnameTeacher() {
        return lastnameTeacher;
    }

    public void setLastnameTeacher(String lastnameTeacher) {
        this.lastnameTeacher = lastnameTeacher;
    }

    @Override
    public String toString() {
        return "idInscription = " + idInscription +
                "\nidAssignment = " + idAssignment +
                "\nnameAssignment = " + nameAssignment +
                "\nidCourse = " + idCourse +
                "\nnameCourse = " + nameCourse +
                "\nidStudent = " + idStudent +
                "\nnameStudent = " + nameStudent +
                "\nlastnameStudent = " + lastnameStudent +
                "\nidTeacher = " + idTeacher +
                "\nnameTeacher = " + nameTeacher +
                "\nlastnameTeacher = " + lastnameTeacher +
                "\n----------------------------------------";
    }
}
