import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Given 2 strings, write a method to decide if one is a permutation of the other.
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-10-10 1:44 AM
 */
public class CheckPermutation {

    public String sortAndCreateNewString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public boolean checkPermutation(String first, String second) {
        if (first == null || second == null || first.length() != second.length()) {
            return false;
        }

        return sortAndCreateNewString(first).equals(sortAndCreateNewString(second));
    }

    @Test
    public void test() {
        CheckPermutation checkPermutation = new CheckPermutation();
        assertEquals(checkPermutation.checkPermutation(null, "a"), false);
        assertEquals(checkPermutation.checkPermutation("ba", "ab"), true);
        assertEquals(checkPermutation.checkPermutation("aa", "a"), false);
    }
}
