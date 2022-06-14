package leetcode.DFS.mid;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 16:28 2021/7/21
 */
public class 机器人运动范围 {
    int ans = 0;
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        dfs(0,0,m,n,visited,k);
        return ans;
    }

    private void dfs(int x, int y, int m, int n, boolean[][] visited, int k) {
        if(x<0||x>=m||y<0||y>=n||visited[x][y]||!isValid(x,y,k)){
            return;
        }
        ans++;
        visited[x][y] = true;
        dfs(x-1,y,m,n,visited,k);
        dfs(x+1,y,m,n,visited,k);
        dfs(x,y-1,m,n,visited,k);
        dfs(x,y+1,m,n,visited,k);
    }

    public boolean isValid(int num1,int nums2,int k){
        int ans = 0;
        while (num1!=0){
            ans+=num1%10;
            num1/=10;
        }
        while (nums2!=0){
            ans+=nums2%10;
            nums2/=10;
        }
        return ans<=k;
    }

    public static void main(String[] args) {
        System.out.println(new 机器人运动范围().movingCount(16, 8, 1));
    }
}
