package py.com.ci.academy.account.entities;

import java.time.LocalDate;

public class Account {

    public LocalDate expireDate;
    private int idAccount;
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

    public int getIdAccount() {
        return idAccount;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public String getStatus() {
        return status;
    }

    public int getIdInscription() {
        return idInscription;
    }

    public String getRemark() {
        return remark;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setIdInscription(int idInscription) {
        this.idInscription = idInscription;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "idAccount= " + idAccount
                +", status= " + status
                + ", idInscription= " + idInscription
                + ", remark= " + remark
                + ", amount= " + amount
                + ", expireDate= " + expireDate
                + "\n----------------------------------------";
    }

}
