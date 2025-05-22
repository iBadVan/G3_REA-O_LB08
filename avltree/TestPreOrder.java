package avltree;

public class TestPreOrder {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();
        try {
            avl.insert(50);
            avl.insert(30);
            avl.insert(70);
            avl.insert(20);
            avl.insert(40);
            avl.insert(80);
            avl.insert(60);
            avl.insert(10);
            avl.insert(25);
            avl.insert(65);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Recorrido Preorden:");
        avl.preOrder();
    }
}