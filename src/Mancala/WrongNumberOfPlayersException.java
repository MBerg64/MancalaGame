package Mancala;

public class WrongNumberOfPlayersException extends RuntimeException{
	/** No arg constructor
	 */
	public WrongNumberOfPlayersException() {
		super("Error, invalid number of players");
	}
	
	/**
	 * Constructor
	 * @param str The string to pass in as an argument
	 */
	public WrongNumberOfPlayersException(String str) {
		super(str);
	}
}
