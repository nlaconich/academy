package py.com.ci.academy.account.boundary;

import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import py.com.ci.academy.account.entities.Account;

public class AccountController {

    Account account = new Account();
    AccountManager accountManager = new AccountManager();

    public void addAccount(int idInscription) {
        LocalDate date;
//        date.add(LocalDate.now().plusMonths(i).with(lastDayOfMonth()));
//      date_account,remark,status,id_inscription,amount
        for (int i = 0; i < 6; i++) {
            date=LocalDate.now().plusMonths(i).with(lastDayOfMonth());
            account.setExpireDate(convertToDate(date));
            account.setStatus("Pending");
            account.setAmount(50000);
        }

    }

    //-------------SET DATE OF ACCOUNT
    public LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Date convertToDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }

}
