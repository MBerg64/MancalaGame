package Mancala;

public class Store {
	//pebbles field
	private int pebbles;
		
	/**
	 * Constructor sets stroe to 0 pebbles to start off game
	 */
	public Store() {
		pebbles = 0;
	}
	
	/**
	 * Constructor copies number of pebbles from the store passed in as an argument
	 */
	public Store(Store copy) {
		this.pebbles = copy.getPebbles();
	}
	
	/**
	 * sets pebbles in the store to number passed in as argument
	 */
	public void setPebbles(int num) {
		pebbles = num;
	}
		
	/**
	 * returns number of pebbles in the store
	 */
	public int getPebbles() {
		return pebbles;
	}	
	
	/**
	 * adds pebbles to the store
	 */
	public void addPebbles(int num) {
		pebbles += num;
	}
}
