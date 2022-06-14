package DFS;

public class minDepth {
    public int minDepth(TreeNode root){
        if(root ==null){
            return  0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }

        int min_Depth = Integer.MAX_VALUE;
        if(root.left!=null){
            min_Depth = Math.min(minDepth(root.left),min_Depth);
        }
        if(root.right!=null){
            min_Depth = Math.min(minDepth(root.right),min_Depth);
        }
        return min_Depth+1;
    }
}
