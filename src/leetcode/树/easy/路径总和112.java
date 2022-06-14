package leetcode.树.easy;


import leetcode.树.TreeNode;

/*
给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，
判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
* */
public class 路径总和112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        targetSum-=root.val;
        boolean isMe = false;
        if(root.left==null&&root.right==null&&targetSum==0){
            isMe = true;
        }
        return isMe||hasPathSum(root.left,targetSum)||hasPathSum(root.right,targetSum);
    }
}
