package Mancala;

public class InvalidPitException extends RuntimeException{
	/** No arg constructor
	 */
	public InvalidPitException() {
		super("Error, invalid pit choice");
	}
	
	/**
	 * Constructor
	 * @param str The string to pass in as an argument
	 */
	public InvalidPitException(String str) {
		super(str);
	}
}
