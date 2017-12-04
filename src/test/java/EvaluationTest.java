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

        assertTrue(actual.equals(expected));
    }

    @Test
    public void case_2() {
        /*
        The score should have 1 red pin and 2 white pins.

        secret code:  1234
        guessed code: 8241

        '1' is on the same position, '3' and '4' is in the secret code but not on the same place.
         */

        String guessString = "8241";
        Score expected = new Score();
        expected.addPin(1);
        expected.addPin(0);
        expected.addPin(0);

        Game game = new MockGame();
        game.setSecretCode();

        Code guess = new Code();
        guess.set(guessString);

        Score actual = game.evaluateGuess(guess);

        System.out.println("Actual:   " + actual.toString());
        System.out.println("Expected: " + expected.toString());

        assertTrue(actual.equals(expected));
    }

    @Test
    public void case_3() {
        /*
        The score should have 2 red pin and 2 white pins.

        secret code:  1234
        guessed code: 1324

        '1' and '4' is on the same position, '3' and '4' is in the secret code but not on the same place.
         */

        String guessString = "1324";
        Score expected = new Score();
        expected.addPin(1);
        expected.addPin(1);
        expected.addPin(0);
        expected.addPin(0);

        Game game = new MockGame();
        game.setSecretCode();

        Code guess = new Code();
        guess.set(guessString);

        Score actual = game.evaluateGuess(guess);

        System.out.println("Actual:   " + actual.toString());
        System.out.println("Expected: " + expected.toString());

        assertTrue(actual.equals(expected));
    }

    @Test
    public void case_4() {
        /*
        The score should have 1 red pin and 0 white pins.

        secret code:  1234
        guessed code: 7654

        '4' is on the same position, rest is not in secret code.
         */

        String guessString = "7654";
        Score expected = new Score();
        expected.addPin(1);

        Game game = new MockGame();
        game.setSecretCode();

        Code guess = new Code();
        guess.set(guessString);

        Score actual = game.evaluateGuess(guess);

        System.out.println("Actual:   " + actual.toString());
        System.out.println("Expected: " + expected.toString());

        assertTrue(actual.equals(expected));
    }

    @Test
    public void case_5() {
        /*
        The score should have 4 red pins and 0 white pins.

        secret code:  1234
        guessed code: 1234

        '4' is on the same position, rest is not in secret code.
         */

        String guessString = "1234";
        Score expected = new Score();
        expected.addPin(1);
        expected.addPin(1);
        expected.addPin(1);
        expected.addPin(1);

        Game game = new MockGame();
        game.setSecretCode();

        Code guess = new Code();
        guess.set(guessString);

        Score actual = game.evaluateGuess(guess);

        System.out.println("Actual:   " + actual.toString());
        System.out.println("Expected: " + expected.toString());

        assertTrue(actual.equals(expected));
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
