import org.junit.Test;

import static org.junit.Assert.*;

public class EvaluationTest {
    /*
    This test class tests several evaluations of guessed codes with secret code. Each test has an explanation
    in comments to clarify what situation is tested. This in order to prevent very long method names.
     */


    @Test
    public void case_1() {
        /*
        The score should have 1 red pin and 1 white pin.

        secret code:  1234
        guessed code: 1546

        '1' is on the same position, '4' is in the secret code but not on the same place.
         */

        String guessString = "1546";
        Score expected = new Score();
        expected.addPin(1);
        expected.addPin(0);

        Game game = new MockGame();
        game.setSecretCode();

        Code guess = new Code();
        guess.set(guessString);

        Score actual = game.evaluateGuess(guess);

        assertEquals(expected, actual);
    }

    class MockGame extends Game {

        @Override
        public void setSecretCode() {
            Code code = new Code();
            code.set("1234");
            this.secretCode = code;
        }
    }
}
