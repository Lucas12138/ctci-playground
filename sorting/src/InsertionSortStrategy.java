/**
 * Contains the insertion sort method, which:
 * 1. use a imaginary dividing line
 * 2. left-hand side of the line is sorted among themselves
 * 3. the first element of the right-hand side of the line should be inserted into the left-hand side in a proper position
 * 3.1 keep the value of the first element in a temp place
 * 3.2 shift the items of the left-hand side to the right, so that we have space for the value
 * 3.3 when the position is found, insert the value into that position
 * (faster than bubble sort and selection sort)
 *
 * On average:
 * Number of comparisons: n^4 / 4
 * Number of swaps: 0
 * Number of shift: n^4 / 4
 *
 * Time complexity:
 * best => Ω(n)
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
 * @create 2018-11-12 1:07 PM
 */
public class InsertionSortStrategy implements GenericStrategy{


    @Override
    public void sort(int[] data) {
        // right is the moving line
        for (int right = 1; right < data.length; right += 1) {
            int tmp = data[right];
            int left = right;
            while (left > 0 && data[left - 1] >= tmp) {
                // without tmp value, the original right value may be covered below
                data[left] = data[left - 1];
                left -= 1;
            }

            if (left != right) data[left] = tmp;
        }
    }
}
