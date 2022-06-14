package leetcode.dp.mid;


public class 最长回文字串300 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len<2) return s;
        //dp[i][j] 表示s从i到j是否是字符串
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            //长度为1的串自然是回文串
            dp[i][i] = true;
        }
        int beginIndex = 0;
        int maxLen = 1;
        //长度从2开始
        for (int L = 2; L <= len; L++) {
            //左边坐标从0开始
            for (int i = 0; i < len; i++) {
                //右边坐标
                int j = L+i-1;
                if(j>=len){
                    break;
                }
                if(s.charAt(i)!=s.charAt(j)){
                    dp[i][j] = false;
                }else {
                    if(j-i<3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(j-i+1>maxLen&&dp[i][j]==true){
                    maxLen = j-i+1;
                    beginIndex = i;
                }
            }
        }
        return s.substring(beginIndex,beginIndex+maxLen);
    }

    public String longestPalindrome1(String s) {
        int len = s.length();
        if(len<2) return s;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int beginIndex = 0;
        int maxLen = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if(s.charAt(i)!=s.charAt(j)){
                    dp[i][j] = false;
                }else {
                    if(j-i<3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j] == true&&j-i+1>maxLen){
                    maxLen = j-i+1;
                    beginIndex = i;
                }
            }
        }
        return s.substring(beginIndex,beginIndex+maxLen);
    }
}
