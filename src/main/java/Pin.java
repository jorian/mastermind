public class Pin {
    private int value;

    Pin() {

    }

    void setValue(int value) {
        if (value >= 1 && value <= 8) {
            this.value = value;
        } else
            throw new IllegalArgumentException();
    }

    int getValue() {
        return value;
    }
}
