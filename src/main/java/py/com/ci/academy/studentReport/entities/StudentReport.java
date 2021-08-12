package py.com.ci.academy.studentReport.entities;

public class StudentReport {
    private int idStudent;
    private int idAssignment;
    private int idCourse;
    private String name;
    private String lastName;
    private String nameAssignment;
    private String nameCourse;


    public int getIdStudent() {return idStudent;}

    public void setIdStudent(int idStudent) {this.idStudent = idStudent;}

    public int getIdAssignment() {return idAssignment;}

    public void setIdAssignment(int idAssignment) {this.idAssignment = idAssignment;}

    public int getIdCourse() {return idCourse;}

    public void setIdCourse(int idCourse) {this.idCourse = idCourse;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getNameAssignment() {return nameAssignment;}

    public void setNameAssignment(String nameAssignment) {this.nameAssignment = nameAssignment;}

    public String getNameCourse() {return nameCourse;}

    public void setNameCourse(String nameCourse) {this.nameCourse = nameCourse;}

    @Override
    public String toString() {
        return "idStudent=" + idStudent +
                ", nameStudent= " + name +
                ", lastNameStudent= " + lastName +
                ", idAssignment=" + idAssignment +
                ", nameAssignment =" + nameAssignment +
                ", idCourse=" + idCourse +
                ", nameCourse= " + nameCourse;
    }
}

