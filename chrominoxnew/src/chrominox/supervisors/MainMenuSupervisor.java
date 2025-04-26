package chrominox.supervisors;

import java.util.*;

import chrominox.supervisors.commons.ViewId;

public final class MainMenuSupervisor extends Supervisor {
	public static final String NEW_CLASSIC_GAME = "Partie classique";
	public static final String NEW_FAST_GAME= "Partie rapide";
	public static final String QUIT = "Quitter";
	
	private final List<String> items = List.of(NEW_CLASSIC_GAME,NEW_FAST_GAME,QUIT);
	private MainMenuView view;
	
	public MainMenuSupervisor() {
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
		} else {
			//TODO: créer une nouvelle partie
			//TODO: naviguer vers la vue "Nouvelle partie"
			this.view.goTo(ViewId.PLAY_GAME);
			//mais tu vois la apres avooir ajt la methode je devrais atterir sur linterface jeu
		}
		
	}


}
