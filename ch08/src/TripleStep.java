import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time. Implement a method to count how many possible ways the child can run up the stairs.
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-10-12 1:50 PM
 */
public class TripleStep {


    public int countWays(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return countWays(n, memo);
    }

    public int countWays(int n, int[] memo) {
        if (n < 0) {
            return 0;
        }else if (n == 0) {
            // assume f(0) == 1 is more easier (save addtional cases to check)
            return 1;
        }else if (memo[n] > -1) {
            return memo[n];
        }else {
            memo[n] = countWays(n-1, memo) + countWays(n-2, memo) + countWays(n-3, memo);
            return memo[n];
        }
    }

    @Test
    public void test() {
        assertEquals(countWays(1), 1);
        assertEquals(countWays(2), 2);
        assertEquals(countWays(3), 4);
        assertEquals(countWays(4), 7);
    }

}
