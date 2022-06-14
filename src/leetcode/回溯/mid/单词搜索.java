package leetcode.回溯.mid;


/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 14:48 2021/6/26
 */
public class 单词搜索 {
    //回溯+递归
    public boolean exist1(char[][] board, String word) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)) return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int i, int j, int k) {
        if (k == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length) {
            return false;
        }

        if (word.charAt(k) != board[i][j]) {
            return false;
        }
        char t = board[i][j];
        board[i][j] = '0';
        boolean res = dfs(board, word, i + 1, j, k + 1) ||
                dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) ||
                dfs(board, word, i, j - 1, k + 1);
        board[i][j] = t;
        return res;
    }

    boolean ans = false;
    public boolean exist(char[][] board, String word) {
        StringBuilder track = new StringBuilder();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                ans = trackback(board, visited, word, i, j, 0);
                if(ans){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean trackback(char[][] board, boolean[][] visited,String word, int row, int column, int start) {
        if(board[row][column]!=word.charAt(start)){
            return false;
        }else if(start==word.length()-1){
            return true;
        }
        visited[row][column] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        //对每个方向回溯  做选择
        for (int[] dir : directions) {
            int newi = row + dir[0], newj = column + dir[1];
            if(newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length){
                if(!visited[newi][newj]){
                    boolean flag = trackback(board, visited, word, newi, newj, start + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        //回溯  撤销选择  回到
        visited[row][column] = false;
        return result;
    }



}
