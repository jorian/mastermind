import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PinTest {

    @Test
    public void testPinValue() {
        Pin pin = new Pin();
        pin.setValue(4);

        assertEquals(4, pin.getValue());
    }
}
