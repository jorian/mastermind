public class Pin {
    protected int value;

    Pin() {

    }

    void setValue(int value) {
        if (value >= 1 && value <= 8) {
            this.value = value;
        } else
            throw new IllegalArgumentException("pin value must be between 1 and 8 inclusive");
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
