package DFS;

import java.util.LinkedList;
import java.util.List;

public class 路径总和113 {
      //DFS   回溯
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        trackback(root,targetSum);
        return res;
    }

    private void trackback( TreeNode root, int targetSum) {
        if(root==null) return;
        path.add(root.val);
        targetSum-= root.val;
        //终止条件
        if(root.left==null&&root.right==null&&targetSum==0){
            res.add(new LinkedList<>(path));
        }
        //选择路径
        trackback(root.left,targetSum);
        trackback(root.right,targetSum);
        path.removeLast();
    }
}
