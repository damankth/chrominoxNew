package chrominox.domains;

import java.util.ArrayList;

import java.util.List;
import java.util.Objects;
//import java.util.Map;
import java.util.Random;
//import java.util.Set;
import java.util.Set;

public class ChroGame {
	// a idealement laisser comme ca je pense 
	
	private final ChroBag chroBag;
	private final List<Player>players;
	private Chromino firstChromino;
	private Chromino chosenChromino;
	private Coordinate chosenCoordinate;//importznt?
	private Chromosaic chromosaic;
	private int currentPlayer;
	private int y; 
	private int x;
	private int nbRotate=0;//importznt?
//	private Set<Chromino> personnalHand;
	
	//
	
	//BON 
	public ChroGame(List<String> players) {
		Objects.requireNonNull(players, "peut pas etre null");
		if(players.size()!=2) {
			throw new IllegalArgumentException("2Joueurs obligatoire");
		}
		this.chroBag=new ChroBag();
		this.chromosaic=new Chromosaic();
		this.firstChromino=Objects.requireNonNull(
			    this.chroBag.getFirstCameleonChromino());
		this.players= new ArrayList<>(2);
//		this.players.add(new Player("Joueur 1", createHand()));
//		this.players.add(new Player("Joueur 2", createHand()));
		//creationOfPlayers();
		for(String name: players) {
			this.players.add(new Player(name, chroBag.personnal0Bag()));
		}
		this.currentPlayer=whoStarts();
	}
	//BON
	public int whoStarts() {
		Random random= new Random();
		 
		return random.nextInt(players.size());
	}
	public void intializeCamleonChromino() {
		 this.chromosaic.addChrominoAt(new Coordinate(0, 0), firstChromino);
		 
	}
	public ChroBag getChroBag() {
		return chroBag;
	}
	
	public Chromosaic getChromosaic() {
		return chromosaic;
	}
	//BON
//	public void creationOfPlayers() {
//		//List<Player> playersList=new ArrayList<>();
//		
//		//for(String nbPlayer: players) {
//			//eachone gets a set where he can stock the chrominos gotta add
//	
//			this.players.add(new Player("Joueur 1", createHand()));
//			this.players.add(new Player("Joueur 2", createHand()));
//		
//	}
	//BON
	public ChroGame(){
		this(List.of("Joueur 1", "Joueur 2"));
		
	}
	public Player getJoueur1() {
		return this.players.get(0);
	}
	public Player getJoueur2() {
		return this.players.get(1);
	}
	
	public Set<Chromino> createHand() {
		// TODO Auto-generated method stub
		return getChroBag().personnal0Bag();
	}
	
	//BON
	public Chromino getFirstChromino() {
		return firstChromino;
		
	}
	//BON
	//connait les jouvoideurs
	 public Player getPlayers() {
	       return players.get(nextTurn());
	    }
		
	 //BON
	 //gerer le tour des joueurs
	 public Player getCurrentPlayer() {
		 return players.get(currentPlayer);
	 }
	 //BON
// gerer le tour des joueuers
	 public int nextTurn() {
		 int turn= (currentPlayer+1)%players.size();
		 currentPlayer=turn;
		
		 return currentPlayer;
	 }
	 /**
	  * verifie si le joueur qui veut piocher et le joueur qui joue actuellement 
	  * 
	  * @param player le joueur a verifier
	  * 
	  * @return true si player est le joueur a qui c'est son tour de jouer 
	  */
	  public boolean canDraw(Player player) {
		 Player currentPlayer= getCurrentPlayer();
		  if(player.equals(currentPlayer)) {
			  return true;
		  }
		  return false;
	  }
	 //BON
// alredy exists in chromosaic
	 //connait le chromino actuelle
	 public void selectedChromino(Chromino chromino) {
		 //removed the if 
		 //if (getCurrentPlayer().getChrominosInHand().contains(chromino)) {
		 this.chosenChromino=chromino;
		 
	 }
	 //BON
	 //connait la position du chromino
	 public void selectPosition(Coordinate position) {
		 this.chosenCoordinate= position;
	 }
	 
	 
	 
	 
	 
	 
	 public void getTheHand() {
		 Objects.requireNonNull(chroBag, "Le sac ne peut pas etre vide");
		 for(Player player:players) {
			 player.setHand(chroBag.personnal0Bag());
		 }
		 
	 }
	 
	 //BON
	 public Chromosaic createPlateau() {
		 //Chromino chrominoCameleon= firstChromino;
		 
		 if(chromosaic==null) {
			 chromosaic=new Chromosaic();
			 
		 }
		
//		 intializeCamleonChromino();
//		 
//		 getTheHand();
//		 
//		 currentPlayer=whoStarts();
//		
		 //chromosaic.addChrominoAt(new Coordinate(0,0), chrominoCameleon);
		 //players.get(currentPlayer).addAChromino(chosenChromino);
		// return chromosaic;
		 Objects.requireNonNull(firstChromino, "First chromino not initialized");
		 intializeCamleonChromino();
		 return chromosaic;
		 
	 }
	public Chromino getChosenChromino() {
		return chosenChromino;
	}
	/**
	 * 
	 * Pioche un nouveau chromino 
	 * 
	 * @return retourn le chromino pioche
	 */
	public Chromino getdrawChromino() {
		 Chromino chromino= players.get(currentPlayer).drawAChromino(chroBag);
		return chromino;
	}
	
	public boolean choseToMoveChromino(Chromino chromino) {
		return true;
	}
	
	public Chromino moveChosenChromino(Chromino chromino ,int x, int y) {
		
     chromino= chromosaic.moveChromino(chromino, x, y);
		return chromino;
	}  
	 
	public Coordinate getCoordinateOfChosenChromino(Chromino chosenChromino) {
		Coordinate coordinate= chromosaic.getCoordinate(chosenChromino);
		return coordinate ;
	}
	
	public Chromino chooseNextChromino() {
		Chromino chromino = players.get(currentPlayer).selectAChromino();
		
		return chromino;
	}
	

	public Coordinate chrominoRotates(Chromino chromino) {
		
		
		
		return this.chromosaic.rotateChromino(chromino);
	}
	
//	public void drawAChromino() {
//	
//		
//		
//	}
		
	/*
	 * Methode pour demander la main
	 */
	//public void setHand(Set<Chromino> theHand);
	/*
	 * Methode pour creer la chromosaic
	 */
	
	/*
	 * Methode pour appelée le joueur 
	 */
	//public void setPlayer(Player player);
	//public void setChromosaic(Chromosaic chromosaic) {
		
	
	
}
