package py.com.ci.academy.Inscription.entities;

public class Inscription {
    private int idInscription;
    private int idCourse;
    private int idStudent;
    private String nameCourse;
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

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    @Override
    public String toString() {
        return "Inscription{" +
                "idInscription=" + idInscription +
                ", idCourse=" + idCourse +
                ", idStudent=" + idStudent +
                ", nameCourse='" + nameCourse + '\'' +
                ", nameStudent='" + nameStudent + '\'' +
                '}';
    }
}
