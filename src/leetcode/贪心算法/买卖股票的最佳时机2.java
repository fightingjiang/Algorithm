package leetcode.贪心算法;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 17:09 2021/7/4
 */
public class 买卖股票的最佳时机2 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans+=Math.max(0,prices[i]-prices[i-1]);
        }
        return ans;
    }
}
