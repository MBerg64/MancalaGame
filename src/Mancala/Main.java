package Mancala;

import java.util.Scanner;
 
public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String name1, name2;
		
		System.out.println("Enter the name of your first player: ");
		name1 = keyboard.nextLine();
		System.out.println("Enter the name of your second player: ");
		name2 = keyboard.nextLine();
		
		MancalaGame game = new MancalaGame(name1, name2);
		game.playGame();

	}

}
