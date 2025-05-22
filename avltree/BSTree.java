package avltree;

import Exceptions.ItemDuplicated;

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
    
    @Override
    public void insert(E data) throws ItemDuplicated {
        root = insert(root, data);
    }

    private Node insert(Node node, E data) throws ItemDuplicated {
        if (node == null) {
            return new Node(data);
        }
        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = insert(node.left, data);
        } else if (cmp > 0) {
            node.right = insert(node.right, data);
        } else {
            throw new ItemDuplicated();
        }
        return node;
    }
}
