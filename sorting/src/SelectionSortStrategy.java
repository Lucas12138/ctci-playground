/**
 * Contains the bubble sort method, which:
 * 1. pick or select the minimum value
 * 2. swap it with element on the left end
 * (faster than bubble sort)
 *
 * On average:
 * Number of comparisons: n^2 / 2
 * Number of swaps: n / 2
 *
 * Time complexity:
 * best => Ω(n^2)
 * average => Θ(n^2)
 * worst => O(n^2)
 *
 * Space complexity:
 * worst => O(1)
 *
 * Stability: N
 * (https://stackoverflow.com/questions/20761396/why-selection-sort-can-be-stable-or-unstable)
 *
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-11-12 12:53 PM
 */
public class SelectionSortStrategy implements GenericStrategy{

    private void swap(int[] data, int x, int y) {
        int tmp = data[x];
        data[x] = data[y];
        data[y] = tmp;
    }

    @Override
    public void sort(int[] data) {
        int minIndex;
        for (int left = 0; left < data.length - 1; left += 1) {
            minIndex = left;
            for (int right = left + 1; right < data.length; right += 1) {
                if (data[right] < data[minIndex]) {
                    minIndex = right;
                }
            }

            if (left != minIndex) swap(data, left, minIndex);
        }
    }
}
