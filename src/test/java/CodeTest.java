import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CodeTest {

    @Test
    public void codeExistsOfFourPins() {
        Code code = new Code();
        code.set("1234");

        assertEquals(4, code.get().length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void codeCannotBeSetWithEmptyValue() {
        Code code = new Code();
        code.set("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void codeCannotBeSetWithValueContainingMoreThanFourDigits() {
        Code code = new Code();
        code.set("12345");
    }

    @Test(expected = IllegalArgumentException.class)
    public void codeCannotBeSetWithThreeDigitValue() {
        Code code = new Code();
        code.set("123");
    }

    @Test
    public void testCodeEquality() {
        Code code1 = new Code();
        code1.set("1234");

        Code code2 = new Code();
        code2.set("1234");

        assertEquals(code1, code2);

        Code code3 = new Code();
        code3.set("5678");

        assertNotEquals(code1, code3);
    }

}
