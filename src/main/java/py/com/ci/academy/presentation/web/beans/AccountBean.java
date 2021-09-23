package py.com.ci.academy.presentation.web.beans;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;
import py.com.ci.academy.account.boundary.AccountManager;
import py.com.ci.academy.account.controller.AccountController;
import py.com.ci.academy.account.entities.Account;

@Named("accountBean")
@SessionScoped
@ViewScoped

public class AccountBean implements Serializable {

    private List<Account> accountList;
    private Account account;
    private AccountManager accountManager;
    private AccountController accountController;

    @PostConstruct
    public void init() {
        account = new Account();
        accountManager = new AccountManager();
        accountList = accountManager.getAll();
        accountController = new AccountController();
        logAccount();
        //RequestContext.getCurrentInstance().update("account-form:dtAccount");
    }
    
    @Inject
    InscriptionBean inscriptionBean;
    
    public List<Account> getAccountList() {
        return accountList;
    }

    public void logAccount() {
        if (accountList != null && !accountList.isEmpty()) {
            System.out.println("AccountBean  - init > " + accountList);
        } else {
            System.out.println("AccountBean  - init > no result fount");
        }
    }

    public InscriptionBean getInscriptionBean() {
        return inscriptionBean;
    }

    public void setInscriptionBean(InscriptionBean inscriptionBean) {
        this.inscriptionBean = inscriptionBean;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    //---------C R U D
    public void addAccount() {
        accountManager.addAccount(account);
        init();
    }

    public void deleteAccount() {
        accountManager.deleteById(account);
        init();
    }

    public void updateAccount() {
        accountManager.updateById(account);
        init();
    }

    //---------TABLE MANAGEMENT
    public void onRowSelected(SelectEvent event) {
        this.account = (Account) event.getObject();

        FacesMessage msg = new FacesMessage("Account Selected id", String.valueOf(account.getIdAccount()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("AccountBean > Select Row > " + this.account);

    }

}
