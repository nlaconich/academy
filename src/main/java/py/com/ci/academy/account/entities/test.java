/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ci.academy.account.entities;

import java.time.LocalDate;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import py.com.ci.academy.account.controller.AccountController;

/**
 *
 * @author martin
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AccountController accountController= new AccountController();
        accountController.addAccount(2);
//addAccount(2);
    }
    
    public static void addAccount(int idAccount) {
        Account account= new Account();
        LocalDate localdate;
        account.setIdAccount(idAccount);
        account.setStatus("Pending");
        account.setAmount(50000);
        for (int i = 0; i < 6; i++) {
            localdate = LocalDate.now().plusMonths(i).with(lastDayOfMonth());
            account.setExpireDate(localdate);
//           accountManager.addAccount(account);
            System.out.println(account);
        }
    }
}
