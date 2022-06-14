package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 二叉树中和为某一值的路径 {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        trackback(root,target);
        return res;
    }

    private void trackback(TreeNode root, int target) {
        if(root==null) return;
        track.add(root.val);
        target = target-root.val;
        if(root.left==null&root.right==null&&target==0){
            res.add(new LinkedList<>(track));
        }
        trackback(root.left,target);
        trackback(root.right,target);
        track.removeLast();
    }
}
