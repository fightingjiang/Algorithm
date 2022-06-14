package 二叉树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

//二叉树右视图
public class 右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        //depth 和  值
        HashMap<Integer, Integer> map = new HashMap<>();
        int max_depth = -1;

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()){
            TreeNode node = nodeStack.pop();
            Integer depth = depthStack.pop();
            if(node!=null){
                max_depth = Math.max(max_depth,depth);
                if(!map.containsKey(depth)){
                    map.put(depth,node.val);
                }
                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth+1);
                depthStack.push(depth+1);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i <= max_depth; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}
