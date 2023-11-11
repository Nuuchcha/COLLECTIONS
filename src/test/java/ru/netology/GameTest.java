package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void strengthPlayersEqual() {
        Player player1 = new Player(1, "Женя", 200);
        Player player2 = new Player(2, "Сережа", 200);
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        int actual = game.round("Женя", "Сережа");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void fistPlayersWin() {
        Player player1 = new Player(1, "Женя", 200);
        Player player2 = new Player(2, "Сережа", 100);
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        int actual = game.round("Женя", "Сережа");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayersWin() {
        Player player1 = new Player(1, "Женя", 100);
        Player player2 = new Player(2, "Сережа", 200);
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        int actual = game.round("Женя", "Сережа");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayersNotRegistered() {
        Player player1 = new Player(1, "Женя", 100);
        Player player2 = new Player(2, "Сережа", 200);
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Леша", "Сережа"));
    }

    @Test
    public void secondPlayersNotRegistered() {
        Player player1 = new Player(1, "Женя", 100);
        Player player2 = new Player(2, "Сережа", 200);
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Женя", "Леша"));
    }
}
