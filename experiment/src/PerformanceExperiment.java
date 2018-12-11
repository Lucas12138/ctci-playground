import org.junit.Test;

import java.util.Random;

/**
 * Run experiments, which are related to performance.
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-12-10 5:33 PM
 */
public class PerformanceExperiment extends Experiment {

    @Override
    @Test
    public void doExperiment() {
        Random random = new Random(12138);
        int[] arr = new int[10000000];
        for (int i = 0; i < arr.length; i += 1) {
            arr[i] = random.nextInt(Integer.MAX_VALUE);
        }

        System.out.println("Starting method1: ");
        long before = System.currentTimeMillis();
        for (int num : arr) {
            reverse1(num);
        }
        long after = System.currentTimeMillis();
        System.out.println("Method1 costs: " + (after - before) + "ms");

        System.out.println("Starting method2: ");
        before = System.currentTimeMillis();
        for (int num : arr) {
            reverse2(num);
        }
        after = System.currentTimeMillis();
        System.out.println("Method2 costs: " + (after - before) + "ms");
    }

    public int reverse1(int x) {
        long res = 0;
        while (x != 0) {
            res *= 10;
            res += x % 10;
            x /= 10;
        }

        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) res;
    }

    public int reverse2(int x) {
        long res = 0;
        while (x != 0) {
            res *= 10;
            res += x % 10;
            x /= 10;

            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) res;
    }
}
