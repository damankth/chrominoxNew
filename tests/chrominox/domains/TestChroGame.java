package chrominox.domains;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

//import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestChroGame {

  //  private ChroGame game;

   
    @Test
    public void testGameInitialization() {
    	ChroGame game = new ChroGame(List.of("Alice", "Bob"));
        assertNotNull(game.getChroBag());
        assertNotNull(game.getChromosaic());
        assertNotNull(game.getFirstChromino());
       // assertEquals(2, game.getJoueur1().getChrominosInHand().size() + game.getJoueur2().getChrominosInHand().size());
    }

    @Test
    public void testWhoStarts() {
    	
    	ChroGame game = new ChroGame(List.of("Alice", "Bob"));
        int starter = game.whoStarts();
        assertTrue(starter == 0 || starter == 1);
    }

    

    @Test
    public void testDrawChromino() {
    	ChroGame game = new ChroGame(List.of("Alice", "Bob"));
        Chromino drawn = game.getdrawChromino();
        assertNotNull(drawn);
    }


}
