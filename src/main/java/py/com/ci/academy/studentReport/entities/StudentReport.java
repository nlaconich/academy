package py.com.ci.academy.studentReport.entities;

public class StudentReport {
    private int idStudentReport;
    private int idStudent;
    private int idAssignment;
    private String nameStudent;
    private String lastname;
    private String nameAssignment;



    public int getIdStudentReport() {return idStudentReport;}

    public void setIdStudentReport(int idStudentReport) {this.idStudentReport = idStudentReport;}

    public int getIdStudent() {return idStudent;}

    public void setIdStudent(int idStudent) {this.idStudent = idStudent;}

    public int getIdAssignment() {return idAssignment;}

    public void setIdAssignment(int idAssignment) {this.idAssignment = idAssignment;}

    public String getNameStudent() {return nameStudent;}

    public void setNameStudent(String nameStudent) {this.nameStudent = nameStudent;}

    public String getLastname() {return lastname;}

    public void setLastname(String lastname) {this.lastname = lastname;}

    public String getNameAssignment() {return nameAssignment;}

    public void setNameAssignment(String nameAssignment) {this.nameAssignment = nameAssignment;}

    @Override
    public String toString() {
        return "Report id = " + idStudentReport + "\n" +
                "Student id = " + idStudent +
                "\n Student name = " + nameStudent +
                "\n Last Name = " + lastname +
                "\n Assignment = " + nameAssignment +
                "\n----------------------------------------";
    }

}
