package leetcode.Daily_question;

import java.util.Arrays;

public class 完全平方数279 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,n);
        for (int i = 1; i <= n; i++) {
            int k = (int) Math.sqrt(i);
            if(k*k==i){
                dp[i] = 1;
                continue;
            }else {
                for (int j = k; j >= 1; j--) {
                     dp[i] = Math.min(dp[i],1+dp[i-j*j]);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new 完全平方数279().numSquares(33));
    }
}
