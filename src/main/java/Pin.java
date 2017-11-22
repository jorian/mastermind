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

    @Override
    public boolean equals(Object o) {
        assert o instanceof Pin;
        return this.value == ((Pin) o).value;
    }
}
