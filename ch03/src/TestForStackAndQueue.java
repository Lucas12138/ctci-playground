import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

/**
 * A test class for customed stack and queue.
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-11-15 1:47 AM
 */
public class TestForStackAndQueue {

    @Test
    public void testStack() {
        StackInterface<String> stack = new ArrayStack<>(3);
        stack.push("1");
        assertEquals(stack.peek(), "1");
        stack.push("2");
        assertEquals(stack.pop(), "2");
        assertEquals(stack.pop(), "1");
        assertEquals(stack.isEmpty(), true);
    }

    @Test
    public void testQueue() {
        QueueInterface<Integer> queue = new ArrayQueue<>(3);
        queue.enqueue(1);
        assertEquals((int)queue.peekFront() , 1);
        queue.enqueue(2);
        assertEquals((int)queue.dequeue(), 1);
        assertEquals((int)queue.peekFront() , 2);
        queue.enqueue(3);
        queue.enqueue(4);
        try {
            queue.enqueue(5);
        }catch (RuntimeException e) {
            assertEquals(e.getMessage(), "Queue is full");
        }
    }
}
