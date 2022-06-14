package leetcode.树.mid;

import leetcode.树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 路径总和2 {
    List<List<Integer>> res=  new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> track = new ArrayList<>();
        dfs(track,root,targetSum);
        return res;
    }

    private void dfs(ArrayList<Integer> track, TreeNode root, int targetSum) {
        if(root==null) return;
        track.add(root.val);
        targetSum-=root.val;
        if(targetSum==0&&root.left==null&&root.right==null){
            res.add(new ArrayList<>(track));
        }
        dfs(track,root.left,targetSum);
        dfs(track,root.right,targetSum);
        track.remove(track.size()-1);
    }
}
