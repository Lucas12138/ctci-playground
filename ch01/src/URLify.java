import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * replace all spaces in a string with '%20'
 * http://www.lucas-liu.com
 *
 * input: "Mr John Smith   ", 13
 * output: "Mr%20John%20Smith"
 *
 * @author lucas
 * @create 2018-10-26 11:24 PM
 */
public class URLify {

    public String replaceSpaces(String str, int trueLength) {
        return str.trim().replace(" ", "%20");
    }

    @Test
    public void test() {
        assertEquals(replaceSpaces("Mr John Smith   ", 13), "Mr%20John%20Smith");
    }

}
