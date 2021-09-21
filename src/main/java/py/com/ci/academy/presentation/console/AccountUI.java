package py.com.ci.academy.presentation.console;

import py.com.ci.academy.inscription.entities.Inscription;

import java.util.List;
import java.util.Scanner;
import py.com.ci.academy.account.boundary.AccountController;
import py.com.ci.academy.account.entities.Account;
import py.com.ci.academy.inscription.boundary.InscriptionController;

public class AccountUI {

    Scanner sc = new Scanner(System.in);
    Account account = new Account();
    AccountController accountController = new AccountController();

    public static void main(String[] args) {
        AccountUI test = new AccountUI();
        test.mainMenu();
    }

    public void mainMenu() {
        System.out.println("Welcome to AccountUI beta 0.0");
        System.out.println("----------------------------------------");
        System.out.println("Choose an option ");
        System.out.println("1 : List all Accounts");
        System.out.println("2 : Add an Account");
        System.out.println("3 : Delete an Account");
        System.out.println("4 : Update an Account");
        System.out.println("5 : Exit");
        System.out.println("Option: ");
        String option = sc.next();
        try {
            Integer selectedOption = Integer.parseInt(option);
            switch (selectedOption) {
                case 1:
                    listAllAccounts();
                    break;
                case 2:
                    registerAccount();
                    break;
                case 3:
                    deleteAccount();
                    break;
                //case 4:
                    //updateAccount();
                    //break;
                case 5:
                    return;
            }
            mainMenu();
        } catch (Exception ex) {

            mainMenu();
        }
    }

    public void listAllAccounts() {
        List<Account> accounts = accountController.getAll();
        if (!accounts.isEmpty()) {
            for (Account account : accounts) {
                System.out.println(account);
            }
        } else {
            System.out.println("No account found");
        }
    }

    public void registerAccount() {
    }

    private void deleteAccount() {
    }
}
