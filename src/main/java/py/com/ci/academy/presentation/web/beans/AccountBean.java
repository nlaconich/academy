package py.com.ci.academy.presentation.web.beans;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import py.com.ci.academy.account.boundary.AccountManager;
import py.com.ci.academy.account.entities.Account;

@Named("accountBean")
@SessionScoped
public class AccountBean implements Serializable {

    private List<Account> accountList;
    private Account account;
    private AccountManager accountManager;

    @PostConstruct
    public void init() {
        Account account = new Account();
        AccountManager accountManager = new AccountManager();
        List<Account> accountList = accountManager.getAll();
        logAccount();
        RequestContext.getCurrentInstance().update("account-form:dtAccount");
    }

    public void logAccount() {
        if (accountList != null && !accountList.isEmpty()) {
            System.out.println("AccountBean  - init > " + accountList);
        } else {
            System.out.println("AccountBean  - init > no result fount");
        }
    }

    public List<Account> getAccountList() {
        return accountList;
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
