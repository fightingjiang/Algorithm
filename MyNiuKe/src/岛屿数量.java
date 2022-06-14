//DFS
public class 岛屿数量 {
    public int solve (char[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    DFS(grid, i, j);
                }
            }
        }
        return result;
    }

    private void DFS(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if(r<0||c<0||r>=nr||c>=nc||grid[r][c]=='0'){
            return;
        }
        grid[r][c] = '0';
        DFS(grid, r - 1, c);
        DFS(grid, r + 1, c);
        DFS(grid, r, c - 1);
        DFS(grid, r, c + 1);
    }
}

