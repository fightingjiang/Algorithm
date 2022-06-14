package 动态规划;

public class 剪绳子 {
    public static void main(String[] args) {
        System.out.println(cuttingRope(10));
    }
    static public int cuttingRope(int n) {
        //m 表示段数   n 表示绳子长度   dp[m][n] 表示最大乘积
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i < n+1; i++) {
            for (int j = 2; j < i; j++) {
            }
        }
        return 0;
    }
}
