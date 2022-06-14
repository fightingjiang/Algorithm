package leetcode.树.mid;

import leetcode.树.TreeNode;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 14:13 2021/7/7
 */
public class 路径总和 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        if(root.left==null&&root.right==null){
            return targetSum==root.val;
        }
        return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
    }
}
