package py.com.ci.academy.account.boundary;

import java.sql.Date;
import py.com.ci.academy.account.entities.Account;
import py.com.ci.academy.utils.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import py.com.ci.academy.account.controller.AccountController;

public class AccountManager {

    

    public String getStatement() {
        String statement = "SELECT ac.id_account, ac.date_account, ac.status, ac.remark, ac.amount, i.id_inscription FROM public.accounts ac, public.inscription i";
        return statement;
    }

    public Account getFromRsAccount(ResultSet rs) {
        AccountController accountController = new AccountController();
        try {
            //LocalDate localdate = LocalDate.now();
            Account account = new Account();
            account.setIdAccount(rs.getInt("id_account"));
            account.setIdInscription(rs.getInt("id_inscription"));
            account.setRemark(rs.getString("remark"));
            account.setStatus(rs.getString("status"));
            account.setAmount(rs.getInt("amount"));

            //Convertir a dateTime
            Date date = (rs.getDate("date_account"));
            java.util.Date utilDate = new java.util.Date(date.getTime());
            account.setExpireDate(accountController.convertToLocalDate(utilDate));
                    //account.setExpireDate(localdate);
                    //account.setExpireDate(temporaryDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            return account;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void addAccount(Account account) {
        AccountController accountController = new AccountController();
        String sql = "INSERT INTO public.accounts(id_account, date_account,remark,status,id_inscription,amount) VALUES (?,?,?,?,?,?)";
        java.sql.Date expire = (Date) accountController.convertToDate(account.getExpireDate());
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setInt(1,account.getIdAccount());
            s1.setDate(2, expire);
            s1.setString(3, account.getRemark());
            s1.setString(4, account.getStatus());
            s1.setInt(5, account.getIdInscription());
            s1.setInt(6, account.getAmount());
            s1.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Account getById(Integer IdAccount) {
        String sql = getStatement() + " where id_account = " + IdAccount;
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    return getFromRsAccount(rs);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int deleteById(Account account) {
        String sql = " DELETE FROM public.accounts WHERE account_id = ? ";
        int rows = 0;
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setInt(1, account.getIdAccount());
            rows = s1.executeUpdate();
            return rows;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return 0;
        }
    }

    public int updateById(Account account) {
        int rows = 0;
        String sql = "UPDATE public.accounts SET status=?, remark=?,date=? WHERE id_account=?";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setString(1, account.getStatus());
            s1.setString(2, account.getRemark());
            s1.setInt(3, account.getIdAccount());
            //s1.setDate(4, account.getExpireDate());

            rows = s1.executeUpdate();
            return rows;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return 0;
        }
    }

    public List<Account> getAll() {
        List<Account> accounts = new ArrayList<>();
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(getStatement())) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    accounts.add(getFromRsAccount(rs));
                }
            }
            return accounts;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private LocalDate[] getlocalDate() {
        LocalDate expireDate[] = new LocalDate[7];
        expireDate[0] = LocalDate.now();
        expireDate[1] = expireDate[0].with(TemporalAdjusters.lastDayOfMonth());
        for (int i = 2; i < expireDate.length; i++) {
            int j = i - 1;
            expireDate[i] = expireDate[j].with(TemporalAdjusters.lastDayOfMonth()).plusMonths(1);
        }
        for (int i = 0; i < expireDate.length; i++) {
            System.out.println(expireDate[i]);
        }
        return expireDate;
    }
}
