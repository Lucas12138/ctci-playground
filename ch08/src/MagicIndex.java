import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A magic index in an array A[1..n-1] is defined to be an index such that A[i] == i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists in array A. What if values are not distinct?
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-10-14 1:43 AM
 */
public class MagicIndex {

    public int magicFast(int[] array) {
        return magicFast(array, 0, array.length - 1);
    }

    public int magicFast(int[] array, int start, int end) {
        if (end < start) {
            return -1;
        }

        int midIndex = (start + end) / 2;
        if (array[midIndex] == midIndex) {
            return midIndex;
        }

        int leftIndex = Math.min(midIndex - 1, array[midIndex]);
        int left = magicFast(array, start, leftIndex);
        if (left >= 0) {
            return left;
        }

        int rightIndex = Math.max(midIndex + 1, array[midIndex]);
        int right = magicFast(array, rightIndex, end);
        if (right <= array.length - 1) {
            return right;
        }

        return -1;
    }

    @Test
    public void test() {
        int[] array1 = {-5, -1, 2};
        int[] array2 = {-5, 1, 4, 6};
        int[] array3 = {-5, 2, 4, 6};
        assertEquals(magicFast(array1), 2);
        assertEquals(magicFast(array2), 1);
        assertEquals(magicFast(array3), -1);
    }

}
