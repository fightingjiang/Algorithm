package 二叉树;

//226
public class 翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null )return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
