 package chrominox.domains;

import java.util.List;

//import chrominox.supervisors.PlayGameSupervisor;



//import chrominox.supervisors.commons.ViewId;

public interface ChroGameFactory {
	//prof
	 void newGame(int playersCount);
	//prof  
	ChroGame  getLastGame();// creer la calsse chrogame
	

    default ChroGame createGame() {
		ChroGame currentGame=new ChroGame(List.of("Joueur 1", "Joueur 2"));
		currentGame.createPlateau();
		return currentGame;
		
	}

	// pt etre en player 
	ChroGame createPlayers(List<String> nbPlayer);
	//ChroGame createGame(List<String> nbPlayer);
	// methode pour initailisr les nombres de joueurs 
	// methode  pour initialiser si cest une partie classique ou normal
}
