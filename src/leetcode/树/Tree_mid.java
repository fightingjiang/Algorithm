package leetcode.树;

import java.util.*;

public class Tree_mid {
    //验证二叉搜索树
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if(root==null) return true;
        if(root.val>min&&root.val<max){
            return isValidBST(root.left,min,root.val)&&isValidBST(root.right,root.val,max);
        }else {
            return false;
        }
    }

    public boolean isValidBST1(TreeNode root) {
        //中序遍历解决   二叉搜索树的中序遍历是升序
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root,list);
        for (int i = 0; i < list.size()-1; i++) {
            if(list.get(i+1)<list.get(i)){
                return false;
            }
        }
        return true;
    }

    private void inOrder(TreeNode root, ArrayList<Integer> list) {
        if(root==null) return;
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }

    //前序中序构造树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0) return null;
        int rootValue = preorder[0];
        int inorderIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i]==rootValue){
                inorderIndex = i;
                break;
            }
        }
        int preIndex = inorderIndex+1;
        TreeNode root = new TreeNode(rootValue);
        root.left = buildTree(Arrays.copyOfRange(preorder,1,preIndex),Arrays.copyOfRange(inorder,0,inorderIndex));
        root.right = buildTree(Arrays.copyOfRange(preorder,preIndex,preorder.length),Arrays.copyOfRange(inorder,inorderIndex+1,inorder.length));
        return root;
    }

    //路径总和   根节点到叶子节点
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        LinkedList<Integer> track = new LinkedList<>();
        dfs(root,targetSum,track);
        return res;
    }

    private void dfs(TreeNode root, int targetSum, LinkedList<Integer> track) {
        if(root==null) return;
        track.add(root.val);
        targetSum-=root.val;
        if(root.left==null&&root.right==null&&targetSum==0){
            res.add(new LinkedList<Integer>(track));
        }
        dfs(root.left,targetSum,track);
        dfs(root.right,targetSum,track);
        track.removeLast();
    }

    //路径总和III  任意路径
    int count = 0;
    public int pathSumII(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> track = new HashMap<>();
        // 前缀和为0的一条路径
        track.put(0, 1);
        dfs_(root,targetSum,0,track);
        return count;
    }

    private void dfs_(TreeNode root, int targetSum, int sum, Map<Integer, Integer> track) {
        if(root==null) return;
        sum+=root.val;
        //做选择 有满足条件的情况下count+track.track.getOrDefault(targetSum-sum,0);
        count+=track.getOrDefault(sum-targetSum,0);
        track.put(sum,track.getOrDefault(sum,0)+1);
        dfs_(root.left,targetSum,sum,track);
        dfs_(root.right,targetSum,sum,track);
        track.put(sum,track.getOrDefault(sum,0)-1);
    }

    public int pathSumII_dg(TreeNode root, int targetSum) {
        if (root == null) return 0;
        //使用当前节点求和得到的targetSum的个数
        return countThisNode(root,targetSum)+pathSumII_dg(root.left,targetSum)+pathSumII_dg(root.right,targetSum);
    }

    private int countThisNode(TreeNode root, int targetSum) {
        if(root==null) return 0;
        int isMe = root.val==targetSum?1:0;
        return isMe+countThisNode(root.left,targetSum-root.val)+countThisNode(root.right,targetSum-root.val);
    }

    //锯齿形层序遍历
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
                if(flag){
                    list.addFirst(node.val);
                }else {
                    list.add(node.val);
                }
            }
            res.add(list);
            flag = !flag;
        }
        return res;
    }

    //右视图
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            TreeNode tmp = null;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
                tmp = node;
            }
            list.add(tmp.val);
        }
        return list;
    }
}
