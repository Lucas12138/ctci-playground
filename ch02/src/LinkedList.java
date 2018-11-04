import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Implementation for LinkedList
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-11-02 1:44 PM
 */
public class LinkedList<AnyType> {

    private static class Node<AnyType> {
        private AnyType data;
        private Node<AnyType> next;

        // this node's next node will be n
        Node(AnyType d, Node<AnyType> n) {
            data = d;
            next = n;
        }
    }

    private Node<AnyType> head;

    public LinkedList() {
        head = null;
    }

    public void addFirst(AnyType item) {
        head = new Node<AnyType>(item, head);
    }

    public void addLast(AnyType item) {
        if (head == null) {
            addFirst(item);
        }

        Node<AnyType> tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }

        tmp.next = new Node<AnyType>(item, null);
    }

    public void insertAfter(AnyType key, AnyType item) {
        Node<AnyType> tmp = head;
        while (tmp != null && !tmp.data.equals(key)) {
            tmp = tmp.next;
        }

        if (tmp != null) {
            tmp.next = new Node<AnyType>(item, tmp.next);
        }
    }

    public void insertBefore(AnyType key, AnyType item) {
        if (head == null) {
            return;
        }

        if (head.data.equals(key)) {
            addFirst(item);
            return;
        }

        Node<AnyType> pre = null;
        Node<AnyType> cur = head;

        while (cur != null && !cur.data.equals(key)) {
            pre = cur;
            cur = cur.next;
        }

        if (cur != null) {
            pre.next = new Node<AnyType>(item, pre.next);
        }
    }

    /**
     * Simiar with Delete Middle Node
     */
    public void remove(AnyType key) {
        if (head == null) {
            return;
        }

        if (head.data.equals(key)) {
            head = head.next;
            return;
        }

        Node<AnyType> pre = null;
        Node<AnyType> cur = head;

        while (cur != null && !cur.equals(key)) {
            pre = cur;
            cur = cur.next;
        }

        if (cur != null) {
            pre.next = cur.next;
        }
    }

    @Test
    public void test() {
        LinkedList<String> ll = new LinkedList<>();
        ll.addFirst("2");
        ll.addFirst("1");
        ll.addLast("4");
        ll.insertAfter("2", "3");
        ll.insertBefore("1", "0");
        ll.remove("5");
        Node<String> head = ll.head;
        for (int i = 0; i < 5; i += 1) {
            assertEquals(String.valueOf(i), head.data);
            head = head.next;
        }
    }
}
