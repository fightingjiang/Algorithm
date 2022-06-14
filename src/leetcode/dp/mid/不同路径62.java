package leetcode.dp.mid;

import java.util.Arrays;

public class 不同路径62 {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j-1]+dp[j];
            }
        }
        return dp[n-1];
    }
}
