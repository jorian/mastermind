import java.util.Random;

public class Game {
    private Code secretCode;

    Game() {
        setSecretCode();
    }

    public Code getSecretCode() {
        return secretCode;
    }

    public void setSecretCode() {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int j = 1 + rnd.nextInt(8);
            sb.append(j);
        }
        System.out.println(sb.toString());

        Code code = new Code();
        code.set(sb.toString());

        this.secretCode = code;
    }
}
