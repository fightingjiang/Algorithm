package 递归;

//递归
public class 路径总和3 {
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
    public int pathSum(TreeNode root, int sum) {
          if(root==null) return 0;
          return count(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }

    private int count(TreeNode root, int sum) {
          if(root==null) return 0;
          int isMe = root.val==sum?1:0;
          return isMe+count(root.left,sum-root.val)+count(root.right,sum-root.val);
    }
}
