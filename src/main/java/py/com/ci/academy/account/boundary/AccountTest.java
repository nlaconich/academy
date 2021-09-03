package py.com.ci.academy.account.boundary;

import java.util.List;
import py.com.ci.academy.account.entities.Account;

public class AccountTest {

    public static void main(String[] args) {
        AccountManager manager = new AccountManager();
        List<Account> accounts = manager.getAll();
        
        if (!accounts.isEmpty()) {
            for(Account account:accounts){
                System.out.println(account);
            }
        }else{
            System.out.println("Empty List");
        }
    }
}
