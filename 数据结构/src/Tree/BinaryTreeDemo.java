package Tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        Node root = new Node(1, "宋江");
        Node node2 = new Node(2, "吴用");
        Node node3 = new Node(3, "卢俊义");
        Node node4 = new Node(4, "林冲");
        Node node5 = new Node(5, "关胜");

        //说明，我们先手动创建该二叉树，后面我们学习递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(root);

        binaryTree.infixOrder();
    }
    public BinaryTreeDemo() {

    }
}
