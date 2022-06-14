package 字符串;

import java.util.Arrays;

public class 大数乘法 {
    public static void main(String[] args) {
        System.out.println(solve("432","66"));
    }
    public static String solve (String s, String t) {
        if(s.equals("0")||t.equals(0)) return "0";
        int ls = s.length(),lt = t.length();
        int[] num = new int[ls + lt];
        for (int i = ls-1; i >= 0; i--) {
            int x = s.charAt(i)-'0';
            for (int j = lt-1; j >= 0 ; j--) {
                int y = t.charAt(j)-'0';
                num[i + j + 1] += x * y;
            }
        }
        for (int i = ls + lt - 1; i > 0; i--) {
            num[i - 1] += num[i] / 10;
            num[i] %= 10;
        }
        int index = num[0]==0?1:0;
        StringBuilder res = new StringBuilder();
        for (int i = index; i < num.length; i++) {
            res.append(num[i]);
        }
        return res.toString();
    }
}
