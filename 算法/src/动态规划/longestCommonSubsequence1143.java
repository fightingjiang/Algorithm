package 动态规划;

//最长公共子序列
public class longestCommonSubsequence1143 {

    //返回长度
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2+1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }

    //返回string子序列字符串
    public String LCS (String s1, String s2) {
        int len1 = s1.length(),len2 = s2.length();
        String dp[][] = new String[len1+1][len2+1];
        for (int i = 0; i <= len1 ; i++) {
            for (int j = 0; j <= len2; j++) {
                if(i==0||j==0) dp[i][j] = "";
                else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+s1.charAt(i-1);
                }else {
                    dp[i][j] = dp[i][j-1].length()>dp[i-1][j].length()?dp[i-1][j]:dp[i][j-1];
                }
            }
        }
        if(dp[len1][len2]=="") return "-1";
        return dp[len1][len2];
    }
}
