import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class GameTest {

    @Test
    public void newGameShouldHaveSecretCodeSet() {
        Game game = new Game();
        assertNotNull(game.getSecretCode());
    }

    @Test
    public void eachNewSecretCodeShouldBeRandom() {
        Game game = new Game();
        game.setSecretCode();
        Code firstCode = game.getSecretCode();

        game.setSecretCode();
        Code secondCode = game.getSecretCode();

        assertFalse(firstCode.equals(secondCode));
    }

    @Test(expected = IllegalStateException.class)
    public void gameCannotHaveMoreThanTwelveRounds() {
        Game game = new Game();

        for (int i = 0; i <= 13; i++) { //play 13 rounds
            Code code = new Code();
            code.set("1234");
            game.evaluateGuess(code);
        }
    }

    @Test
    public void guessCodeSameAsSecretCodeShouldEvaluateToTrue() {
        Game game = new MockGame();

        Code guess = new Code();
        guess.set("1234");

        assertTrue(game.evaluateGuess(guess));
    }

    @Test
    public void guessCodeIsNotSameAsSecretCodeShouldEvaluateToFalse() {
        Game game = new MockGame();

        Code guess = new Code();
        guess.set("1834");

        assertFalse(game.evaluateGuess(guess));
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
