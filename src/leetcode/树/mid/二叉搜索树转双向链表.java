package leetcode.树.mid;

import leetcode.树.TreeNode;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 20:49 2021/7/24
 */
public class 二叉搜索树转双向链表 {
    TreeNode pre, head;
    public TreeNode treeToDoublyList(TreeNode root) {
        if(root == null) return null;
        inOrder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        if(pre != null) {
            pre.right = root;
        } else {
            head = root;
        }
        root.left = pre;
        pre = root;
        inOrder(root.right);
    }
}
