package 动态规划;

public class massage17_16 {
    public int massage(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int len = nums.length;
        if(len==1)  return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[dp.length-1];
    }
}
