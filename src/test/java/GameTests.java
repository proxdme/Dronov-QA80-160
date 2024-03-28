import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Game;
import ru.netology.NotRegisteredException;
import ru.netology.Player;

import java.util.ArrayList;
import java.util.List;

public class GameTests {
    @Test
    public void shouldTestRegisteredPlayer() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 100);
        Player player2 = new Player(2, "Player2", 90);

        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(player1, game.findByName("Player1"));

    }

    @Test
    public void shouldTestUnregisterPlayer() {
        Game game = new Game();


        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Player1", "Player2");
        });
    }

    @Test
    public void shouldTestPlayerWhoWin() throws NotRegisteredException {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 100);
        Player player2 = new Player(2, "Player2", 90);

        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(1, game.round("Player1", "Player2"));
    }

    @Test
    public void shouldTestPlayerWhoLost() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 90);
        Player player2 = new Player(2, "Player2", 100);

        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(2, game.round("Player1", "Player2"));
    }

    @Test
    public void shouldTestDrawGame() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 100);
        Player player2 = new Player(2, "Player2", 100);

        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(0, game.round("Player1", "Player2"));
    }

    @Test
    public void shouldTestSecondPlayerUnregistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 100);

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Player1", "Player2");
        });
    }

    @Test
    public void shouldTestRegisterNewPlayer() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 100);

        game.register(player1);
        Player expectedPlayer = game.findByName("Player1");
        Assertions.assertEquals(player1, expectedPlayer);
    }

}

