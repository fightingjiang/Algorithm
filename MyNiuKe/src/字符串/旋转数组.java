package 字符串;

public class 旋转数组 {
    public static void main(String[] args) {
        System.out.println(solve("youzan","zyouan"));
    }
    public static boolean solve (String A, String B) {
        if(A.length()!=B.length()) return false;
        int length = A.length();
        for (int i = 0; i < length; i++) {
            //右移位数
            int start =i;
            for (int j = 0; j < length; j++) {
                if(A.charAt(j)!=B.charAt((i+j)%length)){
                    break;
                }
                if(j==length-1){
                    return true;
                }
            }
        }
        return false;
    }
}
