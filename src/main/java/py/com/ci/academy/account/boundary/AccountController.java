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
        LocalDate date;
        account.setIdAccount(idAccount);
        account.setStatus("Pending");
        account.setAmount(50000);
        for (int i = 0; i < 6; i++) {
            date=LocalDate.now().plusMonths(i).with(lastDayOfMonth());
            account.setExpireDate(convertToDate(date));
            accountManager.addAccount(account);
        }
    }
    
    
    public List<Account> getAll(){
        List<Account> account = accountManager.getAll();
        return account;
    }
        
    public LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Date convertToDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }

}
