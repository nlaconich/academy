package py.com.ci.academy.account.entities;

public class Account {

    private int idAccount;
    private int dateAccount;
    private String status;
    private int idInscription;
    private String remark;

    public int getIdAccount(){return idAccount;}
    public int getDateAccount(){return dateAccount;}
    public String getStatus(){return status;}
    public int getIdInscription(){return idInscription;}
    public String getRemark(){return remark;}

    public void setIdAccount(int idAccount){this.idAccount=idAccount;}
    public void setDateAccount(int dateAccount){this.dateAccount=dateAccount;}
    public void setStatus(String status){this.status=status;}
    public void setIdInscription(int idInscription){this.idInscription=idInscription;}
    public void setRemark(String remark){this.remark=remark;}

    @Override
    public String toString() {
        return "idAccount= " + idAccount +
                ", dateAccount= " + dateAccount +
                ", status= " + status +
                ", idInscription= " + idInscription +
                ", remark= " + remark +
                "\n----------------------------------------";
    }
}

