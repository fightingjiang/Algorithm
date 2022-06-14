package 二叉树;

import java.util.ArrayList;
import java.util.Arrays;

public class 二叉搜索树操作 {
    public static void main(String[] args) {
        二叉搜索树操作 f = new 二叉搜索树操作();
        TreeNode root = new TreeNode(10);
        for (int i = 3; i <= 30; i+=3) {
            f.insertBST(root,i);
        }
        f.show(root);
        f.deleteNode(root,10);
        f.show(root);
    }

    //是否是二叉搜索树
    public boolean isSameTree(TreeNode root){
        return isSameTree(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean isSameTree(TreeNode root, long minValue, long maxValue) {
        if(root==null) return true;
        if(root.val<=minValue) return false;
        if(root.val>=maxValue) return false;
        return isSameTree(root.left,minValue,root.val)&&isSameTree(root.right,root.val,maxValue);
    }

    //查找一个元素是否存在
    public boolean isInBST(TreeNode root,int target){
        if(root==null) return false;
        if(root.val==target) return true;
        if(target>root.val){
            return isInBST(root.right,target);
        }else{
            return isInBST(root.left,target);
        }
    }

    //在二叉搜索树中插入一个元素
    public TreeNode insertBST(TreeNode root,int value){
        if(root==null) return new TreeNode(value);
        if(value<root.val) root.left = insertBST(root.left,value);
        else root.right = insertBST(root.right,value);
        return root;
    }

    //删除某个元素
    public TreeNode deleteNode(TreeNode root,int value){
        if(root==null) return null;
        if(root.val==value){
            //删除某个元素
            //若该节点为叶子节点   直接删除即可
            if(root.left==null&&root.right==null){
                return null;
            }
            //若该节点只有一个非空子节点  直接让孩子节点为root当前节点即可
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;
            //A有两个节点  必须找到左子树最大的最大节点或者右子树的最小节点才能保持二叉搜索树的性质
            TreeNode minNode = getMin(root);
            root.val = minNode.val;
            root.right = deleteNode(root.right,minNode.val);
        } else if(value<root.val){
            root.left = deleteNode(root.left,value);
        }else if(value>root.val){
            root.right =  deleteNode(root.right,value);
        }
        return root;
    }

    private TreeNode getMin(TreeNode root) {
        //右子树最左边的就是最小的
        while (root.left!=null) root = root.left;
        return root;
    }

    //中序遍历
    public void show(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root,list);
        System.out.println(Arrays.toString(list.toArray()));
    }

    private void  inOrder(TreeNode root, ArrayList<Integer> list) {
        if(root==null) return ;
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }

}
