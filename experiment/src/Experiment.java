import java.util.*;
import java.util.stream.Collector;

/**
 * Run some experiments here
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-10-31 1:24 PM
 */
public class Experiment {



    static int someMethod(int a) {
        if (a == 0) {
            return 0;
        }

        return someMethod(a - 1) + a;
    }

    static int b = 0;
    static void someMethod2(int a) {
        if (a == 0) {
            return;
        }
        b += a;
        someMethod(a - 1);
    }


    public static void main(String[] args) {
        System.out.println(someMethod(5));
        int sum = 0;

        System.out.println(sum);
    }
}
