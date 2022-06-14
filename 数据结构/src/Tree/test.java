package Tree;

import javax.swing.tree.TreeNode;

public class test {
    public static void main(String[] args) {
        Node root = new Node(1, "jiang");
        root.setLeft(new Node(2,"zhi"));
        root.setRight(new Node(3,"hao"));
        root.infixOrder();

    }
}
