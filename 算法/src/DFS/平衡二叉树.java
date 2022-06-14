package DFS;

public class 平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return isBalanced(root.left)&&isBalanced(root.right)&&Math.abs(maxDepth(root.left)-maxDepth(root.right))<=1;
    }

    //求二叉树的深度
    public  static int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
    }
}
