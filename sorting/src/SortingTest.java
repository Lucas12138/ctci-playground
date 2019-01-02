import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

/**
 * test class for different sorting strategies
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-11-12 12:23 PM
 */
public class SortingTest {

    private int[] data = {4,7,2,5,3};
    private int[] dataSorted = {2,3,4,5,7};

    @Test
    public void testBubbleSort() {
        GenericStrategy bubbleSortStrategy = new BubbleSortStrategy();
        bubbleSortStrategy.sort(data);
        assertEquals(Arrays.toString(data), Arrays.toString(dataSorted));
    }

    @Test
    public void testSelectionSort() {
        GenericStrategy selectionSortStrategy = new SelectionSortStrategy();
        selectionSortStrategy.sort(data);
        assertEquals(Arrays.toString(data), Arrays.toString(dataSorted));
    }

    @Test
    public void testInsertionSort() {
        GenericStrategy insertionSortStrategy = new InsertionSortStrategy();
        insertionSortStrategy.sort(data);
        assertEquals(Arrays.toString(data), Arrays.toString(dataSorted));
    }

    @Test
    public void testMergeSort() {
        GenericStrategy mergeSortStrategy = new MergeSortStrategy();
        mergeSortStrategy.sort(data);
        assertEquals(Arrays.toString(data), Arrays.toString(dataSorted));
    }

    @Test
    public void testQuickSort() {
        GenericStrategy quickSortStrategy = new QuickSortStrategy();
        quickSortStrategy.sort(data);
        assertEquals(Arrays.toString(data), Arrays.toString(dataSorted));
    }
}
