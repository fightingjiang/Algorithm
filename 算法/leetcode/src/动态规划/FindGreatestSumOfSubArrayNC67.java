package 动态规划;

//连续子数组最大和  [1,-2,3,10,-4,7,2,-5]
public class FindGreatestSumOfSubArrayNC67 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int len = array.length;
        int[] dp = new int[len];
        dp[0] = array[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i-1]+array[i],array[i]);
        }
        int res = dp[0];
        for (int i = 0; i < len; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
