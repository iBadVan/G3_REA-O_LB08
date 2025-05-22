package avltree;

import Exceptions.ItemDuplicated;

public class TestAVLLevelOrder {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();
        try {
            avl.insert(50);
            avl.insert(30);
            avl.insert(70);
            avl.insert(40);
            avl.insert(60);
            avl.insert(80);
            avl.insert(35);
        } catch (ItemDuplicated e) {
            System.out.println("Error: elemento duplicado");
        }

        System.out.println("Recorrido por amplitud (nivel por nivel):");
        avl.levelOrder();
    }
}
