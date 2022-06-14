import java.util.LinkedList;
import java.util.Queue;

public class TreeTest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        root.setLeft(node2);
        root.setRight(node5);
        node2.setLeft(node1);
        node2.setRight(node3);
        System.out.println(isBalance(root));
    }

    //先序遍历
    public static void preFirst(TreeNode root){
        if(root==null){
           return;
        }
        System.out.println(root.value);
        preFirst(root.left);
        preFirst(root.right);
    }

    //是否是AVL树
    public static boolean isBalance(TreeNode root){
        if(root==null){
            return true;
        }else{
            return Math.abs(getHigh(root.left)-getHigh(root.right))<=1&&isBalance(root.left)&&isBalance(root.right);
        }
    }

    //树高
    public static int getHigh(TreeNode root){
        if(root==null){
            return 0;
        }else {
//            int l,r;
//            l = getHigh(root.left);
//            r = getHigh(root.right);
//            if(l>r){
//                return l+1;
//            }else {
//                return r+1;
//            }
            return Math.max(getHigh(root.left),getHigh(root.right))+1;
        }
    }
    //层序遍历
    public static void levelOrder(TreeNode root){
        if (root==null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println(node.value);
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
    }
}
class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }

    public int getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
