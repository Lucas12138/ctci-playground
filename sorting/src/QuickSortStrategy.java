/**
 * http://www.lucas-liu.com
 *
 * Quick Sort:
 * <1> partition and get result index (the value in that index has reached final position)
 * <2> sort the left half
 * <3> sort the right half
 *
 * @author lucas
 * @create 2018-12-13 8:22 AM
 */
public class QuickSortStrategy implements GenericStrategy{


    @Override
    public void sort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }

    private void quickSort(int[] data, int left, int right) {
        // base case
        if (right - left <= 0) {
            return;
        }
        // Note: selection of pivot value makes a difference!!
        int pivot = data[right];
        int partition = partition(data, left, right, pivot);
        quickSort(data, left, partition - 1);
        quickSort(data, partition + 1, right);
    }

    private int partition(int[] data, int left, int right, int pivot) {
        int leftPointer = left - 1;
        int rightPointer = right;

        while (true) {
            while (data[++leftPointer] < pivot);
            while (rightPointer > 0 && data[--rightPointer] > pivot);
            if (leftPointer >= rightPointer) {
                break;
            }
            swap(data, leftPointer, rightPointer);
        }
        swap(data, leftPointer, right);
        return leftPointer;
    }

    private static void swap(int[] array, int one, int two) {
        int tmp = array[one];
        array[one] = array[two];
        array[two] = tmp;
    }
}
