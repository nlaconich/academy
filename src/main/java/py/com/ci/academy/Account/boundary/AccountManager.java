package py.com.ci.academy.Account.boundary;

import py.com.ci.academy.Account.entities.Account;
import py.com.ci.academy.Students.entities.Student;
import py.com.ci.academy.utils.ConnectionManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccountManager {

    public String getStatement() {
        String statement = "SELECT id_account, date_account, status,remark,";
        return statement;
    }

    public void addAccount(Account account) {

        String sql = "INSERT INTO public.account(id_account,date_account,status,remark) VALUES (?,?,?,?)";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setInt(1, account.getIdAccount());
            s1.setInt(2, account.getDateAccount());
            s1.setString(3, account.getStatus());
            s1.setString(4, account.getRemark());
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
        String sql = " DELETE FROM public.account WHERE account_id = ? ";
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
        String sql = "UPDATE public.account SET status=?, remark=?,date=? WHERE id_account=?";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setString(1, account.getStatus());
            s1.setString(2, account.getRemark());
            s1.setInt(3, account.getIdAccount());
            s1.setInt(4, account.getDateAccount());
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
