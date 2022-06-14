package DFS;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树深度55 {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
    }


    //BFS解法
    public int maxDepthDFS(TreeNode root) {
        //BFS解法
        if(root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.offer(root);
        while (!queue.isEmpty()){
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return depth;
    }
}
