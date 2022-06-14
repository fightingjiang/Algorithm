package 动态规划;

import java.util.Arrays;

public class 零钱兑换 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }

    //空间化解  O(n)
    ////F(11)=min(F(11-1),F(11-2),F(11-5))+1=3F(11)=min(F(11−1),F(11−2),F(11−5))+1=3
    static public int coinChange01(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i = 1; i < amount+1 ; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(coins[j]<=i){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }


    //完全背包的解法   O（n*n）
    static public int coinChange(int[] coins, int amount) {
        //dp[][]   n种硬币选择amout块钱是最少的硬币个数
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i],amount+1);
            dp[i][0] = 0;
        }
        //i个硬币情况下的选择
        for (int i = 1; i <= n  ; i++) {
            //j块钱下的选择
            for (int j = 1; j <= amount; j++) {
                //当前钱大于第i个硬币的价值
                if(coins[i-1]<=j){
                    //做选择
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount]==amount+1?-1:dp[n][amount];
    }
}
