package py.com.ci.academy.account.boundary;

import py.com.ci.academy.account.entities.Account;
import py.com.ci.academy.inscription.entities.Inscription;
import py.com.ci.academy.utils.ConnectionManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
public class AccountManager {

    public String getStatement() {
        String statement = "SELECT id_account, date_account, status,remark";
        return statement;
    }

    public void addAccount(Account account) {
        account.setStatus("Pending ");
        account.setAmount(50000);
        DayOfWeek expire;

        String sql = "INSERT INTO public.accounts(date_account,remark,status,id_inscription,amount) VALUES (?,?,?,?,?)";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            expire = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth()).getDayOfWeek();
            s1.setString(2, account.getRemark());
            s1.setString(3, account.getStatus());
            s1.setInt(4,account.getIdInscription());
            s1.setInt(5,account.getAmount());
            s1.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public Account getById(Integer IdAccount) {
        String sql = getStatement() + " where id_account = " + IdAccount;
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    Account oneAccount = new Account();
                    oneAccount.setIdAccount(rs.getInt(1));
                    return oneAccount;
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
            s1.setDate(4, account.getDateAccount());
            rows = s1.executeUpdate();
            return rows;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return 0;
        }
    }

    public List<Account> getAll() {
        List<Account> ListAccount = new ArrayList();
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(getStatement())) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    ListAccount.add(getFromRsAccount(rs));
                }
            }
            return ListAccount;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }

    public Account getFromRsAccount(ResultSet rs) {
        try {
            Account data = new Account();
            data.setIdAccount(rs.getInt("id_account"));
            data.setRemark(rs.getString("remark"));
            data.setStatus(rs.getString("status"));
            data.setDateAccount(rs.getInt("date_account"));
            return data;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
