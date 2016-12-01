package it.esteco.bowling;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameScoreTest {

    @Test
    public void gutterGame() throws Exception {
        Game game = new Game();
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }
        assertEquals(0, game.score());
    }

    @Test
    public void allOnes() throws Exception {
        Game game = new Game();

        for (int i = 0; i < 20; i++) {
            game.roll(1);
        }

        assertEquals(20, game.score());
    }
}
