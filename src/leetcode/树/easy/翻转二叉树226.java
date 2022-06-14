package leetcode.树.easy;

import leetcode.树.TreeNode;

public class 翻转二叉树226 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
}
