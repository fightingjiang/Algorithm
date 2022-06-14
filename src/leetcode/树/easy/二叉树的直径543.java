package leetcode.树.easy;

import leetcode.树.TreeNode;

public class 二叉树的直径543 {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        //选上当前节点
        int max1 = 1+maxDepth(root.left)+maxDepth(root.right)-1;
        //不选上
        int max2 = Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right));
        return Math.max(max1,max2);
    }

    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
