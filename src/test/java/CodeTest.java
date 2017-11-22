import org.junit.Test;

public class CodeTest {
    @Test
    public void codeExistsOfFourPins() {
        Code code = new Code();
        code.set("1234");

        assertEquals(4, code.get().length);
    }
}
