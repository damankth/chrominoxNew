package chrominox.supervisors;

import java.util.*;




import chrominox.domains.ChroGameFactory;

import chrominox.domains.Player;
import chrominox.supervisors.commons.ViewId;

public final class MainMenuSupervisor extends Supervisor {
	public static final String NEW_CLASSIC_GAME = "Partie classique";
	public static final String NEW_FAST_GAME= "Partie rapide";
	public static final String QUIT = "Quitter";
	
	private final List<String> items = List.of(NEW_CLASSIC_GAME,NEW_FAST_GAME,QUIT);
	private MainMenuView view;
	private ChroGameFactory chroGame;
	private PlayGameSupervisor supervisor;
	
//	public MainMenuSupervisor(ChroGameFactory chroGame) {
//		this.chroGame=Objects.requireNonNull(chroGame, "la factory ne peut etre null");
//	}

	public MainMenuSupervisor(PlayGameSupervisor supervisor ) {
		
		this.supervisor=supervisor;
		List<Player>players= new ArrayList<>();
		
	}

	public void setView(MainMenuView screen) {
		this.view = screen;
		this.view.setItems(items);
	}

	/**
	 * Méthode appelée par la vue quand l'utilisateur a choisi un item.
	 * 
	 * @param selected la position de l'item dans la liste reçue par la vue.
	 * */
	public void onItemSelected(int selected) {
	
		Objects.checkIndex(selected, items.size());
		var item = items.get(selected);
		
		if(QUIT.equals(item)) {
			this.view.onQuitConfirmed(ViewId.MAIN_MENU);
			
		} else if(NEW_CLASSIC_GAME.equals(item)) {
			//TODO: créer une nouvelle partie
			
		supervisor.createNewGame();
		//chroGame.createGame();
			
			
			//TODO: naviguer vers la vue "Nouvelle partie"
		
	                view.goTo(ViewId.PLAY_GAME); 
	     
		} else if (NEW_FAST_GAME.equals(item)) {
			
			//chroGame.newGame(2);
		
			this.view.goTo(ViewId.PLAY_GAME);
			
		}
	}


}
