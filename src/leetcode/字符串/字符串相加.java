package leetcode.字符串;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 16:43 2021/7/11
 */
public class 字符串相加 {
    public String addStrings(String num1, String num2) {
        int n = num1.length()-1,m = num2.length()-1;
        StringBuilder sb = new StringBuilder();
        int up = 0;
        while (n>=0||m>=0||up==1){
            int t1 = n>=0?num1.charAt(n--)-'0':0;
            int t2 = m>=0?num2.charAt(m--)-'0':0;
            int tmp = t1+t2+up;
            sb.append(tmp%10);
            up = tmp/10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new 字符串相加().addStrings("11", "123"));
    }
}
