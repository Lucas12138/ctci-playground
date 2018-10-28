import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Given a pre-defined method, isSubstring(a,b), which will check if string b is a substring of a. Now, given 2 strings, check if one is another's rotation.
 * e.g. "hello" is a rotation of "llohe"
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-10-28 2:37 PM
 */
public class StringRotation {

    private final boolean isSubstring(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() == 0) {
            return false;
        }
        if (s2.length() > s1.length()) {
            return false;
        }

        for (int i = 0; i <= s1.length() - s2.length(); i += 1) {
            if (s1.substring(i).contains(s2)) {
                return true;
            }
        }
        return false;
    }


    // let s1=xy and assume s2 is a rotation, then they should satisfy the following condistions:
    // 1. s1.length() == s2.length()
    // 2. yx is always a substring of xyxy (s1s1)
    boolean isRotation(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        return isSubstring(s1+s1, s2);
    }


    @Test
    public void preTest() {
        assertEquals(isSubstring("", ""), false);
        assertEquals(isSubstring("abdg", "bd"), true);
        assertEquals(isSubstring("abd", "cb"), false);
    }

    @Test
    public void test() {
        assertEquals(isRotation("hello", "llohe"), true);
        assertEquals(isRotation("hello", "lle"), false);
        assertEquals(isRotation("hello", ""), false);
        assertEquals(isRotation("hello", "lllhe"), false);
    }
}
