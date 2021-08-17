package py.com.ci.academy.account.entities;

import java.time.LocalDate;
import java.util.Date;

public class Account {

    public LocalDate LocalDate;
    private int idAccount;
    private Date dateAccount;
    private Date expiration;
    private String status;
    private int idInscription;
    private String remark;
    private int amount;


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getIdAccount(){return idAccount;}

    public Date getDateAccount() {
        return dateAccount;
    }

    public void setDateAccount(Date dateAccount) {
        this.dateAccount = dateAccount;
    }

    public String getStatus(){return status;}
    public int getIdInscription(){return idInscription;}
    public String getRemark(){return remark;}

    public void setIdAccount(int idAccount){this.idAccount=idAccount;}
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

