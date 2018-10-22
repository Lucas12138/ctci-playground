import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Use a single array to implement three stacks
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-10-22 12:11 AM
 */
public class FixedMultiStack {

    private int numberOfStacks = 3;
    private int capacity;
    private int[] multiStack;
    private int[] sizes;


    private void init(int capacity) {
        this.capacity = capacity;
        multiStack = new int[capacity * numberOfStacks];
        sizes = new int[capacity];
    }

    public void push(int stackIndex, int value) throws Exception {
        if (isFull(stackIndex)) {
            throw new Exception("Stack is full");
        }
        sizes[stackIndex] += 1;
        multiStack[getValueIndexFromMultiStack(stackIndex)] = value;
    }

    public int pop(int stackIndex) throws Exception {
        if (isEmpty(stackIndex)) {
            throw new Exception("Stack is empty");
        }

        int valueIndex = getValueIndexFromMultiStack(stackIndex);
        int value = multiStack[valueIndex];
        multiStack[valueIndex] = 0;
        sizes[stackIndex] -= 1;
        return value;
    }

    public int peek(int stackIndex) throws Exception {
        if (isEmpty(stackIndex)) {
            throw new Exception("Stack is empty");
        }

        return multiStack[getValueIndexFromMultiStack(stackIndex)];
    }

    private int getValueIndexFromMultiStack(int stackIndex) {
        int offset = stackIndex * capacity;
        int size = sizes[stackIndex];
        return offset + size - 1;
    }

    private boolean isEmpty(int stackIndex) {
        return sizes[stackIndex] == 0;
    }

    private boolean isFull(int stackIndex) {
        return sizes[stackIndex] >= capacity;
    }

    @Test (expected = Exception.class)
    /**
     * Unit test class can only have 0 argument constructor and has to be a public class!
     */
    public void test() throws Exception {
        init(3);
        push(0, 1);
        push(1, 2);
        push(0, 1);
        push(0, 1);

        assertEquals(peek(1), 2);
        assertEquals(pop(1), 2);
        // exceed on stack 0
        push(0, 1);
        // pop on empty stack 1
        pop(1);
    }
}
