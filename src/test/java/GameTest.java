import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

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
}
