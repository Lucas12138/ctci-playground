import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Given a sorted (increasing order) array with unique integer elements, create a binary search tree with minimal height.
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-12-05 1:59 AM
 */
public class MinimalTree {

    private static class Node {
        private int value;
        private Node left, right;

        Node(int v) {
            value = v;
        }
    }

    public Node buildMinimalTree(int[] sortedArr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        Node n = new Node(sortedArr[mid]);
        n.left = buildMinimalTree(sortedArr, start, mid - 1);
        n.right = buildMinimalTree(sortedArr, mid + 1, end);
        return n;
    }

    @Test
    public void test() {
        int[] sortedArr = new int[]{1,2,3,4,5,6,7};

        Node root = buildMinimalTree(sortedArr, 0, sortedArr.length - 1);
        assertEquals(root.value, 4);
        assertEquals(root.left.value, 2);
        assertEquals(root.right.value, 6);
        assertEquals(root.left.left.value, 1);
        assertEquals(root.left.right.value, 3);
        assertEquals(root.right.left.value, 5);
        assertEquals(root.right.right.value, 7);
    }
}
