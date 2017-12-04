import java.util.Random;

public class Game {
    protected Code secretCode;
    private int round;

    Game() {
        setSecretCode(generateRandomCode());
        round = 0;
    }

    public Code getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(Code secret) {
        this.secretCode = secret;
    }

    public Code generateRandomCode() {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int j = 1 + rnd.nextInt(8);
            sb.append(j);
        }

        Code code = new Code();
        code.set(sb.toString());

        return code;
    }

    /*
    Evaluates the guess with the secretcode. Returns the Score containing the right amount of ScorePins.
     */
    public Score evaluateGuess(Code guess) {
        if (round <= 12) {
            Score result = new Score();

            /*
            First, we check direct equality per pin, to determine whether a pin in the guessed code is equal AND
            on the same place as the pin in the secret code.
             */
            for (int i = 0; i < 4; i++) {
                Pin guessPin = guess.get()[i];
                Pin secretPin = secretCode.get()[i];

                if (guessPin.equals(secretPin)) {
                    secretPin.setAsEvaluated();
                    result.addPin(1);
                }
            }

            /*
            Since the above code has already checked pins for their exact value and position, we now have to check
            whether a pin in the guessed code exists in the secret code, but is not on the same place.

             */

            for (int i = 0; i < 4; i++) {
                Pin secretPin = secretCode.get()[i];

                if (!secretPin.isEvaluated()) {
                    for (int j = 0; j < 4; j++) {
                        Pin guessPin = guess.get()[j];

                        if (guessPin.equals(secretPin)) {
                            result.addPin(0);
                            secretPin.setAsEvaluated();
                        }
                    }
                }


            }
            round++;
            return result;
        } else
            throw new IllegalStateException("game cannot have more than 12 rounds");
    }
}
