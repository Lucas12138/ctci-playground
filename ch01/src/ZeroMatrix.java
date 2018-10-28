import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

/**
 * Given a M*N matrix, if matrix[i][j] is zero, make the row i and col j all zeros. Try not using extra space
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-10-28 2:24 PM
 */
public class ZeroMatrix {

    public void setZeroes(int[][] matrix) {
        // use first row and first col to track the zero occurrence
        // check first row and col first, because they're overlapped
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;
        for (int j = 0; j < matrix[0].length; j += 1) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }
        for (int i = 0; i < matrix.length; i += 1) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        // track zeros
        for (int i = 1; i < matrix.length; i += 1) {
            for (int j = 1; j < matrix[0].length; j += 1) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // nullify the rows
        for (int i = 1; i < matrix.length; i += 1) {
            if (matrix[i][0] == 0) {
                nullifyRow(matrix, i);
            }
        }

        // nullify the cols
        for (int j = 1; j < matrix[0].length; j += 1) {
            if (matrix[0][j] == 0) {
                nullifyCol(matrix, j);
            }
        }

        // nullify first row and col
        if (firstRowHasZero) {
            nullifyRow(matrix, 0);
        }
        if (firstColHasZero) {
            nullifyCol(matrix, 0);
        }
    }

    void nullifyRow(int[][] matrix, int rowIndex) {
        for (int j = 0; j < matrix[0].length; j += 1) {
            matrix[rowIndex][j] = 0;
        }
    }

    void nullifyCol(int[][] matrix, int colIndex) {
        for (int i = 0; i < matrix.length; i += 1) {
            matrix[i][colIndex] = 0;
        }
    }


    @Test
    public void test() {
        int[][] matrix = {{0,1},{1,1}};
        int[][] expectedMatrix = {{0,0},{0,1}};
        setZeroes(matrix);
        assertEquals(testHelper(matrix), testHelper(expectedMatrix));
    }

    public String testHelper(int[][] matrix) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(matrix).forEach(row -> stringBuilder.append(Arrays.toString(row)));
        return stringBuilder.toString();
    }

}
