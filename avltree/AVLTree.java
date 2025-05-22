package avltree;

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

}
