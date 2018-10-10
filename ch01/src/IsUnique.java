import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-10-10 1:11 AM
 */
public class IsUnique {

    // TOOO: consider without using array (bit manipulation)
    public boolean isUnique(String input) {
        if (input == null || input.length() == 0) {
            return false;
        }

        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length - 1; i += 1) {
            if (chars[i+1] == chars[i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        IsUnique isUnique = new IsUnique();
        assertEquals(isUnique.isUnique("a"), true);
        assertEquals(isUnique.isUnique("ab"), true);
        assertEquals(isUnique.isUnique("aa"), false);
    }
}
