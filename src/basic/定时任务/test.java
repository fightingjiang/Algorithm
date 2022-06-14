package basic.定时任务;

import javafx.scene.input.DataFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 14:44 2021/6/22
 */
public class test {
    public static void main(String[] args) {
        DataFormat dataFormat = new DataFormat();
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        //将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        c.set(Calendar.MINUTE, 0);
        //将秒至0
        c.set(Calendar.SECOND,0);
        //将毫秒至0
        c.set(Calendar.MILLISECOND, 0);
        System.out.println(c.getTime());
        SimpleDateFormat format = new SimpleDateFormat();
        // 获取本月第一天的时间戳
        System.out.println(format.format(c.getTimeInMillis()));

        //当前时间
        Date date = Calendar.getInstance().getTime();
        System.out.println(date);
        for (int i = 0; i < 20; i++) {
            date = getFirstDayOfLastMonth(date);
            System.out.println(date);
        }
        //上月第一天
        System.out.println(getFirstDayOfLastMonth(date));
        //获取某月的第一天
        System.out.println(getFirstDayOfMonth(date));
        //某月最后一天
        System.out.println(getLastDayOfMonth(date));
        //下月第一天

    }


    /**
     * 获取某月的最后一天
     * 格式为：2014-11-30 23:59:59 000
     * */
    public static Date getLastDayOfMonth(Date requestDate){
        Calendar calendar = Calendar.getInstance();
        if(requestDate != null){
            calendar.setTime(requestDate);
        }

        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
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
}
