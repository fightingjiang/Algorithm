package leetcode.dp.mid;


public class 最大正方形221 {
    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    res = Math.max(res,dp[i][j]);
                }else {
                    dp[i][j] = (int) matrix[i-1][j-1]-'0';
                }
            }
        }
        return res*res;
    }


    public static void main(String[] args) {
        char[][] a = new char[][]{{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
        System.out.println(maximalSquare(a));
    }
}
