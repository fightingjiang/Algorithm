import java.util.LinkedList;
import java.util.List;

public class 路径总和113 {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        trackback(root,targetSum);
        return res;
    }

    private void trackback( TreeNode root, int targetSum) {
        if(root==null) return;
        track.add(root.val);
        targetSum-= root.val;
        //终止条件
        if(root.left==null&&root.right==null&&targetSum==0){
            res.add(new LinkedList<>(track));
        }
        //选择路径
        trackback(root.left,targetSum);
        trackback(root.right,targetSum);
        track.removeLast();
    }
}
