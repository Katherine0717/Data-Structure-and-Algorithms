public class Node {
    String element;
    Node left;
    Node right;

    Node(String element) {
        this.element = element;
        left = null;
        right = null;
    }
    public boolean isLeaf() {
        return (left == null) && (right == null);
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public void setRight(Node right) {
        this.right = right;
    }
}