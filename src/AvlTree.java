public class AvlTree {

    private Node root = null;

    public AvlTree() {
        this.root = null;
    }

    public void removeAll() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public Node getNodeRoot() {
        return this.root;
    }

    public boolean insert(int element) {
        this.root = insert(element, this.root);
        return true;
    }

    public boolean searchForElement(int element) {
        return search(this.root, element) != 0;
    }

    public void inOrder() {
        inOrder(this.root);
    }

    public void preOrder() {
        preOrder(this.root);
    }

    public void posOrder() {
        postOrder(this.root);
    }

    public void printTree() {
        if (isEmpty()) {
            System.out.println("Arvore vazia!");
            return;
        }
        String separator = String.valueOf("  |--->");
        System.out.println(this.root.element + "(" + this.root.height + ")");
        showSubTree(this.root.left, separator);
        showSubTree(this.root.right, separator);
    }

    public Node balance(Node node) {
        if (getFactor(node) == 2) {
            if (getFactor(node.left) > 0) {
                node = rightRotation(node);
            } else {
                node = rightDoubleRotation(node);
            }
        } else if (getFactor(node) == -2) {
            if (getFactor(node.right) < 0) {
                node = leftRotation(node);
            } else {
                node = leftDoubleRotation(node);
            }
        }
        node.height = maxHeight(Height(node.left), Height(node.right)) + 1;
        return node;
    }

    private static int Height(Node node) {
        if (node == null) {
            return -1;
        } else {
            return node.height;
        }
    }

    private static int maxHeight(int alturaEsquerda, int alturaDireita) {
        return Math.max(alturaEsquerda, alturaDireita);
    }

    private int getFactor(Node t) {
        return Height(t.left) - Height(t.right);
    }

    private Node insert(int insertElement, Node node) {
        if (node == null) {
            node = new Node(insertElement);
        } else if (insertElement < node.element) {
            node.left = insert(insertElement, node.left);
        } else if (insertElement > node.element) {
            node.right = insert(insertElement, node.right);
        }
        node = balance(node);
        return node;
    }

    private static Node rightRotation(Node node) {
        Node noAux = node.left;
        node.left = noAux.right;
        noAux.right = node;
        node.height = maxHeight(Height(node.left), Height(node.right)) + 1;
        noAux.height = maxHeight(Height(noAux.left), node.height) + 1;
        return noAux;
    }

    private static Node leftRotation(Node node) {
        Node noAux = node.right;
        node.right = noAux.left;
        noAux.left = node;
        node.height = maxHeight(Height(node.left), Height(node.right)) + 1;
        noAux.height = maxHeight(Height(noAux.right), node.height) + 1;
        return noAux;
    }

    private static Node rightDoubleRotation(Node node) {
        node.left = leftRotation(node.left);
        return rightRotation(node);
    }

    private static Node leftDoubleRotation(Node node) {
        node.right = rightRotation(node.right);
        return leftRotation(node);
    }

    protected int search(Node node, int searchElement) {
        while (node != null) {
            if (searchElement == node.element) {
                return 1;
            } else if (searchElement < node.element) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return 0;
    }

    protected Node searchParent(int element) {
        Node rootNode = this.root;
        Node previous = null;
        while (rootNode != null && !(rootNode.element == element)) {
            previous = rootNode;
            if (rootNode.element < element) {
                rootNode = rootNode.right;
            } else {
                rootNode = rootNode.left;
            }
        }
        if (rootNode != null && rootNode.element == element) {
            return previous;
        }
        return null;
    }
    protected void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.element + " | ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    protected void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.element + " | ");
            inOrder(node.right);
        }
    }

    protected void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.element + " | ");
        }
    }
    private void showSubTree(Node node, String separator) {

        if (node != null) {
            Node parent = this.searchParent(node.element);
            if (node.equals(parent.left)) {
                System.out.println(separator + node.element + "(" + node.height + ")" + " (left)");
            } else {
                System.out.println(separator + node.element + "(" + node.height + ")" + " (right)");
            }
            showSubTree(node.left, "  " + separator);
            showSubTree(node.right, "  " + separator);
        }
    }
}
