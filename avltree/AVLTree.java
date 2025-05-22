package avltree;

import Exceptions.ExceptionIsEmpty;
import Exceptions.ItemDuplicated;

public class AVLTree<E extends Comparable<E>> extends BSTree<E> {
    class NodeAVL extends Node {
        protected int bf;  

        public NodeAVL(E data) {
            super(data); 
            this.bf = 0; 
        }

        @Override
        public String toString() {
            return data.toString() + "(" + bf + ")";
        }
    }
    private boolean height;

    public void insert(E x) throws ItemDuplicated {
        this.height = false;
        this.root = insert(x, (NodeAVL) this.root);
    }
    protected Node insert(E x, NodeAVL node) throws ItemDuplicated {
        NodeAVL fat = node;

        if (node == null) {
            this.height = true;
            fat = new NodeAVL(x);
        } else {
            int resC = node.data.compareTo(x);
            if (resC == 0)
                throw new ItemDuplicated(x + " ya se encuentra en el árbol...");

            if (resC < 0) {  // Insertar en el subárbol derecho
                fat.right = insert(x, (NodeAVL) node.right);
                if (this.height) {
                    switch (fat.bf) {
                        case -1:
                            fat.bf = 0;
                            this.height = false;
                            break;
                        case 0:
                            fat.bf = 1;
                            this.height = true;
                            break;
                        case 1:
                            fat = balanceToLeft(fat);
                            this.height = false;
                            break;
                    }
                }
            } else {  // Insertar en el subárbol izquierdo
                fat.left = insert(x, (NodeAVL) node.left);
                if (this.height) {
                    switch (fat.bf) {
                        case 1:
                            fat.bf = 0;
                            this.height = false;
                            break;
                        case 0:
                            fat.bf = -1;
                            this.height = true;
                            break;
                        case -1:
                            fat = balanceToRight(fat);
                            this.height = false;
                            break;
                    }
                }
            }
        }
        return fat;
    }

    private NodeAVL balanceToLeft(NodeAVL node) {
        NodeAVL hijo = (NodeAVL) node.right;
    
        switch (hijo.bf) {
            case 1:
                node.bf = 0;
                hijo.bf = 0;
                node = rotateSL(node);
                break;
            case -1:
                NodeAVL nieto = (NodeAVL) hijo.left;
                switch (nieto.bf) {
                    case -1:
                        node.bf = 0;
                        hijo.bf = 1;
                        break;
                    case 0:
                        node.bf = 0;
                        hijo.bf = 0;
                        break;
                    case 1:
                        node.bf = -1;
                        hijo.bf = 0;
                        break;
                }
                nieto.bf = 0;
                node.right = rotateSR(hijo);
                node = rotateSL(node);
                break;
        }
        return node;
    }
    
    private NodeAVL balanceToRight(NodeAVL node) {
        NodeAVL hijo = (NodeAVL) node.left;
    
        switch (hijo.bf) {
            case -1:
                node.bf = 0;
                hijo.bf = 0;
                node = rotateSR(node);
                break;
            case 1:
                NodeAVL nieto = (NodeAVL) hijo.right;
                switch (nieto.bf) {
                    case 1:
                        node.bf = 0;
                        hijo.bf = -1;
                        break;
                    case 0:
                        node.bf = 0;
                        hijo.bf = 0;
                        break;
                    case -1:
                        node.bf = 1;
                        hijo.bf = 0;
                        break;
                }
                nieto.bf = 0;
                node.left = rotateSL(hijo);
                node = rotateSR(node);
                break;
        }
        return node;
    }

    private NodeAVL rotateSL(NodeAVL node) {
        NodeAVL p = (NodeAVL) node.right;
        node.right = p.left;
        p.left = node;
        return p;
    }
    
    private NodeAVL rotateSR(NodeAVL node) {
        NodeAVL p = (NodeAVL) node.left;
        node.left = p.right;
        p.right = node;
        return p;
    }
    public void inOrder() {
        inOrder((NodeAVL) root);
        System.out.println();
    }
    
    private void inOrder(NodeAVL node) {
        if (node != null) {
            inOrder((NodeAVL) node.left);
            System.out.print(node.data + "(" + node.bf + ") ");
            inOrder((NodeAVL) node.right);
        }
    }

    @Override
    public void delete(E data) throws ExceptionIsEmpty {
        if (root == null) throw new ExceptionIsEmpty();
        height = false;
        root = delete((NodeAVL) root, data);
    }

    private NodeAVL delete(NodeAVL node, E data) {
        if (node == null) return null;
    
        int cmp = data.compareTo(node.data);
    
        if (cmp < 0) {
            node.left = delete((NodeAVL) node.left, data);
            if (height) {
                node = balanceAfterDeleteRight(node);
            }
        } else if (cmp > 0) {
            node.right = delete((NodeAVL) node.right, data);
            if (height) {
                node = balanceAfterDeleteLeft(node);
            }
        } else {
            // Nodo encontrado
            if (node.left == null) {
                height = true;
                return (NodeAVL) node.right;
            } else if (node.right == null) {
                height = true;
                return (NodeAVL) node.left;
            } else {
                // Nodo con dos hijos: buscar sucesor mínimo
                NodeAVL minNode = findMinNode((NodeAVL) node.right);
                node.data = minNode.data;
                node.right = delete((NodeAVL) node.right, minNode.data);
                if (height) {
                    node = balanceAfterDeleteLeft(node);
                }
            }
        }
        return node;
    }

    private NodeAVL balanceAfterDeleteLeft(NodeAVL node) {
        switch (node.bf) {
            case -1:
                node.bf = 0;
                break;
            case 0:
                node.bf = 1;
                height = false;
                break;
            case 1:
                NodeAVL right = (NodeAVL) node.right;
                if (right.bf >= 0) {
                    node = rotateSL(node);
                    if (right.bf == 0) {
                        node.bf = -1;
                        node.left.bf = 0;
                        height = false;
                    } else {
                        node.bf = 0;
                        node.left.bf = 0;
                    }
                } else {
                    node = balanceToLeft(node);
                }
                break;
        }
        return node;
    }

    private NodeAVL balanceAfterDeleteRight(NodeAVL node) {
        switch (node.bf) {
            case 1:
                node.bf = 0;
                break;
            case 0:
                node.bf = -1;
                height = false;
                break;
            case -1:
                NodeAVL left = (NodeAVL) node.left;
                if (left.bf <= 0) {
                    node = rotateSR(node);
                    if (left.bf == 0) {
                        node.bf = 1;
                        node.right.bf = 0;
                        height = false;
                    } else {
                        node.bf = 0;
                        node.right.bf = 0;
                    }
                } else {
                    node = balanceToRight(node);
                }
                break;
        }
        return node;
    }
}
