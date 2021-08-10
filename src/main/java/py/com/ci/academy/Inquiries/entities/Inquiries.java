package py.com.ci.academy.Inquiries.entities;

public class Inquiries {
    private int idInquiries;
    private int idStudent;
    private int idAssignment;
    private String nameStudent;
    private String nameAssignment;

    public int getIdInquiries() {return idInquiries;}

    public void setIdInquiries(int idInquiries) {this.idInquiries = idInquiries;}

    public int getIdStudent() {return idStudent;}

    public void setIdStudent(int idStudent) {this.idStudent = idStudent;}

    public int getIdAssignment() {return idAssignment;}

    public void setIdAssignment(int idAssignment) {this.idAssignment = idAssignment;}

    public String getNameStudent() {return nameStudent;}

    public void setNameStudent(String nameStudent) {this.nameStudent = nameStudent;}

    public String getNameAssignment() {return nameAssignment;}

    public void setNameAssignment(String nameAssignment) {this.nameAssignment = nameAssignment;}

    @Override
    public String toString() {
        return "idInquiries=" + idInquiries +
                ", idStudent=" + idStudent +
                ", idAssignment=" + idAssignment +
                ", nameStudent=" + nameStudent +
                ", nameAssignment=" + nameAssignment +
                "\n----------------------------------------";

    }

}
