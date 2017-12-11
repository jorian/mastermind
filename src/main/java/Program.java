import controller.PlayGame;
import model.Game;
import view.Console;

public class Program {
    public static void main(String[] args) {
        Game game = new Game();
        Console view = new Console();
        PlayGame controller = new PlayGame();

        controller.play(game,view);
    }
}
