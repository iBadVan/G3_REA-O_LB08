package avltree;

import Exceptions.ItemDuplicated;
import Exceptions.ItemNoFound;

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

    @Override
    public E search(E data) throws ItemNoFound {
        Node node = search(root, data);
        if (node == null) throw new ItemNoFound();
        return node.data;
    }

    private Node search(Node node, E data) {
        if (node == null) return null;
        int cmp = data.compareTo(node.data);
        if (cmp == 0) return node;
        else if (cmp < 0) return search(node.left, data);
        else return search(node.right, data);
    }

}
