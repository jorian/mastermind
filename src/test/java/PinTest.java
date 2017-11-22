import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PinTest {

    @Test
    public void testPinValue() {
        Pin pin = new Pin();
        pin.setValue(4);

        assertEquals(4, pin.getValue());
    }

    @Test
    public void testPinEquality() {
        Pin pin1 = new Pin();
        pin1.setValue(1);

        Pin pin2 = new Pin();
        pin2.setValue(1);

        assertEquals(pin1, pin2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativePinValueShouldThrowException() {
        Pin pin = new Pin();
        pin.setValue(-4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pinValueZeroShouldThrowException() {
        Pin pin = new Pin();
        pin.setValue(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pinValueHigherThanEightShouldThrowException() {
        Pin pin = new Pin();
        pin.setValue(9);
    }
}
