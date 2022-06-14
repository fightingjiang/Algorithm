package leetcode.dp.mid;


public class 最长公共子序列1143 {
    //最长公共子序列-II   返回String类型
    public String LCS (String s1, String s2) {
        int l1 = s1.length(),l2 = s2.length();
        String[][] dp = new String[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = "";
        }
        for (int i = 0; i <= l2; i++) {
            dp[0][i] = "";
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+s1.charAt(i-1);
                }else {
                    dp[i][j] = dp[i-1][j].length()>dp[i][j-1].length()?dp[i-1][j]:dp[i][j-1];
                }
            }
        }
        return dp[l1][l2]==""?"-1":dp[l1][l2];
    }

    //动态规划
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = 0;
        }
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

    //递归    递归会超时
    public int longestCommonSubsequence1(String text1, String text2) {
        return longestCommonSubsequence1(text1,text2,text1.length(),text2.length());
    }

    private int longestCommonSubsequence1(String text1, String text2, int length1, int length2) {
        if(length1==0||length2==0) return 0;
        if(text1.charAt(length1-1)==text2.charAt(length2-1)){
            return longestCommonSubsequence1(text1, text2,length1-1,length2-1)+1;
        }else {
            return Math.max(longestCommonSubsequence1(text1, text2,length1-1,length2),longestCommonSubsequence1(text1, text2,length1,length2-1));
        }
    }


}
