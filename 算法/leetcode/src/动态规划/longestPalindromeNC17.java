package 动态规划;


//最长回文子串   长度
public class longestPalindromeNC17 {

    //返回长度
    public int getLongestPalindrome(String A, int n) {
        if(n<2){
            return n;
        }
        //dp[i][j] 表示子串i-j是否是回文串
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

    //返回字符串
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len<2) return s;
        char[] charArray = s.toCharArray();
        //dp[i][j] 表示串i到j是否是回文串
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1;
        int index = 0;
        for (int j = 1; j < len ; j++) {
            for (int i = 0; i < j; i++) {
                //charArray[i]!=charArray[j]   串i到j肯定不是回文串  所以dp[i][j] = false;
                if(charArray[i]!=charArray[j]){
                    dp[i][j] = false;
                }else{
                    if(j-i<3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j]&&j-i+1>maxLen){
                    maxLen = j-i+1;
                    index = i;
                }
            }
        }
        return s.substring(index,index+maxLen);
    }
}
