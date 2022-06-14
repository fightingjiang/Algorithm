package 二叉树;

public class 是否为搜索二叉树完全二叉树 {
    public boolean[] judgeIt (TreeNode root) {
        boolean[] res = new boolean[2];
        res[0] = fun1(root);
        res[1] = fun2(root);
        return res;

    }

    //是否为二叉搜索树
    private boolean fun1(TreeNode root) {
        if(root==null) return true;
        if((root.left!=null&&root.left.val>root.val)||root.right!=null&&root.right.val<root.val) return false;
        return fun1(root.left)&&fun1(root.right);
    }

    private boolean fun2(TreeNode root) {
        return false;
    }
}
