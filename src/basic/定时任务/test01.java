package basic.定时任务;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 10:17 2021/6/29
 */
public class test01 {
    /**
     *  获取某月的上月第一天
     *  格式为：2014-11-01 00:00:00 000
     * */
    public static Date getFirstDayOfLastMonth(Date requestDate){
        Calendar calendar = Calendar.getInstance();
        if (requestDate != null){
            calendar.setTime(requestDate);
        }

        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)-1);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    /**
     *  获取某月的第一天
     *  格式为：2014-11-01 00:00:00 000
     * */
    public static Date getFirstDayOfMonth(Date requestDate){
        Calendar calendar = Calendar.getInstance();
        if (requestDate != null){
            calendar.setTime(requestDate);
        }

        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    /**
     *  获取某月的上月的最后一天
     *  格式为：2014-10-31 23:59:59 000
     * */
    public static Date getLastDayOfLastMonth(Date requestDate){
        Calendar calendar = Calendar.getInstance();
        if(requestDate != null){
            calendar.setTime(requestDate);
        }

        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)-1);
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    public static void main(String[] args) {
        //上月第一天时间
        Date lastMonthFirstDateFrom = getFirstDayOfLastMonth(Calendar.getInstance().getTime());
        //当月第一天时间
        Date currentMonthFirstDateFrom = getFirstDayOfMonth(Calendar.getInstance().getTime());
        System.out.println("作废时间为:上月一号{}--当前月一号{}"+lastMonthFirstDateFrom+"          "+currentMonthFirstDateFrom);
        //上月最后一天
        System.out.println(getLastDayOfLastMonth(Calendar.getInstance().getTime()));
    }


}
