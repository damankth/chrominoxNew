package chrominox.domains;

import java.util.List;

public class DefaultChroGameFactory implements ChroGameFactory {

	private ChroGame currentGame;
	private final ChroBag bag;
	//private List<String>players;
	
    public DefaultChroGameFactory() {
        this.bag = new ChroBag();
    }
	@Override
	public void newGame(int nbJoueurs) {
		// TODO Auto-generated method stub
		if(nbJoueurs!=2) {
			throw new IllegalArgumentException("il faut imperativement 2 joueurs");
		}
		this.currentGame=new ChroGame();
		this.currentGame.createPlateau();
		 
		
	}
	//deepu
    private ChroGame createNewGame(List<String> players) {
        ChroGame game = new ChroGame(players);
        game.createPlateau();
        return game;
    }

	@Override
	public ChroGame getLastGame() {
		// TODO Auto-generated method stub
		return currentGame;
	}

//	@Override
//	public ChroGame createGame() {
//		// TODO Auto-generated method stub
//		this.currentGame=new ChroGame(List.of("Joueur 1", "Joueur 2"));
//		this.currentGame.createPlateau();
//		return currentGame;
//	}

	@Override
	public ChroGame createPlayers(List<String> nbPlayer) {
		// TODO Auto-generated method stub
		
		this.currentGame=new ChroGame(nbPlayer);
		return currentGame;
	}

}
