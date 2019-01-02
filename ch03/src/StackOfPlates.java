import org.junit.Test;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

import static junit.framework.Assert.assertEquals;

/**
 * Implement a data structure SetOfStacks that mimics stacks of plates. It should be composed of several stacks and should create a new stack once the previous one exceeds capacity.
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2019-01-01 10:21 PM
 */
public class StackOfPlates {
    private List<Stack> stacks = new ArrayList<>();
    private int capacity = 2;

//    // junit doesn't allow constructor with parameters, temporarily commented out
//    public StackOfPlates(int c) {
//        capacity = c;
//    }


    public void push(int v) {
        Stack last = getLast();
        if (last == null || last.size() >= capacity) {
            Stack newStack = new Stack();
            newStack.push(v);
            stacks.add(newStack);
        }else {
            last.push(v);
        }
    }

    public int pop() {
        Stack last = getLast();
        if (last == null) throw new EmptyStackException();
        int res = (Integer) last.pop();
        if (last.size() == 0) {
            stacks.remove(stacks.size() - 1);
        }
        return res;
    }

    private Stack getLast() {
        if (stacks.size() == 0) {
            return null;
        }
        return stacks.get(stacks.size() - 1);
    }

    public int getSize() {
        return stacks.size();
    }

    @Test
    public void test() {
        StackOfPlates sop = new StackOfPlates();
        sop.push(1);
        sop.push(2);
        sop.push(3);
        assertEquals(sop.getSize(), 2);
        assertEquals(sop.pop(), 3);
        assertEquals(sop.pop(), 2);
        assertEquals(sop.pop(), 1);
    }
}
