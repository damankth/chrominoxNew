package chrominox.supervisors;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import chrominox.domains.*;
import chrominox.supervisors.commons.ViewId;


public class PlayGameSupervisor extends Supervisor {

	private PlayGameView view;
	private ChroGameFactory gameF;
	private ChroGame gameC;
	private Chromino selectedChromino;
	private int dr;
	private int dc;

//	public PlayGameSupervisor(ChroGameFactory gameF) {
//		this.gameF= Objects.requireNonNull(gameF);
//		this.gameC= gameF.getLastGame(); 
//		
//		
//	};
	
//	public PlayGameSupervisor(ChroGameFactory factory) {
//		this.gameF=Objects.requireNonNull(factory);
//	} 
//	
	public PlayGameSupervisor() {
	//	this.gameF=Objects.requireNonNull(factory);
		this.dr=0;
		this.dc=0;
	}
	public void setView(PlayGameView view) {
		this.view = Objects.requireNonNull(view);
		
		
	}
	
	public ChroGameFactory getGameFactory() {
		if(gameF==null) {
			gameF= new DefaultChroGameFactory();
		}
		return gameF;
	}
	public void createNewGame() {
	 this.gameC = getGameFactory().createGame();
	 if(view!=null) {
		 draw();
	 }
	}
	public void setGame(ChroGame game) {
        this.gameC = Objects.requireNonNull(game);
        if (view != null) {
            draw();
        }
    }
	
	@Override
	public void onEnter(ViewId fromScreen) {
	if(gameC==null) {
		
		 createNewGame();
		
	}
		if (fromScreen == ViewId.MAIN_MENU) {
			
			//TODO: connaître le joueur actif
			
			Player current = gameC.getCurrentPlayer();
			//this.gameC.getCurrentPlayer();
			//TODO: dessiner la main du joueur actif
			this.gameC.getCurrentPlayer().getMyHand();
			//TODO: dessiner la mosaique
			this.gameC.createPlateau();
			
			//gameC.createPlateau();
			
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
		//Chromosaic chromosaic = gameC.getChromosaic();
		//Chromino firstChromino = gameC.getFirstChromino();
//		
		//TODO: dessiner le chromino à poser
		//Chromino chromino=this.currentGame.getFirstChromino();
		//Chromino mosaic = gameC.getFirstChromino();
		
//		view.addToBoard(TileType.CYAN.toString(), "BLACK", 0, -1);
//		view.addToBoard(TileType.CYAN.toString(), "BLACK", 0, 0);
//		view.addToBoard(TileType.CYAN.toString(), "BLACK", 0, 1);

		Chromino firstChromino = gameC.getFirstChromino();
		view.addToBoard(firstChromino.getPart1().toString(), "BLACK", 0, -1);
		view.addToBoard(firstChromino.getPart2().toString(), "BLACK", 0, 0);
		view.addToBoard(firstChromino.getPart3().toString(), "BLACK", 0, 1);
		
		if(selectedChromino!=null) {
			
//			    view.addToBoard(selectedChromino.getPart1().toString(), "ORANGE", -6+ gameC.getCoordinateOfChosenChromino(firstChromino).getX(),+7 -1+ gameC.getCoordinateOfChosenChromino(firstChromino).getY());
//			    view.addToBoard(selectedChromino.getPart2().toString(), "ORANGE", -6+ gameC.getCoordinateOfChosenChromino(firstChromino).getX(),+7+ 0+ gameC.getCoordinateOfChosenChromino(firstChromino).getY());
//			    view.addToBoard(selectedChromino.getPart3().toString(), "ORANGE", -6+ gameC.getCoordinateOfChosenChromino(firstChromino).getX(), +7+1+ gameC.getCoordinateOfChosenChromino(firstChromino).getX());
//			
//			    
//			
//			Coordinate coord=gameC.getCoordinateOfChosenChromino(selectedChromino);
//			this.view.addMessage("Position avant déplacement: " + coord);
//			if(coord!=null) {
//		    view.addToBoard(selectedChromino.getPart1().toString(), "YELLOW",  dr+coord.getX(),  dc-1+coord.getY());
//		    view.addToBoard(selectedChromino.getPart2().toString(), "YELLOW", dr+coord.getX(),  dc+coord.getY());
//		    view.addToBoard(selectedChromino.getPart3().toString(), "YELLOW", dr+coord.getX(),  dc+1+coord.getY());
			
			Coordinate coord = gameC.getCoordinateOfChosenChromino(selectedChromino);
	        if (coord != null) {
	            view.addMessage("Position avant déplacement: " + coord);
	            view.addToBoard(selectedChromino.getPart1().toString(), "YELLOW",  coord.getX(), - 1 + coord.getY());
	            view.addToBoard(selectedChromino.getPart2().toString(), "YELLOW",  coord.getX(),  coord.getY());
	            view.addToBoard(selectedChromino.getPart3().toString(), "YELLOW",  coord.getX(),  1 + coord.getY());
	        
	        }
			//this.view.addMessage("ceci"+gameC.getCoordinateOfChosenChromino(firstChromino).getX() +gameC.getCoordinateOfChosenChromino(firstChromino).getY());
		}
		
//		if (selectedChromino != null) {
//		    view.addToBoard(selectedChromino.getPart1().toString(), "BLACK", 1+dr, -1+dc);
//		    view.addToBoard(selectedChromino.getPart2().toString(), "BLACK", 1+dr, 0+dc);
//		    view.addToBoard(selectedChromino.getPart3().toString(), "BLACK", 1+dr, 1+dc);
//		} else {
//		    Chromino firstChromino = gameC.getFirstChromino();
//		    view.addToBoard(firstChromino.getPart1().toString(), "BLACK", 0, -1);
//		    view.addToBoard(firstChromino.getPart2().toString(), "BLACK", 0, 0);
//		    view.addToBoard(firstChromino.getPart3().toString(), "BLACK", 0, 1);
//		}
		// chercher le coorinate du selected chromino
//		if(selectedChromino!=null) {
//			Coordinate coordinate = gameC.getCoordinateOfChosenChromino(selectedChromino);
//			view.addToBoard(selectedChromino.getPart1().toString(), "ORANGE",coordinate.getX()+dr , -1+coordinate.getY());
//			view.addToBoard(selectedChromino.getPart2().toString(), "ORANGE",coordinate.getX()+dr, 0+coordinate.getY());
//			view.addToBoard(selectedChromino.getPart3().toString(), "ORANGE", coordinate.getX()+dr, coordinate.getY());
//				
//		}
		
	}

	private void drawHand() {
		//TODO: dessiner les tuiles de la main du joueur actif
//		view.addToHand(TileType.GREEN.toString(), 
//				TileType.MAGENTA.toString(), 
//				TileType.YELLOW.toString(),
//				"black");
//		
		Set<Chromino>playersHand= gameC.getCurrentPlayer().getMyHand();
//		Iterator<Chromino> hand=  playersHand.iterator();
//		while(hand.hasNext()) {
//			
//			Chromino currentChromino= hand.next();
//			view.addToHand(currentChromino.getPart1().toString(), 
//					currentChromino.getPart2().toString(), 
//					currentChromino.getPart3().toString(),
//					"black");
//			
		
//		}
//		if(selectedChromino!=null) {
//			playersHand.remove(selectedChromino);
//		}
		for(Chromino chromino :playersHand) {
			if(chromino.equals(selectedChromino)) {
				this.view.addMessage("le chromino est la");
				view.addToHand(chromino.getPart1().toString(), 
						chromino.getPart2().toString(), 
						chromino.getPart3().toString(),
						"PINK");
				if(selectedChromino!=null) { 
					Coordinate coordinate = gameC.getCoordinateOfChosenChromino(selectedChromino);
					if(coordinate!=null) {
						
//						 int x = (coordinate != null) ? coordinate.getX() : 0+dr;  // Protection null
//			             int y = (coordinate != null) ? coordinate.getY() : 0+dc;
//			                
						view.addToBoard(selectedChromino.getPart1().toString(), "YELLOW", coordinate.getX()+dr,-1+coordinate.getY()+dc);
						view.addToBoard(selectedChromino.getPart2().toString(), "YELLOW",  coordinate.getX()+dr, coordinate.getY()+dc+0);
						view.addToBoard(selectedChromino.getPart3().toString(), "YELLOW",  coordinate.getX()+dr,coordinate.getY()+dc+ 1);
						
					}
					
					
				}
				
			}else {
				view.addToHand(chromino.getPart1().toString(), 
						chromino.getPart2().toString(), 
						chromino.getPart3().toString(),
						"BLACK");
			}	
		}
		
		
			
		
		
		
		
		//DefaultChroGameFactory currentGame.newGame(2);
		
		
		
	}

	

	/**
e	 * Méthode appelée par la vue pour déplacer le chromino actif sur la mosaique de {@code dr} ligne et de {@code dc} colonnes.
	 * */
	public void onMove(int dr, int dc) {
		//TODO: déplacer la position du chromino actif
		
		
//		Coordinate coordinate= gameC.getCoordinateOfChosenChromino(selectedChromino);
//		if(coordinate==null) {
//		 	coordinate=new Coordinate(0,0);
//		}
//		int coordX= coordinate.getX();
//		int coordY= coordinate.getY();
//		
//		gameC.choseToMoveChromino(selectedChromino);
//		gameC.moveChosenChromino(selectedChromino, coordX+dr, coordY+dc);
//		//gameC.moveChosenChromino(dr, dc);
		this.view.addMessage("le deplacement se fait");
		gameC.moveChosenChromino(selectedChromino, dr, dc);
		this.view.addMessage("un decalage a lieu: "+dr+" "+dc);
		//TODO: rafraichier la vue
		draw();
		
	}
	

	/**
	 * Méthode appelée par la vue pour effectuer une rotation de 90 du chromino actif.
	 * */
	public void onRotate() {
		//TODO: effectuer une rotation de 90° du chromino actif
		
		gameC.chrominoRotates(selectedChromino);
	    
		//TODO: rafraichier la vue
		draw();
	}

	/**
	 * Méthode appelée par la vue quand le joueur souhaite ajouter son chromino à la mosaique.
	 * */
	public void onConfirm() {
		//TODO: ajouter le chromino sélectionné à la mosaique
		
		
//		Coordinate coordinate= new Coordinate(dr, dc);
		Coordinate coordinate= gameC.getCoordinateOfChosenChromino(selectedChromino);
		this.view.addMessage("le chromino onConfirm");
		//if(gameC.getChromosaic().addChrominoAt(coordinate, selectedChromino))
		if(coordinate!=null) {
			
			Coordinate newCoordinate= new Coordinate (coordinate.getX()+dr, coordinate.getY()+dc);
			
			gameC.getChromosaic().addChrominoAt(newCoordinate, selectedChromino);
			
			dr=dc=0;
			draw();
		}
		
				
		
		//TODO: rafraichier la vue
	//draw();
	}

	/**
	 * Méthode appelée par la vue quand le joueur souhaite passer son tour.
	 * */
	public void onPass() {
		//TODO: gérer le passement de tour.
		
		gameC.nextTurn();
		
		
		
		//TODO: rafraichier la vue
		drawHand();
	}


	/**
	 * Appelée par la vue quand le joueur souhaite passer au chromino suivant.
	 * */
	public void onSelectNextPiece() {
		//TODO: passer au chromino suivant
		//selectedChromino.getPart1().toString(), "PINK";
//		Chromino nextChromino= 
		selectedChromino = gameC.chooseNextChromino();
		this.view.addMessage("le chromino  a ete choisi "+selectedChromino);
		if(selectedChromino==null) {
			view.addMessage("pas dispo chromino");
		}
		
//		view.addToHand(nextChromino.getPart1().toString(), 
//				nextChromino.getPart2().toString(), 
//				nextChromino.getPart3().toString(),
//				"PINK");
//	
//		view.addToBoard("BLACK", "PINK", dr, dc);
		
		draw();
		
		
	

		//TODO: rafraichier la vue
	}

	/**
	 * Appelée dans le mode {@code BOARD} si le joueur souhaite changer de pièce.
	 * */
	public void onBack() {
		//TODO: basculer dans le mode HAND
		
		
		//TODO: rafraichier la vue
		draw();
	}

	/**
	 * Appelée si le joueur souhaite piocher un nouveau chromino
	 * */
	public void onPick() {
		//TODO: gérer la pioche d'un chromino
		Chromino drawnChromino= gameC.getdrawChromino();
		
		view.addToHand(drawnChromino.getPart1().toString(), 
				drawnChromino.getPart2().toString(), 
				drawnChromino.getPart3().toString(),
				"BLACK");
	
		draw();
		
		//TODO: rafraichier la vue
	}

	/**
	 * Appelée dans le mode {@code HAND} si le joueur a choisi son chromino.
	 * */
	public void onPieceSelected() {
		//TODO: basculer dans le mode BOARD
		
		
		//TODO: rafraichier la vue
		draw();
	}

}
