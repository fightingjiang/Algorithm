import java.util.Arrays;

public class 字符串乘法 {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int len = len1+len2;
        int[] res = new int[len];
        for (int i = len1-1; i >=0; i--) {
            for (int j = len2-1; j >=0; j--) {
                int mul = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int p1 = i+j,p2 = p1+1;
                int sum = res[p2]+mul;
                res[p1] += sum/10;
                res[p2] = sum%10;
            }
        }
//        System.out.println(Arrays.toString(res));
        //前缀可能存在0
        int i = 0;
        while (i<res.length&&res[i]==0){
            i++;
        }
        StringBuilder builder = new StringBuilder();
        for(;i<res.length;i++){
            builder.append(res[i]);
        }
        return builder.length()==0?"0":builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new 字符串乘法().multiply("123", "45"));
    }
}
