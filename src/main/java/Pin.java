public class Pin {
    private int value;

    Pin() {

    }

    public void setValue(int value) {
        if (value > 0) {
            this.value = value;
        } else
            throw new IllegalArgumentException();
    }

    public int getValue() {
        return value;
    }
}
