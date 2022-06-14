package 动态规划;

//最长公共子串
public class LCS {
    public static void main(String[] args) {
        String str1 = "1AB2345CD";
        String str2 = "12345EF";
        System.out.println(new LCS().LCS(str1, str2));
    }

    //最长公共子串   子串
    public String LCS (String str1, String str2) {
        if(str1 == null||str1.length()==0||str2.length()==0||str2==null) return "-1";
        int len1 = str1.length();
        int len2 = str2.length();
        int indexMax = 0;
        int[][] dp = new int[len1 + 1][len2 + 1];
        int max = -1;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                if(max<dp[i][j]){
                    max = dp[i][j];
                    indexMax = i;
                }
            }
        }
        System.out.println(indexMax);
        return str1.substring(indexMax-max,indexMax);
    }


    public int findLength(int[] A, int[] B) {
        int len1 = A.length;
        int len2 = B.length;
        int[][] dp = new int[len1+1][len2+1];
        int max = 0;
        for (int i = 1; i <= len1 ; i++) {
            for (int j = 1; j <=len2 ; j++) {
                if(A[i-1]==B[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}
