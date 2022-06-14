package 动态规划;

public class 最小编辑代价带权重 {
    public static void main(String[] args) {
        System.out.println(new 最小编辑代价带权重().minEditCost("abc", "adc", 5, 3, 2));

    }
    public int minEditCost (String str1, String str2, int ic, int dc, int rc) {
        //ic，dc和rc，分别代表插入、删除和替换
        int len1 = str1.length(),len2 = str2.length();
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 0; i <= len1; i++) {
            //str1删除
            dp[i][0] = i*dc;
        }
        for (int i = 0; i <= len2; i++) {
            //str1增加
            dp[0][i] = i*ic;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2 ; j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    //题目是将str1变成str2
                    //dp[i-1][j] str1删除一个元素 dc代价
                    // dp[i+1][j]  str1插入一个元素 ic代价  str1插入一个元素相当于str2删除一个元素dp[i][j-1]
                    // dp[i-1][j-1]  第i个元素替换  代价 rc
                    dp[i][j] = Math.min(Math.min(dp[i-1][j]+dc,dp[i][j-1]+ic),dp[i-1][j-1]+rc);
                }
            }
        }
        return dp[len1][len2];
    }
}
