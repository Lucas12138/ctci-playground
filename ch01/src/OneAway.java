import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * there're 3 types of edits to perform on strings: insert, delete, and replace (all for one single char). Check if it's only one edit away
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-10-27 12:32 AM
 */
public class OneAway {

    boolean oneEditAway(String first, String second) {
        // combine insert and delete to one case
        String shortStr = first.length() > second.length() ? second : first;
        String longStr = first.length() > second.length() ? first : second;

        if (longStr.length() - shortStr.length() >= 2) {
            return false;
        }

        int index1 = 0;
        int index2 = 0;
        boolean foundMoreThanOneDifferences = false;
        while (index1 < shortStr.length() && index2 < longStr.length()) {
            if (shortStr.charAt(index1) != longStr.charAt(index2)) {
                if (foundMoreThanOneDifferences) return false;
                foundMoreThanOneDifferences = true;

                if (shortStr.length() == longStr.length()) {
                    // case: replace (not moving index1 for case insert or delete)
                    index1 += 1;
                }
            } else {
                index1 += 1; // add one to short index if matches
            }
            index2 += 1; // add one to long index no matter what
        }
        return true;
    }

    @Test
    public void test() {
        assertEquals(oneEditAway("pale", "ple"), true);
        assertEquals(oneEditAway("pales", "pale"), true);
        assertEquals(oneEditAway("pale", "bale"), true);
        assertEquals(oneEditAway("pale", "bae"), false);
    }

}
