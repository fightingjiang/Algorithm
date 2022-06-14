package leetcode.DFS.mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 14:30 2021/6/27
 */
public class 路径总和2 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> track = new ArrayList<>();
        dfs(root,targetSum,track);
        return res;
    }

    private void dfs(TreeNode root, int targetSum, ArrayList<Integer> track) {
        if(root==null) return;
        track.add(root.val);
        targetSum -= root.val;
        if(targetSum==0&&root.left==null&&root.right==null){
            res.add(new ArrayList<>(track));
            //如果要return  需要删除之前添加进来的节点
            track.remove(track.size()-1);
            return;
        }
        dfs(root.left,targetSum,track);
        dfs(root.right,targetSum,track);
        track.remove(track.size()-1);
    }
}
