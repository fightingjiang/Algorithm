package leetcode.树.hard;

import leetcode.树.TreeNode;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 18:03 2021/7/12
 */
public class 二叉树中的最大路径和 {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSum2(root);
        return ans;
    }

    private int maxPathSum2(TreeNode root) {
        if(root==null) return 0;
        int left = maxPathSum2(root.left);
        int right =maxPathSum2(root.right);
        int lr = Math.max(left,right);
        ans = Math.max(ans,Math.max(root.val,Math.max(root.val+lr,root.val+left+right)));
        return Math.max(0,Math.max(root.val,root.val+lr));
    }
}
