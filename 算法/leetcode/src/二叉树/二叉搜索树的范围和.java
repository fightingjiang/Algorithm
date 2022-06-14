package 二叉树;

public class 二叉搜索树的范围和 {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root==null) return 0;
        else if(root.val<L){
            return rangeSumBST(root.right,L,R);
        }else if(root.val>R){
            return rangeSumBST(root.left,L,R);
        }else{
            return root.val+rangeSumBST(root.left,L,R)+rangeSumBST(root.right,L,R);
        }
    }
}
