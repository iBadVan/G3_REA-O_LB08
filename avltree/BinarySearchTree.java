package avltree;

public interface BinarySearchTree<E extends Comparable<E>> {
    void insert(E data) throws Exception;
    void remove(E data) throws Exception;
    boolean contains(E data);
    E findMin() throws Exception;
    E findMax() throws Exception;
    boolean isEmpty();
    void clear();
    int size();
}