package leetcode.dp.hard;

public class 买卖股票 {
    //dp[i] 表示第i天卖出时的最大利润  不管哪天买入
    public int maxProfit1(int[] prices) {
        int[] dp = new int[prices.length];
        int maxans = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(0,prices[i]-prices[i-1]+dp[i-1]);
            maxans = Math.max(maxans,dp[i]);
        }
        return maxans;
    }
    public int maxProfit1_1(int[] prices) {
        int curProfit = 0,maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(curProfit+prices[i]-prices[i-1]>0){
                curProfit = curProfit+prices[i]-prices[i-1];
                maxProfit = Math.max(maxProfit,curProfit);
            }else {
                curProfit = 0;
            }
        }
        return maxProfit;
    }
    public int maxProfit1_2(int[] prices) {
        int[] dp = new int[prices.length];
        int minVal = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i-1],prices[i]-minVal);
            minVal = Math.min(minVal,prices[i]);
        }
        return dp[prices.length-1];
    }

    //可多次操作  总利润最大
    public int maxProfit2(int[] prices) {
        int min = prices[0],ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]<prices[i-1]){
                ans+=prices[i-1]-min>0?prices[i-1]-min:0;
                min = prices[i];
            }
        }
        ans+=prices[prices.length-1]-min>0?prices[prices.length-1]-min:0;
        return ans;
    }

    //最多可操作2次(1,2) 限定次数  总利润最大
    public static int maxProfit3(int[] prices) {
        //dp1[i]表示前i天买卖的最大利润
        //dp2[i]表示第i天i后的最大利润
        int len = prices.length;
        int[] dp1 = new int[len],dp2 = new int[len];
        int minVal = prices[0],maxVal = prices[len-1];
        for (int i = 1; i < len; i++) {
            dp1[i] = Math.max(dp1[i-1],prices[i]-minVal);
            minVal = Math.min(minVal,prices[i]);
        }
        for (int i = len-2; i >= 0; i--) {
            dp2[i] = Math.max(dp2[i+1],maxVal-prices[i]);
            maxVal = Math.max(maxVal,prices[i]);
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans = Math.max(ans,dp1[i]+dp2[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit3(nums));
    }

}
