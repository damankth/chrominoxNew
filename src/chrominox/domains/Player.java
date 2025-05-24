package chrominox.domains;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Player {
	//private int score;// pas pr mnt 
	private  String name;
	private Set<Chromino>chrominosInHand;
	private boolean isActive;
	//private boolean handEmpty;
	private Chromino chromino ; 
	private Iterator <Chromino> iterator;
	
	//comment indiquer que la main est vide ?
	 public Player (String name,Set<Chromino>chrominosInHand ){
		this.name=Objects.requireNonNull(name);
		//ChroBag chroBag= new ChroBag(); 
		this.chrominosInHand=new HashSet<>(chrominosInHand);
		this.isActive= true;
		//this.score=0;
	 }

	public String getName() {
			return this.name;
		}
	
	public boolean handIsEmpty() {
		return chrominosInHand.isEmpty();
	}

	public Set<Chromino> getMyHand(){
		return chrominosInHand;
		
	}
	public void setHand(Set<Chromino> personnal0Bag) {
		// TODO Auto-generated method stub
		this.chrominosInHand=personnal0Bag;
	}
	public boolean isActive() {
	return isActive;
	}
	public void addAChromino (Chromino chromino) {
		this.chrominosInHand.add(chromino);
		}
	
	public void removeAChromino(Chromino chromino) {
		this.chrominosInHand.remove(chromino);
	}
	// caca?
//	public Set<Chromino> getChrominosInHand() {
//		return chrominosInHand;
//	}
	public Chromino drawAChromino(ChroBag chroBag) {
		Chromino drawnChromino= chroBag.getAChromino();
		if(drawnChromino!=null) {
			chrominosInHand.add(drawnChromino);
		}
		return drawnChromino;	
		
	}
	public Chromino selectAChromino () {
//		if(chrominosInHand==null) {
//			throw new IllegalArgumentException("le sac ne peut etre vide");
//		}
		
		//Objects.requireNonNull(this.chrominosInHand, "le sac ne peut etre vide");
		//Iterator <Chromino> iterator = chrominosInHand.iterator();
		
		if(iterator==null||!iterator.hasNext()) {
			iterator=chrominosInHand.iterator();
			
		}
		if(iterator.hasNext()) {
			return iterator.next();
		}
		return null;
		
		
	}
//	//caca?
//	public Player(){
//		this.name = "";
//		//this.score=0;
//		ChroBag chroBag= new ChroBag();
//		chrominosInHand=chroBag.personnal0Bag();// jsp ce que jai voulu faire pt eter une fonction ? pr recupere les sac 
//	}

	public int size() {
		// TODO Auto-generated method stub
		return this.chrominosInHand.size();
	}

	

	
	
//	public Player() {
//	return name;
//}
//public Player setName(String name) {
//	this.name=name;
//}
	// cest du caca
//		public void play(Chromino chromino) {
//			Set<Chromino>c= chromino.Chromino();
//		}
	// pas pr l'instant
//		public int getScore() {
//			return score;
//		}
//	public Chromino getChrominos() {
//	return this.getChrominos();
//}
//	public void setActive(boolean isActive) {
//	this.isActive=isActive;
//}

//public void setActive(boolean isActive) {
//	this.isActive = isActive;
//}
//cac je psne 
//public Chromino getAChromino(Chromino chromino) {
//	return chromino;
//}
	
//
//	public void setChrominosInHand(Set<Chromino> chrominosInHand) {
//		this.chrominosInHand = chrominosInHand;
//	}
	// est ce que cest ici que je dois afficher ls chromino?

//	public boolean isHandEmpty() {
//		return handEmpty;
//	}

//	public void setHandEmpty(boolean handEmpty) {
//		this.handEmpty = handEmpty;
//	}
	
	
}


