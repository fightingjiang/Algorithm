package 动态规划;


//最长递增子序列
public class lengthOfLIS300 {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new lengthOfLIS300().lengthOfLIS(nums));
    }


    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
        }
        int max = dp[0];
        for (int i = 0; i < dp.length; i++) {
            if(dp[i]>max) max = dp[i];
        }
        return max;
    }
}
