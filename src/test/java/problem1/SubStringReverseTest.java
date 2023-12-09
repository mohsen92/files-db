package problem1;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SubStringReverseTest {

    SubStringReverse subStringReverse = new SubStringReverse('(', ')');

    @Test
    public void test1() {
        String input = "abd(jnb)asdf";

        assertEquals("abd(bnj)asdf", subStringReverse.reverseParenthesesSubString(input));
    }

    @Test
    public void test2() {
        String input = "abdjnbasdf";

        assertEquals("abdjnbasdf", subStringReverse.reverseParenthesesSubString(input));
    }

    @Test
    public void test3() {
        String input = "dd(df)a(ghhh)";

        assertEquals("dd(fd)a(hhhg)", subStringReverse.reverseParenthesesSubString(input));
    }
}
