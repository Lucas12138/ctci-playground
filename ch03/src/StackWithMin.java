import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * Design a stack which, in addition to push and pop, has a function min which returns the minimum element. They should all operate in O(1) time.
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-10-22 2:49 AM
 */
public class StackWithMin extends Stack<Integer>{

    Stack<Integer> stackOfMins = new Stack<>();

    public void push(int value) {
        if (value <= min()) {
            stackOfMins.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if (value == min()) {
            stackOfMins.pop();
        }
        return value;
    }

    public int min() {
        if (stackOfMins.isEmpty()) {
            return Integer.MAX_VALUE;
        }

        return stackOfMins.peek();
    }

    @Test
    public void test() {
        push(2);
        push(1);
        push(3);
        assertEquals(min(), 1);
        assertEquals(pop(), new Integer(3));
    }

}
