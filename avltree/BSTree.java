package avltree;

public class BSTree<E extends Comparable<E>> implements BinarySearchTree<E> {
    protected class Node {
        protected E data;
        protected Node left;
        protected Node right;

        public Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    protected Node root;

    public BSTree() {
        this.root = null;
    }
}
