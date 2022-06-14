package leetcode.树.mid;

import leetcode.树.TreeNode;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 20:10 2021/7/10
 */
public class 二叉树的第k个节点 {
    int n = 1;
    TreeNode res = null;
    TreeNode KthNode(TreeNode pRoot, int k) {
        inOrder(pRoot,k);
        return res;
    }

    private void  inOrder(TreeNode pRoot, int k) {
        if(pRoot==null) return;
        inOrder(pRoot.left,k);
        if(n++==k) {
            res = pRoot;
            return;
        }
        inOrder(pRoot.right,k);
    }
}
