package 递归;


import java.util.Arrays;

public class 重建二叉树 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        int rootValue = preorder[0];
        int index = 0;
        //index 左边为左子树 右边为右子树
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i]==rootValue){
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootValue);
        root.left = buildTree(Arrays.copyOfRange(preorder,1,index+1),Arrays.copyOfRange(inorder,0,index));
        root.right = buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));
        return root;
    }
}
