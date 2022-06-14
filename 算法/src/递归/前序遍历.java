package 递归;

import java.util.ArrayList;
import java.util.List;

public class 前序遍历 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preoder(root,res);
        return res;
    }

    private void preoder(TreeNode root, List<Integer> res) {
        if(root==null) return;
        res.add(root.val);
        preoder(root.left,res);
        preoder(root.right,res);
    }
}
