package DFS;



public class isBalanced {
    //自顶向下
    public boolean isBalanced(TreeNode root){
        if(root==null){
            return true;
        }else{
            return Math.abs(height(root.left)-height(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);
        }
    }

    public int height(TreeNode root){
        if (root == null) {
            return 0;
        }else{
            return Math.max(height(root.left),height(root.right))+1;
        }
    }


    //自底向上
    public boolean isBalanced02(TreeNode root){
        if(root==null){
            return true;
        }else{
            return height02(root)>=0;
        }
    }

    private int height02(TreeNode root) {
        if(root ==null){
            return 0;
        }
        int heightLeft = height(root.left);
        int heightRight = height(root.right);
        if(heightLeft==-1||heightRight==-1||Math.abs(heightLeft-heightRight)>1){
            return -1;
        }else {
            return Math.max(heightLeft,heightRight)+1;
        }
    }
}
