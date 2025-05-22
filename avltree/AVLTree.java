package avltree;

public class AVLTree<E extends Comparable<E>> extends BSTree<E> {
    class NodeAVL extends Node {
        protected int bf;  

        public NodeAVL(E data) {
            super(data); 
            this.bf = 0; 
        }

    }
}
