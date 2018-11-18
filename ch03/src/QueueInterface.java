/**
 * Created by lucas on 15/11/2018.
 */
public interface QueueInterface<AnyType> {

    void enqueue(AnyType item); // O(1)
    AnyType dequeue(); // O(1)
    AnyType peekFront(); // O(1)
    boolean isEmpty(); // O(1)
}
