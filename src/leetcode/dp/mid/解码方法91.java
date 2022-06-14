package leetcode.dp.mid;


public class 解码方法91 {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0') return 0;
        int len = s.length();
        char[] nums = s.toCharArray();
        //dp[i]表示前i个的编码方式
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if(nums[i]=='0'){
                dp[i] = dp[i-1];
            }else if((nums[i-1]-'0'==2&&nums[i]-'0'>6)||(nums[i-1]-'0'>2)){
                dp[i] = dp[i-1];
            }else dp[i] = dp[i-1]+1;
        }
        return dp[len-1];
    }
}
