package leetcode.dp.mid;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 10:04 2021/7/9
 */
public class 把数字翻译成字符串 {
    public int solve (String nums) {
        if(nums.length() == 0 || nums.charAt(0) == '0')  return 0;
        int[] dp = new int[nums.length()];
        dp[0] = 1;
        for (int i = 1; i < nums.length(); i++) {
            if(nums.charAt(i)!='0'){
                dp[i] = dp[i-1];
            }
            int num = (nums.charAt(i-1)-'0')*10+nums.charAt(i)-'0';
            if(num>=10&&num<=26){
                if(i==1){
                    dp[i]+=1;
                }else {
                    dp[i] +=dp[i-2];
                }
            }
        }
        return dp[nums.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(new 把数字翻译成字符串().solve("11011"));
    }
}
