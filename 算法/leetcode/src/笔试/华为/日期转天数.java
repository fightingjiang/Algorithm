package 笔试.华为;

import java.util.Scanner;

public class 日期转天数 {
    public static void main(String[] args) {
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            String[] split = s.split(" ");
            int year = Integer.valueOf(split[0]);
            int moth = Integer.valueOf(split[1]);
            int day = Integer.valueOf(split[2]);
            int res = 0;
            if(isRuinian(year)&&moth>2){
                res++;
            }
            for (int i = 0; i < moth-1; i++) {
                res+=days[i];
            }
            res+=day;
            System.out.println(res);
        }
    }

    private static boolean isRuinian(int year) {
        //能被4整除但不能被100整除   能被400整除
        if(year%4==0&&year%100!=0||year%400==0){
            return true;
        }else {
            return false;
        }
    }
}
