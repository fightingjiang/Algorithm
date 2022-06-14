package leetcode.树.mid;

import leetcode.树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 21:28 2021/7/24
 */
public class 二叉树的完全性检验 {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean reachedEnd = false;
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur == null){
                //表示遇到了第一个空节点，之后不应该再有非空节点
                reachedEnd = true;
                continue;
            }
            if(reachedEnd && cur != null){
                return false;
            }
            q.offer(cur.left);
            q.offer(cur.right);
        }
        return true;
    }
}
