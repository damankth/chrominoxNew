package chrominox.domains;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Chromosaic {
	// ou pt etre faire un stack plus interresant?
	private Map<Coordinate, Chromino> myTab;// arrayslist ou tableau ? 
	//private  Chromino chromino;
	//a faire
	//private  boolean isEmpty;
	private Coordinate coordinate;
	private Chromino chosenChromino;
	private int nbRotate=0;
	//BON
	
	public Chromosaic () {
		myTab=new HashMap<>();
		
	}
	//BON// remplacer par la method en bas
//	public void addChrominoAt(Coordinate cord, Chromino chromino) {
//		myTab.put(cord, chromino);
//		}
	//BON 
	 public boolean isEmptyAt(Coordinate coord) {
		 if(myTab.containsKey(coord)) {
			 return false;
		 }
		 return true;
	 }
	 //BON
	public Map<Coordinate, Chromino> getTab() {
		return  myTab;
	}
	public Chromino addChrominoAt(Coordinate cord, Chromino firstChromino) {
		// TODO Auto-generated method stub
		if(cord==null|| firstChromino==null) {
			throw new IllegalArgumentException("Aucun des parametre ne peut etre null");
		} 
		return myTab.put(cord, firstChromino);

	}
	
	public Coordinate getCoordinate(Chromino chosenChromino) {
		
		for( Map.Entry<Coordinate, Chromino> Tab : myTab.entrySet()) {
			if( Tab.getValue().equals(chosenChromino)) {
				 return Tab.getKey();
			}
			
		}
		return null;
		
		
	}
	public Coordinate rotateChromino(Chromino chromino) {
		Coordinate coord1= getCoordinate(chromino);
		
		int rotation= ((nbRotate%4)+1);
		int x=0;
		int y=0;
		Coordinate coord2= coord1;
		switch(rotation) {
		case 0:
			coord2=new Coordinate(coord1.getX(), y);
			break;
		case 1:
			coord2=new Coordinate(-coord1.getY(), x);
			break;
		case 2:
			coord2=new Coordinate(-coord1.getY(), -y);
			break;
		case 3:
			coord2=new Coordinate(coord1.getX(), -x);
			break;	
			
		}
		
		nbRotate++;
		myTab.remove(coord1);
		myTab.put(coord2, chromino);
		return coord2;
	}
	public Chromino moveChromino(Chromino chromino, int x, int y) {
//		if(((Chromosaic) myTab).isEmptyAt(coordinate)) {
//			return addChrominoAt(coordinate, chosenChromino);
//			
//		}
//		return null;
//		
		//Coordinate chosenCoordinate= new Coordinate (coordinate.getX()+x, coordinate.getY()+y);
		
		Coordinate coordinate= getCoordinate(chosenChromino);
		//removeChromino(chosenChromino);
		if(coordinate==null) {
			coordinate=new Coordinate(0,0);
		}
		
		Coordinate newCoordinate= new Coordinate(coordinate.getX()+x, coordinate.getY()+y);
//		if(getCoordinate(chosenChromino)!=null) {
//			myTab.remove(coordinate);
//		}
		
		
		return addChrominoAt(coordinate, chosenChromino);
	}

}
