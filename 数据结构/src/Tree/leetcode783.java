package Tree;

public class leetcode783 {
    static int ans = Integer.MAX_VALUE;
    static int prev = 0;
    public static void main(String[] args) {
        Node root = new Node(4, null);
        root.setRight(new Node(6,null));
        Node left = new Node(2, null);
        root.setLeft(left);
        left.setLeft(new Node(1,null));
        left.setRight(new Node(3,null));
        root.infixOrder();
        dfs(root);
        System.out.println(ans);


    }

    public static void  dfs(Node root){
        if(root==null) return ;
        dfs(root.getLeft());
        if(prev!=0){
            ans=Math.min(ans,root.getNo()-prev);
        }
        prev = root.getNo();
        dfs(root.getRight());
    }



}
