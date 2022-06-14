package leetcode.树.easy;

import leetcode.树.TreeNode;

public class 对称二叉树101 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root,root);
    }

    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;
        return p.val==q.val&&isSymmetric(p.right,q.left)&&isSymmetric(p.left,q.right);
    }
}
