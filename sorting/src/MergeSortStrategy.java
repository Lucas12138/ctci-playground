/**
 * http://www.lucas-liu.com
 *
 * Merge Sort:
 * <1> sort the first half
 * <2> sort the second half
 * <3> merge 2 sorted parts together
 *
 * Time complexity:
 * best => Ω(nlogn)
 * average => Θ(nlogn)
 * worst => O(nlogn)
 *
 * Stability: Y
 *
 * @author lucas
 * @create 2018-12-13 8:01 AM
 */
public class MergeSortStrategy implements GenericStrategy {

    @Override
    public void sort(int[] data) {
        mergeSort(data, new int[data.length], 0, data.length - 1);
    }

    private void mergeSort(int[] from, int[] to, int left, int right) {
        // base case
        if (left >= right) {
            return;
        }

        // recursive case
        // find midpoint
        int mid = left + (right - left) / 2;
        // sort left half recursively
        mergeSort(from, to, left, mid);
        // sort right half recursively
        mergeSort(from, to, mid + 1, right);
        // merge them
        merge(from, to, left, mid + 1, right);
    }

    private void merge(int[] from, int[] to, int leftPos, int rightPos, int rightBound) {
        // upper bound of left half
        int leftBound = rightPos-1;
        // index of to array, starting point of left half
        int toIndex = leftPos;
        // total number of items to examine
        int numOfItems = rightBound - leftPos + 1;

        // both left half and right half have items
        while (leftPos <= leftBound && rightPos <= rightBound) {
            if (from[leftPos] <= from[rightPos]) {
                to[toIndex++] = from[leftPos++];
            }else {
                to[toIndex++] = from[rightPos++];
            }
        }

        // copy rest of left half
        while (leftPos <= leftBound) {
            to[toIndex++] = from[leftPos++];
        }

        // copy rest of right half
        while (rightPos <= rightBound) {
            to[toIndex++] = from[rightPos++];
        }

        // post process that needs to be done
        for (int i = 0; i < numOfItems; i++, rightBound--) {
            from[rightBound] = to[rightBound];
        }
    }
}
