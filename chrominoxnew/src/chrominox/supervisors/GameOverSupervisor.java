package chrominox.supervisors;

import chrominox.supervisors.commons.ViewId;

/**
 * Affiche les scores des joueurs et désigne le vainqueur.
 * */
public class GameOverSupervisor extends Supervisor {
	private GameOverView view;
	public void setView(GameOverView view) {
	}
	
	/**
	 * {@inheritDoc}
	 * */
	@Override
	public void onEnter(ViewId fromView) {
		if(fromView == ViewId.PLAY_GAME) {
			//TODO: afficher les scores des joueurs
			//TODO: afficher le vainqueur
		}
	}

	/**
	 * Appelée par la vue quand l'utilisateur souhaite revenir au menu principal.
	 * */
	public void onGoToMainMenu() {
		//TODO: naviguer vers le menu principal
		this.view.goTo(ViewId.MAIN_MENU);
		
	
	} 
}
