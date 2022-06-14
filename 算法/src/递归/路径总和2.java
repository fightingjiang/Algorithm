package 递归;

import java.util.LinkedList;
import java.util.List;

public class 路径总和2 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> pathSum(路径总和3.TreeNode root, int targetSum) {
        trackback(root,targetSum);
        return res;
    }

    private void trackback(路径总和3.TreeNode root, int targetSum) {
        if(root==null) return;
        //选择路径
        track.add(root.val);
        targetSum = targetSum-root.val;
        //符合条件加入结果集
        if(root.left==null&&root.right==null&&targetSum==0){
            res.add(new LinkedList<>(track));
        }

        trackback(root.left,targetSum);
        trackback(root.right,targetSum);

        track.removeLast();
    }


}
