package avltree;

import Exceptions.ExceptionIsEmpty;
import Exceptions.ItemDuplicated;
import Exceptions.ItemNoFound;
import avltree.AVLTree.NodeAVL;

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

    @Override
    public void delete(E data) throws ExceptionIsEmpty {
        if (root == null) throw new ExceptionIsEmpty();
        root = delete(root, data);
    }

    protected Node delete(Node node, E data) {
        if (node == null) return null;
        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = delete(node.left, data);
        } else if (cmp > 0) {
            node.right = delete(node.right, data);
        } else {
            
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            
            Node minNode = findMinNode(node.right);
            node.data = minNode.data;
            node.right = delete(node.right, minNode.data);
        }
        return node;
    }

    protected Node findMinNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }
    
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }
    
    public int height() {
        return height(root);
    }
    
    private int height(Node node) {
        if (node == null) return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
}
