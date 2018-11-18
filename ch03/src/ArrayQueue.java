/**
 * A queue implmentation using an array.
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-11-15 10:47 AM
 */
public class ArrayQueue<AnyType> implements QueueInterface<AnyType>{

    private static final int DEFAULT_CAPACITY = 6;
    private Object[] elements;
    private int front;
    private int back;
    private int nItems;

    public ArrayQueue(int initialCapacity) {
        if (initialCapacity <= 0) {
            elements = new Object[DEFAULT_CAPACITY];
        }else {
            elements = new Object[initialCapacity];
        }

        front = 0;
        back = -1;
        nItems = 0;
    }

    @Override
    public void enqueue(AnyType item) {
        if (nItems == elements.length) {
            throw new RuntimeException("Queue is full");
        }

        back += 1;
        back %= elements.length;
        elements[back] = item;
        nItems += 1;
    }

    @Override
    public AnyType dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        AnyType polled = (AnyType) elements[front];
        elements[front] = null;
        front += 1;
        front %= elements.length;
        nItems -= 1;
        return polled;
    }

    @Override
    public AnyType peekFront() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return (AnyType) elements[front];
    }

    @Override
    public boolean isEmpty() {
        return nItems == 0;
    }
}
