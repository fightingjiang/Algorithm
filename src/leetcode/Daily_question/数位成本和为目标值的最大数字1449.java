package leetcode.Daily_question;

import java.util.Arrays;

public class 数位成本和为目标值的最大数字1449 {
    public String largestNumber(int[] cost, int target) {
        int ansMax = 0;
        int[][] dp = new int[cost.length + 1][target + 1];
        //target是0则dp[i][j]为0
        for (int i = 0; i < cost.length+1; i++) {
            Arrays.fill(dp[i],-1);
            dp[i][0] = 0;
        }
        for (int i = 1; i < cost.length+1; i++) {
            for (int j = 1; j < target+1; j++) {
                if(j-cost[i-1]>=0&&dp[i][j-cost[i-1]]!=-1){
                    dp[i][j] = Math.max(fun(i,dp[i][j-cost[i-1]]),dp[i-1][j]);
                    if(j==target){
                        ansMax = Math.max(ansMax,dp[i][j]);
                    }
                }
            }
        }
        return String.valueOf(ansMax);
    }

    private int fun(int n, int num) {
        if(num==-1) return -1;
        int m = num;
        int len = 0;
        while (m!=0){
            m = m/10;
            len++;
        }
        return (int) Math.pow(10,len)*n+num;
    }

    public static void main(String[] args) {
        int[] cost = new int[]{4,3,2,5,6,7,2,5,5};
        System.out.println(new 数位成本和为目标值的最大数字1449().largestNumber(cost, 9));
    }
}
