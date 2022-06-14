package 笔试.华为;


import java.util.Scanner;

public class 整数与ip地址的转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            System.out.println(iptoten(s1));
            System.out.println(tentoip(s2));
        }

    }

    private static Long iptoten(String s1) {
        String[] split = s1.split("\\.");
        StringBuilder builder = new StringBuilder();
        for (String str:split) {
            String string = Integer.toString(Integer.parseInt(str), 2);
            while (string.length()<8){
                string = "0"+string;
            }
            builder.append(string);
        }
        return Long.parseLong(builder.toString(),2);
    }

    private static String tentoip(String s2) {
        String string = Long.toString(Long.parseLong(s2), 2);
        while (string.length()<32){
            string = "0"+string;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < string.length(); i=i+8) {
            builder.append(Integer.parseInt(string.substring(i,i+8),2)).append(".");
        }
        return builder.substring(0,builder.length()-1);
    }
}
