import java.util.HashMap;
import java.util.Map;

/**
 * Run some experiments here
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-10-31 1:24 PM
 */
public class Experiment {


    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.putIfAbsent(1, map.get(1) + 1);
        for (Integer i : map.keySet()) {
            System.out.println(i + ": " + map.get(i));
        }
    }
}
