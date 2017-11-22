public class Pin {
    private int value;

    Pin() {

    }

    public void setValue(int value) {
        if (value >= 1 && value <= 8) {
            this.value = value;
        } else
            throw new IllegalArgumentException();
    }

    public int getValue() {
        return value;
    }
}
