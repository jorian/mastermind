import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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


        Pin pin3 = new Pin();
        pin3.setValue(3);

        assertNotEquals(pin1, pin3);
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


    @Test(expected = IllegalArgumentException.class)
    public void scorePinShouldNotHaveValueHigherThanOne() {
        ScorePin scorePin = new ScorePin();
        scorePin.set(2);
    }
}
