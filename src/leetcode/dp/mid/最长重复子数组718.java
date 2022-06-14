package leetcode.dp.mid;

public class 最长重复子数组718 {
    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1==0||len2==0) return 0;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1+1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < len2+1; i++) {
            dp[0][i] = 0;
        }
        int max = 0;
        for (int i = 1; i < len1+1 ; i++) {
            for (int j = 1; j < len2+1; j++) {
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}
