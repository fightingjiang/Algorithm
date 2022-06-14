package leetcode.dp.hard;

public class 最长有效括号32 {
    static public int longestValidParentheses(String s) {
        //动态规划
        //对于子串、子数组就是要连续的
        // dp[i]就是表示说以i结尾的最值，最终的值是最值中的最值ans=math.max(ans,dp[i])
        // dp[i]的值不是累加的，不符合则不处理，为0或者初始值只有符合的才去加
        //对于子序列就是非连续到是有序
        // dpP[i][j]就是i到j的最值  那最终的值便是dp[len1][len2]
        // dp[i][j]的值是累加的，不符合则dp[i][j] = dp[i+1][j-1]
        int len = s.length();
        int maxans = 0;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i] = (i>=2?dp[i-2]:0)+2;
                }else if(i-dp[i-1]>0&&s.charAt(i-dp[i-1]-1)=='('){
                    dp[i] = dp[i-1]+((i-dp[i-1])>=2?dp[i-dp[i-1]-2]:0)+2;
                }
                maxans = Math.max(maxans,dp[i]);
            }
        }
        return maxans;

    }

    public static void main(String[] args) {
        String s = "()(())";
        System.out.println(longestValidParentheses(s));
    }
}
