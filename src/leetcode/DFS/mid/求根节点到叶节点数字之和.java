package leetcode.DFS.mid;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 15:00 2021/6/27
 */
public class 求根节点到叶节点数字之和 {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        return sum;
    }

    private void dfs(TreeNode root, int num) {
        if(root==null) return;
        num = num*10+root.val;
        if(root.left==null&&root.right==null){
            sum+=num;
        }
        dfs(root.left,num);
        dfs(root.right,num);
        num/=10;
    }
}
