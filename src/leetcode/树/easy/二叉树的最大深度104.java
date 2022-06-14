package leetcode.树.easy;

import leetcode.树.TreeNode;

public class 二叉树的最大深度104 {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
