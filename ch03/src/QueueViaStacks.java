import org.junit.Test;

import java.util.Stack;

import static junit.framework.Assert.assertEquals;

/**
 * Implement a MyQueue class which implements a queue using 2 stacks.
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2019-01-01 10:54 PM
 */
public class QueueViaStacks {

    Stack s1 = new Stack();
    Stack s2 = new Stack();

    public void offer(int v) {
        s1.push(v);
    }

    public int poll() {
        moveFrom1To2();
        return (Integer) s2.pop();
    }

    public int peek() {
        moveFrom1To2();
        return (Integer) s2.peek();
    }

    private void moveFrom1To2() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
    }

    @Test
    public void test() {
        QueueViaStacks qvs = new QueueViaStacks();
        qvs.offer(1);
        qvs.offer(2);
        qvs.offer(3);
        assertEquals(qvs.peek(), 1);
        assertEquals(qvs.poll(), 1);
        assertEquals(qvs.poll(), 2);
        assertEquals(qvs.poll(), 3);
    }
}
