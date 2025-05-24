package chrominox.domains;


import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Iterator;
import java.util.List;


public class ChroBag implements ChrominoGenerator {
	private Set<Chromino> chrominosBag;

	
	
	/**
	 * BON
	 * maybe i ll have to create a methode that remove all the the chromino
	 * @return tt les combinaison de chrominaise possible 
	 */
	/**
	 *
	 */
	public ChroBag() {
		List<Chromino> list= generateChrominoes();
		this.chrominosBag=new HashSet<>(list);
	}
	
	
	
	//BON
//	
//	public Set<Chromino> chrominoBag(){
//		Set<Chromino>bagOfChrominos = new HashSet<>();
//		List<Chromino>normalChrominos=chroBagWithoutDuplicates75();
//		List<Chromino>cameleonChrominos=choose5RandomCameleonChrominos();
//		
//		
//			bagOfChrominos.addAll(normalChrominos);
//			bagOfChrominos.addAll(cameleonChrominos);
//		
//		return bagOfChrominos;
//		
//	}
	
	@Override
	public List<Chromino> generateChrominoes() {
		// TODO Auto-generated method stub
		List<Chromino>bagOfChrominos = new ArrayList<>();
		List<Chromino>normalChrominos=chroBagWithoutDuplicates75();
		List<Chromino>cameleonChrominos=choose5RandomCameleonChrominos();
		
		
			bagOfChrominos.addAll(normalChrominos);
			bagOfChrominos.addAll(cameleonChrominos);
		
		return bagOfChrominos;
		
	}
	
	
	
	
	//BON
	/**
	 * genere toutes les combinaisons de chrominos possible 
	 * @return chrobag un sac avec toutes les possibilités de chrominos dedans
	 */
	public List<Chromino> generateAllCombinationOfChrominos125() {
		List <Chromino> chroBag= new ArrayList<>();		
		TileType[]tileType=TileType.values();
			for(int i=1;i<tileType.length;i++) {
				for(int j=1;j<tileType.length;j++) {
					for(int k=1;k<tileType.length;k++) {
						chroBag.add(new Chromino(tileType[(i)], tileType[(j)], tileType[(k)]));
					}
				}
			}
		return chroBag;
	}
	//BON
	/**
	 * genere toutes les combinaisons de chromino cameleon
	 * @return chrobag avec tous les chromino cameleon
	 */
	public List<Chromino> generateAllCombinationOfCameleonChrominos25(){
		List <Chromino> chroBag= new ArrayList<>();	
		TileType[]tileType=TileType.values();
		for(int i=1;i<tileType.length;i++) {
			for(int j=1;j<tileType.length;j++) {
					chroBag.add(new Chromino(tileType[(i)], TileType.CAMELEON, tileType[(j)]));	
			}
		}
	return chroBag;
	}
	//BON
	/**
	 * genere un sac de 10 chromino unique 
	 * 
	 * @return chroBag10 avec 10 chrominos cameleons dedans 
	 */
	public List<Chromino> chroBagWithoutCameleonDuplicates(){
		List<Chromino> chroBag10=new ArrayList<>();
		List<Chromino> allCombinationsOfChrominos=generateAllCombinationOfCameleonChrominos25();
		
		for(Chromino i: allCombinationsOfChrominos) {
			// if false je le met 
			if(!i.isSame(i, chroBag10)&& i.getPart1()!=i.getPart3()) {
				chroBag10.add(i);
			}
		}
		return chroBag10;
		
	}
	//BON
	/**
	 *  ajoute 5 chrominos cameleon au hasard dans un sac 
	 * @return chroBag5, le sac dans lequelles se trouves les 5 chrominos cameleon
	 */
	public List<Chromino> choose5RandomCameleonChrominos(){
		
		List<Chromino> chroBag10=chroBagWithoutCameleonDuplicates();
		List<Chromino> chroBag5=new ArrayList<>();
		
		do {
			Random random=new Random();
			int randColor = random.nextInt(chroBag10.size());
			if(chroBag10.get(randColor)!=null) {
				chroBag5.add(chroBag10.get(randColor));
				chroBag10.remove(randColor);
			}
		}while(chroBag5.size()<5);
		
		
		return chroBag5;
	}
	
	//BON
	/**
	 * creer le sac de 75 chrominos avec 75 chrominos simple unique + 5 chrominos cameleons unique 
	 * @return chrobag75, un sac de chromino unique avec 75 chromino dedans
	 */
	public List<Chromino> chroBagWithoutDuplicates75(){
		
		List<Chromino> chroBag75=new ArrayList<>();
		
		List<Chromino> allCombinationsOfChrominos=generateAllCombinationOfChrominos125();
		
		for(Chromino i: allCombinationsOfChrominos) {
			if(!i.isSame(i, chroBag75)) {
				chroBag75.add(i);
			}
		}
		return chroBag75;
		
	}
	//BON
	
//	public Set<Chromino> chrominoBag(){
//		Set<Chromino>bagOfChrominos = new HashSet<>();
//		List<Chromino>normalChrominos=chroBagWithoutDuplicates75();
//		List<Chromino>cameleonChrominos=choose5RandomCameleonChrominos();
//		
//		
//			bagOfChrominos.addAll(normalChrominos);
//			bagOfChrominos.addAll(cameleonChrominos);
//		
//		return bagOfChrominos;
//		
//	}
	//BON
	//selon zanzibar
//	public void chrominoGenerator(ChrominoGenerator chrominoBag){
//		
//		List<Chromino>bagOfChrominos= chrominoBag.generateChrominoes();
//		ChroBag leBag=new ChroBag();
//		
//		copyList(chrominoBag, leBag);
//		
//			bagOfChrominos.addAll(normalChrominos);
//			bagOfChrominos.addAll(cameleonChrominos);
//		
//		return bagOfChrominos;
//		
//	}
//	@Override
//	public List<Chromino> generateChrominoes() {
//		// TODO Auto-generated method stub
//		List<Chromino>bagOfChrominos = new ArrayList<>();
//		List<Chromino>normalChrominos=chroBagWithoutDuplicates75();
//		List<Chromino>cameleonChrominos=choose5RandomCameleonChrominos();
//		
//		
//			bagOfChrominos.addAll(normalChrominos);
//			bagOfChrominos.addAll(cameleonChrominos);
//		
//		return bagOfChrominos;
//		
//	}
	//BON
	
	//trouver un chromino cameleon pour le placer sur le plateau
	
	/**
	 * Verifie si le chromino est un chromino cameleon 
	 * @param chromino le chromino a verifier 
	 * @return true si le chromino est un chromino cameleon, sinon false 
	 */
	public boolean isACameleonChromino(Chromino chromino) {
		
		if(chromino.getPart2()==TileType.CAMELEON) {
			return true;
		}
		return false;
	}
	//BON
	// cherhcer le chromino cameleon( sans iterator )
	//jai ajouter chrobag en parametre
	
	/**
	 * retire un premier chromino cameleon, pour le placer sur la chromosaic 
	 * @return copyChromino, un Chromino cameleon
	 */
	public Chromino getFirstCameleonChromino() {
	
		Iterator<Chromino>it= chrominosBag.iterator();
		
		while(it.hasNext()) {	
			Chromino copyChromino=it.next();
			if(isACameleonChromino(copyChromino)) {
				it.remove();
				return copyChromino;
			}
		}
		return null;
	}
	// rest a terminer
	//pr piocher un chromino
	
	/**
	 * permet de piocher un chromino au hasard 
	 * 
	 * @return copyChromino, un chromino au hasard 
	 */
	public Chromino getAChromino() {		
//		if(chrominosBag.isEmpty()) {
//            return null;
//        }
		Iterator<Chromino>it= chrominosBag.iterator();
		
		while(it.hasNext()) {	
			Chromino copyChromino=it.next();
				it.remove();
			//	chrominosBag.add(copyChromino);
			return copyChromino;	
		}
		
		return null;
	}
	
	/**
	 * Permet de generer un sac de 10 chrominos pour un joueur  a
	 * 
	 * @return myPersonnalBag le sac personel d'un joueur avec des 10 chrominos dedans
	 */
	public Set<Chromino> personnal0Bag() {
		
		Set<Chromino>myPersonnalBag=new HashSet<>();
		
		do {
			myPersonnalBag.add(getAChromino());
		}while(myPersonnalBag.size()<10);
		
		return myPersonnalBag;
		
		
	} 

	public Set<Chromino> getChrominosInBag() {
	    return chrominosBag;
	}





	public Iterator<Chromino> iterator() {
		// TODO Auto-generated method stub
		return chrominosBag.iterator();
	}

	

//	public Set<Chromino> getChrominosInHand() {
//		// TODO Auto-generated method stub
//		return null;
	
		
	

	
	
	

}
