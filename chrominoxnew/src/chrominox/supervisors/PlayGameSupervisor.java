package chrominox.supervisors;

import java.util.Objects;

import chrominox.domains.*;
import chrominox.supervisors.commons.ViewId;

public class PlayGameSupervisor extends Supervisor {

	private PlayGameView view;

	public void setView(PlayGameView view) {
		this.view = Objects.requireNonNull(view);
	}
	
	@Override
	public void onEnter(ViewId fromScreen) {
		if (fromScreen == ViewId.MAIN_MENU) {
			//TODO: connaître le joueur actif
			//TODO: dessiner la main du joueur actif
			//TODO: dessiner la mosaique
		}
		draw();
	}

	private void draw() {
		view.startDraw();

		drawBoard();
		drawHand();

		view.endDraw();
	}

	private void drawBoard() {
		//TODO: dessiner les tuiles de la mosaique
		//TODO: dessiner le chromino à poser
		view.addToBoard(TileType.CYAN.toString(), TileType.CYAN.toString(),  0, -1);
		view.addToBoard(TileType.CAMELEON.toString(), TileType.CAMELEON.toString(),  0, 0);
		view.addToBoard(TileType.RED.toString(), TileType.RED.toString(),  0, 1);
	}

	private void drawHand() {
		//TODO: dessiner les tuiles de la main du joueur actif
		view.addToHand(TileType.GREEN.toString(), 
				TileType.MAGENTA.toString(), 
				TileType.YELLOW.toString(),
				"black");
		
		
	}

	/**
	 * Méthode appelée par la vue pour déplacer le chromino actif sur la mosaique de {@code dr} ligne et de {@code dc} colonnes.
	 * */
	public void onMove(int dr, int dc) {
		//TODO: déplacer la position du chromino actif

		//TODO: rafraichier la vue
	}

	/**
	 * Méthode appelée par la vue pour effectuer une rotation de 90 du chromino actif.
	 * */
	public void onRotate() {
		//TODO: effectuer une rotation de 90° du chromino actif
		
		//TODO: rafraichier la vue
	}

	/**
	 * Méthode appelée par la vue quand le joueur souhaite ajouter son chromino à la mosaique.
	 * */
	public void onConfirm() {
		//TODO: ajouter le chromino sélectionné à la mosaique
		
		//TODO: rafraichier la vue
	}

	/**
	 * Méthode appelée par la vue quand le joueur souhaite passer son tour.
	 * */
	public void onPass() {
		//TODO: gérer le passement de tour.
		
		//TODO: rafraichier la vue
	}


	/**
	 * Appelée par la vue quand le joueur souhaite passer au chromino suivant.
	 * */
	public void onSelectNextPiece() {
		//TODO: passer au chromino suivant
		
		//TODO: rafraichier la vue
	}

	/**
	 * Appelée dans le mode {@code BOARD} si le joueur souhaite changer de pièce.
	 * */
	public void onBack() {
		//TODO: basculer dans le mode HAND
		
		//TODO: rafraichier la vue
	}

	/**
	 * Appelée si le joueur souhaite piocher un nouveau chromino
	 * */
	public void onPick() {
		//TODO: gérer la pioche d'un chromino
		//TODO: rafraichier la vue
	}

	/**
	 * Appelée dans le mode {@code HAND} si le joueur a choisi son chromino.
	 * */
	public void onPieceSelected() {
		//TODO: basculer dans le mode BOARD
		
		//TODO: rafraichier la vue
	}

}
