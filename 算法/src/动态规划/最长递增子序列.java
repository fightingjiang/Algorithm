package 动态规划;

public class 最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        int max = dp[0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }
}
