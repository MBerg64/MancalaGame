package Mancala;

public class Pit {
	//pebbles field
	private int pebbles;
	
	/**
	 * Construcor sets pit to 4 to start off game
	 */
	public Pit() {
		pebbles = 4;
	}
	
	/**
	 * sets pebble number in pit to number passed in as an argument
	 */
	public void setPebbles(int num) {
		pebbles = num;
	}
	
	/**
	 * returns number of pebbles in pit
	 */
	public int getPebbles() {
		return pebbles;
	}	
	
	/**
	 * adds pebbles to pit
	 */
	public void addPebbles(int num) {
		pebbles += num;
	}
	
	/**
	 * checks if it is empty/has no pebbles
	 * return true if empty, false if pit contains pebbles
	 */
	public boolean isEmpty() {
		if(pebbles == 0) {
			return true;
		}
		return false;
	}
}
