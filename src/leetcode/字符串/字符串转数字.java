package leetcode.字符串;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 20:00 2021/7/11
 */
public class 字符串转数字 {
    public int myAtoi(String s) {
        int res = 0;
        String str = s.trim().replaceAll(" ", "");
        int sign = 1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(i==0&&str.startsWith("+")){
                sign = 1;
            }else if(i==0&&str.startsWith("-")){
                sign = -1;
            }else if(Character.isDigit(c)){
                int num = c-'0';
                if(res>Integer.MAX_VALUE/10||(res == Integer.MAX_VALUE/10&&num>Integer.MAX_VALUE%10)){
                    return Integer.MAX_VALUE;
                }
                if(res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10&&-num<Integer.MIN_VALUE%10)){
                    return Integer.MIN_VALUE;
                }
                res = res*10+num*sign;
            }else {
                break;
            }
        }
        return res;
    }
}
