import java.util.Random;

public class Game {
    protected Code secretCode;
    private int round;

    Game() {
        setSecretCode();
        round = 0;
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

        Code code = new Code();
        code.set(sb.toString());

        this.secretCode = code;
    }

    /*
    Evaluates the guess with the secretcode. Returns true if equal, false if not equal.
     */
    public Score evaluateGuess(Code guess) {
        if (round <= 12) {
            Score result = new Score();

            for (int i = 0; i < 4; i++) {
                Pin guessPin = guess.get()[i];
                Pin secretPin = secretCode.get()[i];

                if (guessPin.equals(secretPin)) {
                    secretPin.setAsEvaluated();
                    result.addPin(1);
                }
            }



            result.addPin(0);
            round++;
            return result;
        } else
            throw new IllegalStateException("game cannot have more than 12 rounds");
    }
}
