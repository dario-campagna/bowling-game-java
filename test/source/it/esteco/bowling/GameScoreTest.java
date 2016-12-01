package it.esteco.bowling;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameScoreTest {

    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            game.roll(pins);
        }
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    @Test
    public void gutterGame() throws Exception {
        rollMany(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    public void allOnes() throws Exception {
        rollMany(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    public void oneSpare() throws Exception {
        rollSpare();
        game.roll(4);
        rollMany(17, 0);
        assertEquals(18, game.score());
    }

    @Test
    public void oneStrike() throws Exception {
        rollStrike();
        game.roll(5);
        game.roll(6);
        rollMany(14, 0);
        assertEquals(32, game.score());
    }

    private void rollStrike() {
        game.roll(10);
    }
}
