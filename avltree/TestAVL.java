package avltree;
import Exceptions.ItemDuplicated;

public class TestAVL {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();

        try {
            avl.insert(30);
            avl.insert(20);
            avl.insert(10);  

            avl.insert(40);
            avl.insert(50);  

            avl.insert(25);
            avl.insert(22);

            avl.insert(45);
            avl.insert(47);  

            avl.insert(60);
            avl.insert(5);

        } catch (ItemDuplicated e) {
            System.out.println("Error: Elemento duplicado");
        }
        
        avl.inOrder();
    }
}
