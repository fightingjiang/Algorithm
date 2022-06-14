package leetcode.DFS.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 13:52 2021/6/27
 */
public class 右视图 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if(root==null) return;
        dfs(root,0);
    }

    private void dfs(TreeNode root, int depth) {
        if(root==null) return;
        if(depth==res.size()){
            res.add(root.val);
        }
        depth++;
        dfs(root.right,depth);
        dfs(root.left,depth);
    }
}
