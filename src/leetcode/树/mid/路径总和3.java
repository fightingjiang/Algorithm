package leetcode.树.mid;

import leetcode.树.TreeNode;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 13:52 2021/7/7
 */
public class 路径总和3 {
    public int pathSum(TreeNode root, int targetSum) {
            if(root==null) return 0;
            return count(root,targetSum)+pathSum(root.left,targetSum)+pathSum(root.right,targetSum);
        }

        private int count(TreeNode root, int targetSum) {
            if(root==null) return 0;
            int isMe = root.val==targetSum?1:0;
            return isMe+count(root.left,targetSum-root.val)+count(root.right,targetSum-root.val);
    }
}
