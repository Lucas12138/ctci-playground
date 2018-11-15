/**
 * Created by lucas on 14/11/2018.
 */
public interface StackInterface<AnyType> {

    void push(AnyType time); // O(1)
    AnyType pop(); // O(1)
    AnyType peek(); // O(1)
    boolean isEmpty(); // O(1)

}
