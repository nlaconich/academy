package py.com.ci.academy.inscription.entities;

public class Inscription {
    private int idInscription;
    private int idStudent;
    private String nameStudent;
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

    @Override
    public String toString() {
        return "Inscription{" +
                "idInscription=" + idInscription +
                ", idStudent=" + idStudent +
                ", nameStudent='" + nameStudent + '\'' +
                '}';
    }
}
