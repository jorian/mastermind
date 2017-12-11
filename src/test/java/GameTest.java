import model.Code;
import model.Game;
import model.Score;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void newGameShouldHaveSecretCodeSet() {
        Game game = new Game();
        assertNotNull(game.getSecretCode());
    }

    @Test
    public void eachNewSecretCodeShouldBeRandom() {
        Game game = new Game();
        game.setSecretCode(game.generateRandomCode());
        Code firstCode = game.getSecretCode();

        game.setSecretCode(game.generateRandomCode());
        Code secondCode = game.getSecretCode();

        assertFalse(firstCode.equals(secondCode));
    }

    @Test(expected = IllegalStateException.class)
    public void gameCannotHaveMoreThanTwelveRounds() {
        Game game = new Game();

        for (int i = 0; i <= 13; i++) { //play 14 rounds
            Code code = new Code();
            code.set("1234");
            game.evaluateGuess(code);
        }
    }

    @Test(expected = IllegalStateException.class)
    public void scoreCannotHaveMoreThanFourScorePins() {
        Score score = new Score();
        score.addPin(0);
        score.addPin(1);
        score.addPin(1);
        score.addPin(0);
        score.addPin(1);

    }

    @Test
    public void scoreShouldReturnOneWhitePin() {
        Game game = new MockGame();

        Code guessCode = new Code();
        guessCode.set("4567");

        Score expected = new Score();
        expected.addPin(0);

        Score actual = game.evaluateGuess(guessCode);

        assertTrue(expected.equals(actual));
    }

    class MockGame extends Game {

        @Override
        public void setSecretCode(Code secret) {
            Code code = new Code();
            code.set("1234");
            this.secretCode = code;
        }
    }
}
