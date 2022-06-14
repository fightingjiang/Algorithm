package leetcode.DFS.hard;

import java.util.Arrays;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 19:44 2021/6/27
 */
public class 矩阵中的最长递增路径 {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int ans = 0;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans = Math.max(ans,dfs(matrix,memo,i,j,Integer.MIN_VALUE));
            }
        }
        return ans;
    }

    private int dfs(int[][] nums,int[][] memo, int i, int j, int pre) {
        if(i<0||j<0||i>=nums.length||j>=nums[0].length||nums[i][j]<=pre){
            return 0;
        }
        int[] rows = new int[]{-1,1,0,0};
        int[] columns = new int[]{0,0,-1,1};
        if(memo[i][j]==0){
            for (int k = 0; k < 4; k++) {
                memo[i][j] = Math.max(memo[i][j],dfs(nums,memo,i+rows[k],j+columns[k],nums[i][j]));
            }
        }
        return memo[i][j]+1;
    }
}
