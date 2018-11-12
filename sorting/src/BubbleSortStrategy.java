/**
 * Contains the bubble sort method, which:
 * 1. compare 2 values at a time
 * 2. if one on the left is larger, swap them to bubble up the larger value to the right
 * 3. move one position to the right
 *
 * On average:
 * Number of comparisons: n^2 / 2
 * Number of swaps: n^2 / 4
 *
 * Time complexity:
 * best => Ω(n)
 * average => Θ(n^2)
 * worst => O(n^2)
 *
 * Space complexity:
 * worst => O(1)
 *
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-11-12 12:21 PM
 */
public class BubbleSortStrategy implements GenericStrategy{

    private void swap(int[] data, int x, int y) {
        int tmp = data[x];
        data[x] = data[y];
        data[y] = tmp;
    }

    @Override
    public void sort(int[] data) {
        for (int right = data.length - 1; right >= 1; right -= 1) {
            for (int left = 0; left < right; left += 1) {
                if (data[left] > data[right]) {
                    swap(data, left, right);
                }
            }
        }
    }
}
