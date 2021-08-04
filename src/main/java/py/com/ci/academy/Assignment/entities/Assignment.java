package py.com.ci.academy.Assignment.entities;

public class Assignment {
    private int idAssignment;
    private String nameAssignment;

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
        return "Assignment{" +
                "idAssignment=" + idAssignment +
                ", nameAssignment='" + nameAssignment + '\'' +
                '}';
    }
}
