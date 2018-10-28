import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

/**
 * Given a N*N matrix of integers, rotate it by 90 degrees clockwise
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-10-28 12:48 AM
 */
public class RotateMatrix {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length != matrix.length) {
            return;
        }

        int n = matrix.length;
        // from outer layer to inner layer
        for (int layer = 0; layer < n / 2; layer += 1) {
            int first = layer;
            int last = n - 1 - first;
            for (int i = first; i < last; i += 1) {
                int offset = i - first;
                int top = matrix[first][i];
                matrix[first][i] = matrix[last - offset][first]; // top <= left
                matrix[last - offset][first] = matrix[last][last - offset]; // left <= bottom
                matrix[last][last - offset] = matrix[first + offset][last]; // bottom <= right
                matrix[first + offset][last] = top; // right <= top
            }
        }
    }

    @Test
    public void test () {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        int[][] expectedMatrix = new int[][]{{7,4,1},{8,5,2},{9,6,3}};
        assertEquals(testHelper(matrix), testHelper(expectedMatrix));
    }

    public String testHelper(int[][] matrix) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(matrix).forEach(row -> stringBuilder.append(Arrays.toString(row)));
        return stringBuilder.toString();
    }
}
