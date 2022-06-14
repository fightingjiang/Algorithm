package leetcode.树.mid;


import leetcode.树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 14:41 2021/7/23
 */
public class 从上到下打印二叉树3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        boolean flag = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(flag){
                    list.add(poll.val);
                }else {
                    list.add(0,poll.val);
                }
                if(poll.left!=null) queue.add(poll.left);
                if(poll.right!=null) queue.add(poll.right);
            }
            res.add(list);
            flag = !flag;
        }
        return res;
    }
}
