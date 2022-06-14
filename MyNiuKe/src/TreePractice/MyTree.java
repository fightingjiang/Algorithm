package TreePractice;

import javax.xml.soap.Node;
import java.util.Arrays;
import java.util.Stack;

public class MyTree {
//    //根据前序和中序遍历重构二叉树
//    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
//        if(pre.length==0) return null;
//        int rootValue = pre[0];
//        if(pre.length==1){
//            return new TreeNode(rootValue);
//        }
//        TreeNode root = new TreeNode(rootValue);
//        int valueIndex = -1;
//        for (int i = 0; i < in.length; i++) {
//            if(in[i]==rootValue){
//                valueIndex = i;
//                break;
//            }
//        }
//
//        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,valueIndex+1),Arrays.copyOfRange(in,0,valueIndex));
//        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,valueIndex+1,pre.length),Arrays.copyOfRange(in,valueIndex+1,in.length));
//        return root;
//    }

    public static void main(String[] args) {
        TreeNode root = reConstructBinaryTree(new int[]{1,2,4,7,3,5,6,8}, new int[]{4,7,2,1,5,3,8,6});
        midOrder(root);
    }


    //树遍历
    public static void preOrder(TreeNode root){
        if(root==null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    //中序
    public static void midOrder(TreeNode root){
        if(root==null) return;
        preOrder(root.left);
        System.out.println(root.val);
        preOrder(root.right);
    }

    //根据前序和中序遍历重构二叉树
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length==0){
            return null;
        }
        int rootValue = pre[0];
        if(pre.length==1){
            return new TreeNode(rootValue);
        }
        TreeNode root = new TreeNode(rootValue);
        int k = -1;
        for (int i = 0; i < in.length; i++) {
            if(in[i]==rootValue){
                k = i;
                break;
            }
        }
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,k+1),Arrays.copyOfRange(in,0,k));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,k+1,pre.length),Arrays.copyOfRange(in,k+1,in.length));
        return root;
    }

    //二叉树是否堆成
    public boolean isSymmetric (TreeNode root) {
        return root==null?true:recur(root.left,root.right);
    }

    private boolean recur(TreeNode left, TreeNode right) {
        if(left==null&&right==null) return true;
        if(left==null||right==null||left.val!=right.val) return false;
        return recur(left.left,right.right) &&recur(left.right,right.left);
    }

    //镜像树   借用栈
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left!=null) stack.push(node.left);
            if(node.right!=null) stack.push(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return  root;
    }

    //镜像树   递归
    static public TreeNode mirrorTree01(TreeNode root) {
        if(root==null) return null;
        TreeNode tmp = root.left;
        root.left = mirrorTree01(root.right);
        root.right = mirrorTree01(tmp);
        return root;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}