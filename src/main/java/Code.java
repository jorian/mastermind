public class Code {
    private Pin[] code;

    Code() {

    }

    void set(String codeString) {
        code = new Pin[4];
        char[] codeChars = codeString.toCharArray();

        if (codeString.length() == 4) {
            for (int i = 0; i < code.length; i++) {
                code[i] = new Pin();
                code[i].setValue(Character.getNumericValue(codeChars[i]));
            }
        } else
            throw new IllegalArgumentException();
    }

    Pin[] get() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        assert o instanceof Code;
        Code other = ((Code) o);
        Pin[] otherPins = other.get();

        for (int i = 0; i < 4; i++) {
            if (code[i].getValue() != otherPins[i].getValue()) {
                return false;
            }
        }
        return true;
    }
}
