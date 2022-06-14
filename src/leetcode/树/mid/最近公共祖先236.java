package leetcode.树.mid;

import leetcode.树.TreeNode;

public class 最近公共祖先236 {
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return res;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return false;
        boolean lson = dfs(root.left,p,q);
        boolean rson = dfs(root.right,p,q);
        if((lson==true&&rson==true)||(root.val==p.val||root.val==q.val)&&(rson==true||lson==true)){
            res = root;
        }
        return lson||rson||(root.val==p.val||root.val==q.val);
    }


}
