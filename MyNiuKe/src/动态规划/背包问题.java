package 动态规划;

public class 背包问题 {
    public static void main(String[] args) {
        int[][] vw = new int[][]{{1, 3}, {10, 4}};
        System.out.println(new 背包问题().knapsack(10, 2, vw));
    }
    //01背包问题
    public int knapsack (int V, int n, int[][] vw) {
        //表示前n个物品体积为V的最大的价值
        int[][] dp = new int[n+1][V+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= V; j++) {
                if(j<vw[i-1][0]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-vw[i-1][0]]+vw[i-1][1]);
                }
            }
        }
        return dp[n][V];
    }
}
