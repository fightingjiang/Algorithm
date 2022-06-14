package Tree;


import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        Calendar instance = Calendar.getInstance();
        System.out.println(instance.getTimeInMillis());
        Date time = instance.getTime();
        System.out.println(time);
        LocalDate now = LocalDate.now();
        System.out.println(now);

    }
}
