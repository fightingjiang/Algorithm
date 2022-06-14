package leetcode.树.easy;

import leetcode.树.TreeNode;

public class 另一个树的子树 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null&&subRoot==null) return true;
        if(subRoot==null) return true;
        if(root==null) return false;
        if(root.val==subRoot.val){
            return isSameTree(root.left,subRoot.left)&&isSameTree(root.right,subRoot.right)||(isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot));
        }
        return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
    }

    public boolean isSameTree(TreeNode p,TreeNode q){
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;
        return p.val==q.val&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}
