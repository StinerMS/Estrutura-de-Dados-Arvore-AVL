public class Node {
    int element;
    int height;

    Node right;
    Node left;

    Node() {
        this.right = null;
        this.left = null;
        this.element = 0;
        this.height = 0;
    }
    Node(int element) {
        this.right = null;
        this.left = null;
        this.element = element;
        this.height = 0;
    }
}
