package py.com.ci.academy.account.boundary;
import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import java.util.Date;
import java.util.List;
import py.com.ci.academy.account.entities.Account;

public class AccountController {

    Account account = new Account();
    AccountManager accountManager = new AccountManager();

    public void addAccount(int idAccount) {
        LocalDate localdate;
        account.setIdAccount(idAccount);
        account.setStatus("Pending");
        account.setAmount(50000);
        for (int i = 0; i < 6; i++) {
            localdate=LocalDate.now().plusMonths(i).with(lastDayOfMonth());
            account.setExpireDate(localdate);
            accountManager.addAccount(account);
        }
    }
    
        
    public LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Date convertToDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }


    public List<Account> getAll(){
        List<Account> accounts = accountManager.getAll();
        return accounts;
    }
    
    public int updateAccount(Account account) {
        int ban = accountManager.updateById(account);
        return ban;
    }
    
    public int deleteAccount(Account account) {
        int ban = accountManager.deleteById(account);
        return ban;
    }

}

