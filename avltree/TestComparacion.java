package avltree;

public class TestComparacion {
    public static void main(String[] args) {
        BSTree<Integer> bst = new BSTree<>();
        AVLTree<Integer> avl = new AVLTree<>();

        try {
            
            int[] valores1 = {10, 20, 30, 40, 50};
            for (int v : valores1) {
                bst.insert(v);
                avl.insert(v);
            }
            System.out.println("BST InOrder:");
            bst.inOrder();  
            System.out.println("Altura BST: " + bst.height());

            System.out.println("AVL InOrder:");
            avl.inOrder();
            System.out.println("Altura AVL: " + avl.height());

            BSTree<Integer> bst2 = new BSTree<>();
            AVLTree<Integer> avl2 = new AVLTree<>();

            int[] valores2 = {30, 20, 10};
            for (int v : valores2) {
                bst2.insert(v);
                avl2.insert(v);
            }

            System.out.println("BST2 InOrder:");
            bst2.inOrder();
            System.out.println("AVL2 InOrder:");
            avl2.inOrder();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
