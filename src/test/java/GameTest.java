import org.junit.Test;

public class GameTest {

    @Test
    public void gameShouldHaveSecretCodeSet() {
        Game game = new Game();
        assertNotNull(game.getSecretCode());
    }
}
