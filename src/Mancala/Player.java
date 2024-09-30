package Mancala;

public class Player {
	//fields. assigns name, 6 pits, ad a store to the player
	String name;
	private Pit[] pits = new Pit[6];
	private Store store;
	
	/** 
	 * Constructor takes name passed in as argument and initialtes pits and store
	 * @param name
	 */
	public Player(String name) {
		for(int index = 0; index<pits.length; index++) {
			pits[index] = new Pit();
		}
		store = new Store();
		this.name = name;
	}
	
	/**
	 * Constructor taks player name from string passed in as an argument
	 * @param name
	 */
	public void setPlayerName(String name) {
		this.name = name;
	}
	
	/**
	 * returns a copy array of player's pits
	 */
	public Pit[] getPits() {
		Pit[] pitsCopy = new Pit[6];
		for(int index = 0; index<pits.length; index++) {
			pitsCopy[index] = pits[index];
		}
		return pitsCopy;
	}
	
	/**
	 * returns copy of player's store
	 */
	public Store getStore() {
		return store;
	}
	
	/**
	 * checks if all the player's pits are empty.
	 * returns true if all empty, false if not
	 */
	public boolean allEmpty() {
		for(Pit p : pits) {
			if(!(p.isEmpty())) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * returns string of player's name
	 */
	public String getName() {
		return name;
	}
}
