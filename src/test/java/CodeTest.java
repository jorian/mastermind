import org.junit.Test;

import static org.junit.Assert.assertEquals;

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

}
