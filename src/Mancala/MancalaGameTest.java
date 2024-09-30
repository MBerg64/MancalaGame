package Mancala;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MancalaGameTest {

    private MancalaGame game;
    private Player player1;
    private Player player2;

    @BeforeEach
    public void setUp() {
        player1 = new Player("Alice");
        player2 = new Player("Bob");
        game = new MancalaGame("Alice", "Bob");
    }
    
    @Test
    public void testAddPebblesToStore() {
    	assertEquals(player1.getStore().getPebbles(), 0);
    	player1.getStore().addPebbles(1);
    	assertEquals(player1.getStore().getPebbles(), 1);
    }
    
    @Test
    public void testWinner() {
    	player1.getStore().setPebbles(29);
    	player2.getStore().setPebbles(45);
    	assertTrue(player2.getStore().getPebbles() > player1.getStore().getPebbles());
    	player1.getStore().setPebbles(45);
    	player2.getStore().setPebbles(39);
    	assertTrue(player1.getStore().getPebbles() > player2.getStore().getPebbles());
    	player1.getStore().setPebbles(45);
    	player2.getStore().setPebbles(45);
    	assertTrue(player2.getStore().getPebbles() == player1.getStore().getPebbles());

    }
}

