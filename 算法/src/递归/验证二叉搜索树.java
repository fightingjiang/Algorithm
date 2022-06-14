package 递归;


import java.util.ArrayList;
import java.util.List;

public class 验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preoder(root,res);
        for (int i = 0; i < res.size()-1; i++) {
            if(res.get(i+1)<=res.get(i)){
                return false;
            }
        }
        return true;
    }

    private void preoder(TreeNode root, List<Integer> res) {
        if(root==null) return;
        preoder(root.left,res);
        res.add(root.val);
        preoder(root.right,res);
    }
}
