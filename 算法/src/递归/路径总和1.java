package 递归;

public class 路径总和1 {
    public boolean hasPathSum(路径总和3.TreeNode root, int sum) {
        if(root==null) return false;
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
}
