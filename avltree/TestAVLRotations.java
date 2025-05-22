package avltree;

import Exceptions.ExceptionIsEmpty;
import Exceptions.ItemDuplicated;

public class TestAVLRotations {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();
        try {
            avl.insert(50);
            printAndExplain(avl, "Inserción 50 - Árbol inicial");

            avl.insert(30);
            printAndExplain(avl, "Inserción 30 - Balanceado, sin rotación");

            avl.insert(10); // RSR esperado
            printAndExplain(avl, "Inserción 10 - Rotación simple derecha (RSR)");

            avl.insert(70);
            printAndExplain(avl, "Inserción 70 - Balanceado");

            avl.insert(80); // RSL esperado
            printAndExplain(avl, "Inserción 80 - Rotación simple izquierda (RSL)");

            avl.insert(65);
            printAndExplain(avl, "Inserción 65 - Balanceado");

            avl.insert(60); // RDR esperado
            printAndExplain(avl, "Inserción 60 - Rotación doble derecha-izquierda (RDR)");

            avl.insert(20); // RDL esperado
            printAndExplain(avl, "Inserción 20 - Rotación doble izquierda-derecha (RDL)");

            // Eliminaciones que provoquen rotaciones
            avl.delete(80);
            printAndExplain(avl, "Eliminación 80 - Rebalanceo");

            avl.delete(30);
            printAndExplain(avl, "Eliminación 30 - Rebalanceo");

        } catch (ItemDuplicated | ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    
}
