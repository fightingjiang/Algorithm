package leetcode.dp;

public class easy {
    //最大子序和
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tmp = Math.max(nums[i]+tmp,nums[i]);
            max = Math.max(tmp,max);
        }
        return max;
    }

    //买股票
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int maxProfit = 0;
        //当前利润
        int profile = 0;
        int cur = prices[0];
        for (int i = 1; i < prices.length; i++) {
            profile = Math.max(0,profile+prices[i]-cur);
            cur = prices[i];
            maxProfit = Math.max(maxProfit,profile);
        }
        return maxProfit;
    }

    //判断子序列
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int i = 0,j = 0;
        while (i<n&&j<m){
            if(s.charAt(i)==t.charAt(j)){
                i++;
            }
            j++;
        }
        return i==n;
    }
}
