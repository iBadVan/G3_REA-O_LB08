package avltree;

import Exceptions.ItemDuplicated;
import Exceptions.ItemNoFound;
import Exceptions.ExceptionIsEmpty;

public interface BinarySearchTree<E> {
    
    void insert(E data) throws ItemDuplicated;

    E search(E data) throws ItemNoFound;

    void delete(E data) throws ExceptionIsEmpty;

    boolean isEmpty();
}