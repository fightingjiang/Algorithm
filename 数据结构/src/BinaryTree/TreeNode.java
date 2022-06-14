package BinaryTree;

public class TreeNode {
    private int no ;
    private String name;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    //删除节点
    //如果是叶子节点则直接删除该节点
    //如果删除的节点是非叶子节点，则删除该子树
    public void delNode(int no){
        if(this.left!=null&&this.left.no==no){
            this.left = null;
            return;
        }
        if (this.right!=null&&this.right.no==no){
            this.right=null;return;
        }

        if(this.left!=null){
            this.left.delNode(no);
        }
        if(this.right!=null){
           this.right.delNode(no);
        }
    }

    //前序遍历
    public void preOder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOder();
        }
        if(this.right!=null){
            this.right.preOder();
        }
    }

}
