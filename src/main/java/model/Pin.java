package model;

public class Pin {
    protected int value;
    private boolean isEvaluated;

    Pin() {
        isEvaluated = false;
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

    public void setAsEvaluated() {
        isEvaluated = true;
    }

    public boolean isEvaluated() {
        return isEvaluated;
    }

    @Override
    public boolean equals(Object o) {
        assert o instanceof Pin;
        return this.value == ((Pin) o).value;
    }
}
