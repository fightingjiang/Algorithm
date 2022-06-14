package 动态规划;

public class 最长回文子串 {
    public int getLongestPalindrome(String A, int n) {
        if(n<2){
            return n;
        }
        boolean[][] dp = new boolean[n][n];
        char[] charArray = A.toCharArray();
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if(charArray[i]!=charArray[j]){
                    dp[i][j] = false;
                }else {
                    if(j-i<3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j]&&j-i+1>maxLen){
                    maxLen = j-i+1;
                }
            }
        }
        return maxLen;
    }
}
