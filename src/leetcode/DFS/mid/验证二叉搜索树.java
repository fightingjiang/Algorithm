package leetcode.DFS.mid;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 15:06 2021/6/27
 */
public class 验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if(root==null) return true;
        if(root.val<max&&root.val>min){
            return isValidBST(root.left,min,root.val)&&isValidBST(root.right,root.val,max);
        }else {
            return false;
        }
    }
}
