package 动态规划;

public class 最长公共子串 {
    public String LCS (String str1, String str2) {
        if(str1==null||str1.length()==0||str2==null||str2.length()==0) return "-1";
        int len1 = str1.length(),len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        int max = 0;
        int maxIndex = 0;
        for (int i = 1; i <= len1 ; i++) {
            for (int j = 1; j <= len2 ; j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                if(max<dp[i][j]){
                    max = dp[i][j];
                    maxIndex = i;
                }
            }
        }
        return str1.substring(maxIndex-max,maxIndex);
    }
}
