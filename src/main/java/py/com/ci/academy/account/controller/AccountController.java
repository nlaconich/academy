package py.com.ci.academy.account.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import py.com.ci.academy.account.boundary.AccountManager;
import py.com.ci.academy.account.entities.Account;

public class AccountController {

    Account account= new Account();
    AccountManager accountManager = new AccountManager();

    public void addAccount(int idInscription) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        
        LocalDate localdate;
        account.setIdInscription(idInscription);
        account.setStatus("Pending");
        account.setAmount(50000);
        for (int i = 0; i < 6; i++) {
            //localdate = LocalDate.now().plusMonths(i).with(lastDayOfMonth());
            calendar.add(Calendar.MONTH, 1);
            account.setExpireDate(calendar.getTime());
            accountManager.addAccount(account);
            System.out.println(account);
        }
    }

    public List<Account> getAll() {
        List<Account> accountList = accountManager.getAll();
        return accountList;
    }

    public LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Date convertToDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
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
