public class Code {
    private Pin[] code;

    Code() {

    }

    void set(String codeString) {
        code = new Pin[4];
        char[] codeChars = codeString.toCharArray();

        for (int i = 0; i < code.length; i++) {
            code[i] = new Pin();
            code[i].setValue(Character.getNumericValue(codeChars[i]));
        }
    }

    public Pin[] get() {
        return code;
    }
}
