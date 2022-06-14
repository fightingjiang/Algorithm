package SortTree;

public class BinarySortTree {
    static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    private Node root = null;

    public BinarySortTree() {
    }

    public void insertBST(int key){
        Node p = root;
        Node pre = null;//找到要插入的位置

        while (p!=null){
            pre = p;
            if(key<p.getValue()){
                p = p.left;
            }else if(key>p.getValue()){
                p = p.getRight();
            }else {
                return;
            }
        }
        if(root==null){
            root = new Node(key);
        }else if(key<pre.getValue()){
            pre.setLeft(new Node(key));
        }else {
            pre.setRight(new Node(key));
        }
    }

}
