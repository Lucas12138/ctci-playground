import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Given a string, check if it is a permutation of a palindrome. It's fine to ignore the none letter characters. It's not case-sensitive.
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-10-26 11:40 PM
 */
public class PalindromePermutation {

    boolean isPermutationOfPalindrome(String phrase) {
        // keep track of odd char count
        int oddCharCount = 0;
        // use an array to maintain the counts
        // TODO: consider a integer instead of an array (bitwise representation can save space)
        int[] table = new int['z' - 'a' + 1];


        char[] phraseChars = phrase.toLowerCase().toCharArray();
        for (char c : phraseChars) {
            if (isInBound(c)) {
                int index = getCharIndex(c);
                table[index] += 1;
                if (table[index] % 2 == 0) {
                    oddCharCount -= 1;
                } else {
                    oddCharCount += 1;
                }
            }
        }
        return oddCharCount <= 1;
    }

    int getCharIndex(char c) {
        return c - 'a';
    }

    boolean isInBound(char c) {
        return getCharIndex(c) >= 0 && getCharIndex(c) < ('z' - 'a' + 1);
    }

    @Test
    public void test() {
        assertEquals(isPermutationOfPalindrome("Tact Coa *&"), true);
    }

}
