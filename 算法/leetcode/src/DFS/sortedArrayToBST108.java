package DFS;

public class sortedArrayToBST108 {
    public static void main(String[] args) {
        TreeNode treeNode = new Solution().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        treeNode.infixOrder();
        System.out.println(treeNode.val);
        System.out.println(treeNode.left.val);
        System.out.println(treeNode.left.left.val);
    }
}
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return  helper(nums,0,nums.length-1);
    }

    public TreeNode helper(int[] nums , int left , int right){
        if(left>right){
            return null;
        }

        int mid = (left+right+1)/2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,left,mid-1);
        root.right = helper(nums,mid+1,right);
        return root;
    }
}

class TreeNode {
      int val;
      TreeNode left = null;
      TreeNode right = null;
      TreeNode(int x) { val = x; }

      public void infixOrder(){
          if (this.left!=null){
              this.left.infixOrder();
          }
          System.out.println(this.val);

          if (this.right!=null){
              this.right.infixOrder();
          }
      }

 }
