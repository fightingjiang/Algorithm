package leetcode.dp.mid;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 9:57 2021/7/9
 */
public class 最大正方形 {
    public int solve (char[][] matrix) {
        int n = matrix.length,m = matrix[0].length;
        int ans = 0;
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    ans = Math.max(ans,dp[i][j]);
                }
            }
        }
        return ans*ans;
    }
}
