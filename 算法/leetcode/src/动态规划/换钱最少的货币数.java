package 动态规划;

import java.util.Arrays;

public class 换钱最少的货币数 {
    public int minMoney (int[] arr, int aim) {
        int[] dp = new int[aim + 1];
        Arrays.fill(dp,aim+1);
        dp[0] = 0;
        for (int i = 1; i < aim+1; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(i-arr[j]>=0){
                    dp[i] = Math.min(dp[i],dp[i-arr[j]]+1);
                }
            }
        }
        return dp[aim]==aim+1?-1:dp[aim];
    }

    public int minMoney01 (int[] arr, int aim) {
        int[] dp = new int[aim+1];
        Arrays.fill(dp,aim+1);
        dp[0] = 0;
        for (int i = 1; i < aim+1; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(i-arr[j]>=0){
                    dp[i] = Math.min(dp[i],dp[i-arr[j]]+1);
                }
            }
        }
        return dp[aim]==aim+1?-1:dp[aim];
    }

    public static void main(String[] args) {
        System.out.println(new 换钱最少的货币数().minMoney01(new int[]{5, 3, 2}, 20));
    }
}
