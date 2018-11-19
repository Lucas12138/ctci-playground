import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A singly linked list where the next reference of tail is set to the head of the list
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-11-06 6:43 PM
 */
public class CircularLinkedList<AnyType> {

    //TODO: implement other LL methods

    private Node<AnyType> tail;
    private int size;

    public CircularLinkedList() {
        tail = null;
        size = 0;
    }

    private static class Node<AnyType> {
        private AnyType data;
        private Node<AnyType> next;

        // this node's next node will be n
        Node(AnyType d, Node<AnyType> n) {
            data = d;
            next = n;
        }
    }

    public void addFirst(AnyType item) {
        if (size == 0) {
            tail = new Node<AnyType>(item, null);
            tail.next = tail;
        }else {
            // tail.next <==> head
            Node<AnyType> newNode = new Node<>(item, tail.next);
            tail.next = newNode;
        }
        size += 1;
    }

    public AnyType removeFirst() {
        if (size == 0) {
            return null;
        }

        Node<AnyType> head = tail.next;

        if (head == tail) {
            tail = null;
        }else {
            tail.next = head.next;
        }

        size -= 1;
        return head.data;
    }

    @Test
    public void test() {
        CircularLinkedList<Integer> cll = new CircularLinkedList<>();
        cll.addFirst(1);
        cll.addFirst(2);
        cll.addFirst(3);
        cll.addFirst(4);
        assertEquals(new Integer(4), cll.removeFirst());
        cll.addFirst(5);
        assertEquals(new Integer(5), cll.removeFirst());
        assertEquals(new Integer(3), cll.removeFirst());
        assertEquals(new Integer(2), cll.removeFirst());
        assertEquals(new Integer(1), cll.removeFirst());
    }
}
