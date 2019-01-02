import org.junit.Test;

import java.util.*;

import static junit.framework.Assert.assertEquals;

/**
 * Implement a method to sort a stack. Array or other data structures are not allowed. An additional temporary stack is allowed.
 * When popping a sorted stack, the results should be in ascending order.
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2019-01-01 11:21 PM
 */
public class SortStack {

    public void sortStack(Stack<Integer> s) {
        Stack<Integer> tmpStack = new Stack<>();
        while (!s.isEmpty()) {
            int tmp = s.pop();
            while (!tmpStack.isEmpty() && tmpStack.peek() > tmp) {
                s.push(tmpStack.pop());
            }
            tmpStack.push(tmp);
        }

        while (!tmpStack.isEmpty()) {
            s.push(tmpStack.pop());
        }
    }

    @Test
    public void test() {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(1);
        s.push(3);
        s.push(8);
        sortStack(s);
        List<Integer> tmp = new ArrayList<>();
        while (!s.isEmpty()) {
            tmp.add(s.pop());
        }
        assertEquals(Arrays.toString(tmp.stream().mapToInt(i->i).toArray()), Arrays.toString(new int[]{1,1,2,3,8}));
    }
}
