package leetcode.dp.mid;

public class 乘积最大子数组152 {
    //二维超时
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        int res = nums[0];
        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
            res = Math.max(nums[i],res);
        }
        //dp[i][j]表示从i-j的乘积
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                dp[i][j] = dp[i][j-1]*nums[j];
                res = Math.max(res,dp[i][j]);
            }
        }
        return res;
    }

    public int maxProduct1(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int res = nums[0];
        //dp[i][j]表示从i-j的乘积
        for (int i = 0; i < len; i++) {
            dp[i] = nums[i];
            res = Math.max(res,dp[i]);
            for (int j = i+1; j < len ; j++) {
                dp[j] = dp[j-1]*nums[j];
                res = Math.max(res,dp[j]);
            }
        }
        return res;
    }

    //用两个值maxLan和minLan来保存最大最小值
    public int maxProduct2(int[] nums) {
        int maxLan = nums[0],minLan = nums[0],ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max = maxLan,min = minLan;
            maxLan = Math.max(max*nums[i],Math.max(nums[i],min*nums[i]));
            minLan = Math.min(max*nums[i],Math.min(nums[i],minLan*nums[i]));
            ans = Math.max(ans,maxLan);
        }
        return ans;
    }
}
    