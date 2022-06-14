package leetcode.dp.mid;

import java.util.Arrays;

public class 零钱兑换322 {
    public static void main(String[] args) {
        System.out.println(new 零钱兑换322().minMoney(new int[]{5, 2, 3}, 20));
    }

    public int minMoney (int[] arr, int aim) {
        int n = arr.length;
        int[][] dp = new int[n+1][aim+1];
        for(int i = 0 ; i<=n;i++){
            Arrays.fill(dp[i],aim+1);
            dp[i][0] = 0;
        }
        for(int i = 1 ; i<=n;i++){
            for(int j = 1;j<=aim;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-arr[i-1]]+1);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][aim]==aim+1?-1:dp[n][aim];
    }

    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int m = coins.length;
        int max = amount+1;
        int[][] dp = new int[m+1][amount+1];
        for (int i = 0; i <= amount; i++) {
            dp[0][i] = max;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= amount ; j++) {
                //如果当前剩余的钱不够选当前硬币
                if(j-coins[i-1]<0){
                    dp[i][j] =  dp[i-1][j];
                }else {
                    dp[i][j] = Math.min(dp[i][j-coins[i-1]]+1,dp[i-1][j]);
                }
            }
        }
        return dp[m][amount]>max?-1:dp[m][amount];
    }

    //一维
    public int coinChange1(int[] coins, int amount) {
        if(amount==0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount ; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(i>=coins[j]){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}
