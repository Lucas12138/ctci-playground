import java.util.Stack;

/**
 * Stack implementation using array.
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-11-14 11:31 PM
 */
public class ArrayStack<AnyType> implements StackInterface<AnyType> {

    private static final int DEFAULT_CAPACITY = 10;
    private int topIndex;
    private Object[] elements;

    public ArrayStack(int initialCapacity) {
        if (initialCapacity <= 0) {
            elements = new Object[DEFAULT_CAPACITY];
        }else {
            elements = new Object[initialCapacity];
        }

        topIndex = -1;
    }

    @Override
    public void push(AnyType time) {
        if (topIndex == elements.length - 1) {
            throw new RuntimeException("Stack is full");
        }

        topIndex += 1;
        elements[topIndex] = time;
    }

    @Override
    public AnyType pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        AnyType element = (AnyType) elements[topIndex];
        elements[topIndex] = null;
        topIndex -= 1;
        return element;
    }

    @Override
    public AnyType peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return (AnyType) elements[topIndex];
    }

    @Override
    public boolean isEmpty() {
        return topIndex == -1;
    }
}
