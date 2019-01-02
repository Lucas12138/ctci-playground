/**
 * Created by lucas on 13/12/2018.
 */
public interface BSTInterface {

    /**
     * Finds key in the tree.
     * @param key to find
     * @return boolean value (true when found)
     */
    boolean find(int key);

    /**
     * Inserts a new key into the tree.
     * @param key key to add
     */
    void insert(int key);

    /**
     * Deletes a key (node) from the tree.
     * @param key key to delete
     */
    void delete(int key);

    /**
     * Traverses the tree in an ascending order based on keys.
     */
    void traverse();
}
