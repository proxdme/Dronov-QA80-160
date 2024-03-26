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
        Player player1 = new Player(1, "Игрок1", 100);
        Player player2 = new Player(2, "Игрок2", 90);

        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(player1, game.findByName("Игрок1"));

    }

    @Test
    public void shouldTestUnregisterPlayer() {
        Game game = new Game();


        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Игрок1", "Игрок2");
        });
    }

    @Test
    public void shouldTestPlayerWhoWin() throws NotRegisteredException {
        Game game = new Game();
        Player player1 = new Player(1, "Игрок1", 100);
        Player player2 = new Player(2, "Игрок2", 90);

        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(1, game.round("Игрок1", "Игрок2"));
    }

    @Test
    public void shouldTestPlayerWhoLost() {
        Game game = new Game();
        Player player1 = new Player(1, "Игрок1", 90);
        Player player2 = new Player(2, "Игрок2", 100);

        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(2, game.round("Игрок1", "Игрок2"));
    }

    @Test
    public void shouldTestDrawGame() {
        Game game = new Game();
        Player player1 = new Player(1, "Игрок1", 100);
        Player player2 = new Player(2, "Игрок2", 100);

        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(0, game.round("Игрок1", "Игрок2"));
    }

    @Test
    public void shouldTestSecondPlayerUnregistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Игрок1", 100);

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Игрок1", "Игорок2");
        });
    }

    @Test
    public void shouldTestRegisterNewPlayer() {
        Game game = new Game();
        Player player1 = new Player(1, "Игорок1", 100);

        game.register(player1);
        Player expectedPlayer = game.findByName("Игорок1");
        Assertions.assertEquals(player1, expectedPlayer);
    }

}

