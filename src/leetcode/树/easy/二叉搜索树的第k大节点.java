package leetcode.树.easy;

import leetcode.树.TreeNode;

public class 二叉搜索树的第k大节点 {
    public int kthLargest(TreeNode root, int k) {
        int r = count(root.right);
        int l = count(root.left);
        if(k-1==r){
            return root.val;
        }else if(k-1<r){
            //去右边找第k大的
            return kthLargest(root.right,k);
        }else {
            //去左边找第k-1-r大的
            return kthLargest(root.left,k-1-r);
        }
    }

    private int count(TreeNode root) {
        if(root==null) return 0;
        return 1+count(root.left)+count(root.right);
    }
}
