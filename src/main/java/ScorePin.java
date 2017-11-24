public class ScorePin extends Pin {

    @Override
    void setValue(int value) {
        if (value >= 0 && value <= 1) {
            super.value = value;
        } else
            throw new IllegalArgumentException("scorepin only has 0 or 1 as value");
    }
}
