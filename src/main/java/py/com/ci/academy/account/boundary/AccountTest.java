package py.com.ci.academy.account.boundary;

import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountTest {

    public static void main(String[] args) {
         LocalDate date;
        for (int i = 0; i < 6; i++) {
            date=LocalDate.now().plusMonths(i).with(lastDayOfMonth());
            System.out.println(date);
        }

    }


    }
//    public LocalDate convertToLocalDate(Date dateToConvert) {
//        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//    }
//
//    public static Date convertToDate(LocalDate dateToConvert) {
//        return java.sql.Date.valueOf(dateToConvert);
//    }
//
//    public static List<LocalDate> setDate() {
//        List<LocalDate> date = new ArrayList<>();
//        for (int i = 0; i < 6; i++) {
//            date.add(LocalDate.now().plusMonths(i).with(lastDayOfMonth()));
//        }
//        return date;
//    }


//}
