public class Game {
    private Code secretCode;

    Game() {
        Code code = new Code();
        code.set("4567");
        this.secretCode = code;
    }

    public Code getSecretCode() {
        return secretCode;
    }

    public void setSecretCode() {
        Code code = new Code();
        code.set("4567");
        this.secretCode = code;
    }
}
