import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class GameTest {

    @Test
    public void gameShouldHaveSecretCodeSet() {
        Game game = new Game();
        assertNotNull(game.getSecretCode());
    }
}
