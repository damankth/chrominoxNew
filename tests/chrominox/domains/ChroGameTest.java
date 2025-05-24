package chrominox.domains;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChroGameTest {

	private ChroGame game;

    @BeforeEach
    public void setUp() {
        game = new ChroGame(List.of("Joueur1", "Joueur2"));
    }
	@Test
	void InitializeCameleonChromino() {
		
		Chromino first=game.getFirstChromino();
		game.intializeCamleonChromino();
		
	
		
	}
    @Test 
    void testJoueurName() {
    	assertEquals("Joueur1", game.getJoueur1().getName());
        assertEquals("Joueur2", game.getJoueur2().getName());
    }
	@Test
	void chroBagNotNull() {
		ChroGame chroGame=new ChroGame();
		assertNotNull(chroGame.getChroBag());
	}
	@Test
	void ChromosaicNotNull() {
		ChroGame chroGame=new ChroGame();
		assertNotNull(chroGame.getChromosaic());
	}
	
	//false
	@Test 
	void getTheCameleonChromino(){
		ChroGame chroGame=new ChroGame();
		Chromino firstCameleon= chroGame.getFirstChromino();
		assertEquals(TileType.CAMELEON, firstCameleon.getPart2());
		
	}
//	 @Test
//	    void testCreationOfPlayers() {
//	        assertEquals(2, chroGame.getPlayers().getMyHand().size());
//	    }
	
	//false
	@Test
	void testCreateHand() {
		ChroGame chroGame=new ChroGame();
		Set<Chromino>hand=chroGame.createHand();
		assertEquals(10, hand.size());
	}
	
	 
	  @Test
	   void testGameInitialization() {
	        ChroGame game = new ChroGame(List.of("Alice", "Bob"));
	        assertNotNull(game.getChroBag());
	        assertNotNull(game.getChromosaic());
	        assertNotNull(game.getFirstChromino());
	        
	    }
	  @Test
	  void testCurrentPlayerIsSet() {
	      ChroGame game = new ChroGame(List.of("Alice", "Bob"));
	      assertNotNull(game.getCurrentPlayer());
	  }

	  @Test
	  void whoStarts() {
		  int starter = game.whoStarts();
		  assertTrue(0==starter|| 1==starter);
		  
	  }
	   @Test 
	   void testNextTurn () {
		   Player player =game.getCurrentPlayer();
		  // int first= 
		   int next= game.nextTurn();
		   
	   }
	   @Test 
	   void testcreatePlateau() {
		   Chromosaic  mosaic= game.createPlateau();
		   assertNotNull(mosaic);
		   
	   }
	   @Test 
	   void testChrominoAndCoordinate() {
		   Chromino c=game.getdrawChromino();
		   Coordinate co=new Coordinate(2,3);
		   game.selectedChromino(c);
		   game.selectPosition(co);
		   assertEquals(c,game.getChosenChromino());
		   
	   }
	   @Test 
	   void testGetHands() {
		   game.getTheHand();
		   assertEquals(10,game.getJoueur1().getMyHand().size());
		   assertEquals(10,game.getJoueur2().getMyHand().size());
	   }

//	@Test
//    void testInitializeCamleonChromino() {
//        chroGame.intializeCamleonChromino();
//        assertFalse(chroGame.getChromosaic().isEmptyAt(new Coordinate(0, 0)));
//    }
//	  @Test
//	    void testSelectChrominoAndCoordinate() {
//	        Chromino chromino = chroGame.getFirstChromino();
//	        Coordinate coordinate = new Coordinate(2, 2);
//
//	        chroGame.selectedChromino(chromino);
//	        chroGame.selectPosition(coordinate);
//
//	        assertEquals(chromino, chroGame.getChosenChromino());
//	    }
//
//	    @Test
//	    void testNextTurnChangesPlayer() {
//	        int firstPlayer = chroGame.getCurrentPlayer().getName().equals("Joueur 1") ? 0 : 1;
//	        chroGame.nextTurn();
//	        int secondPlayer = chroGame.getCurrentPlayer().getName().equals("Joueur 1") ? 0 : 1;
//	        assertNotEquals(firstPlayer, secondPlayer);
//	    }
	

}
