package leetcode.DFS.mid;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 21:24 2021/6/26
 */
public class 岛屿面积 {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1){
                    max=  Math.max(max,dfs(grid,i,j));
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j) {
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==0){
            return 0;
        }
        grid[i][j] = 0;
        int tmpMax = 0;
        tmpMax++;
        tmpMax+=dfs(grid,i-1,j);
        tmpMax+=dfs(grid,i+1,j);
        tmpMax+=dfs(grid,i,j-1);
        tmpMax+=dfs(grid,i,j+1);
        return tmpMax;
    }
}
