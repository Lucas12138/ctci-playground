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
 * *notice, to achieve Ω(n), an extra control flag is needed
 * (https://www.geeksforgeeks.org/bubble-sort/)
 * (https://stackoverflow.com/questions/12505832/why-is-the-time-complexity-of-bubble-sorts-best-case-being-on)
 * average => Θ(n^2)
 * worst => O(n^2)
 *
 * Space complexity:
 * worst => O(1)
 *
 * Stability: Y
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
        // add this control flag to get best => Ω(n)
        boolean swapped;
        for (int right = data.length - 1; right >= 1; right -= 1) {
            swapped = false;
            for (int left = 0; left < right; left += 1) {
                if (data[left] > data[left + 1]) {
                    swap(data, left, left + 1);
                    swapped = true;
                }
            }

            // if no swap => it's a sorted array => break
            if (!swapped) {
                break;
            }
        }
    }
}
