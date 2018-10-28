import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * compress a string. e.g. "aaabb" will be compressed to "a3b2"
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-10-27 1:20 AM
 */
public class StringCompression {

    String compress(String str) {
        StringBuilder strBuilder = new StringBuilder();
        int count = 1;
        for (int i = 0; i < str.length(); i += 1) {
            if ((i + 1) < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                count += 1;
            }else {
                strBuilder.append(str.charAt(i));
                strBuilder.append(count);
                count = 1;
            }
        }
        return strBuilder.toString();
    }

    @Test
    public void test() {
        assertEquals("a3b2c2", compress("aaabbcc"));
    }

}
