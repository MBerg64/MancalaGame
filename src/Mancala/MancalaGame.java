package Mancala;

import java.util.Scanner;

public class MancalaGame {
	//fields. 2 players and boolean hasWinner set to false
	private Player player1;
	private Player player2;
	private boolean hasWinner;
			
	/**
	 * Constructor instantiates players with names passed in as arguments
	 * boolean hasWinner set to false
	 */
	public MancalaGame(String player1, String player2) {
		this.player1 = new Player(player1);
		this.player2 = new Player(player2);
		
		hasWinner = false;
	}
	
	/**
	 * Constructor instantiates a new game with player names "Player1" and "Player2"
	 */
	public MancalaGame() {
		this("Player1", "Player2");
	}
	
	/**
	 * returns winner of the game, or "null" if game is a tie
	 * @return
	 */
	public Player getWinner() {
		int player1Score = player1.getStore().getPebbles();
		int player2Score = player2.getStore().getPebbles();
		if(player1Score > player2Score) {
			return player1;
		}
		else if(player1Score < player2Score) {
			return player2;
		}
		else{
			return null;
		}
	}
	
	/**
	 * Plays Mancala game
	 */
	public void playGame() {
		//instantiates winner to null, scanner, current player to player1
		Player winner;
		Scanner scanner = new Scanner(System.in);
		int chosenPit = 0;
		Player currentPlayer = player1;
		Player otherPlayer = player2;
		
		do {	//while there is no winner, continue rounds		
			boolean goAgain = false;
			System.out.println("Board from " + currentPlayer.getName() + "'s perspective");
			System.out.println(getBoardString(currentPlayer)); //displays board from current player's perspective
			
			System.out.println(currentPlayer.getName() + ", from which pit would you like to remove pebbles?");
			chosenPit = scanner.nextInt()-1;	//sets player's choce to place in the array of pits
			scanner.nextLine();
			
			//while chosen pit is invalid or belonging to the opponent, asks for another choice
			while(chosenPit>5 || chosenPit<0 || currentPlayer.getPits()[chosenPit].isEmpty()) {
				System.out.println("Invalid choice, enter another: ");
				chosenPit = scanner.nextInt()-1;
				scanner.nextLine();
			}
			
			//takes pebbles from chosen pit
			int currentPebbles= currentPlayer.getPits()[chosenPit].getPebbles();
			//empty chosen pit
			currentPlayer.getPits()[chosenPit].setPebbles(0);
			int nextPit = chosenPit;

			while(currentPebbles > 0) {
				nextPit++;
	
				//if next pit is other player's first, drop pebble in store on the way
				if(nextPit == 6) {
					currentPebbles--;
					currentPlayer.getStore().addPebbles(1);
					//if last pebble was placed in store, player goes again
					if(currentPebbles == 0) {
						goAgain = true;
						break;
					}
					else {
						otherPlayer.getPits()[0].addPebbles(1);
						currentPebbles--;
					}
				}
				else if(nextPit == 12) {
					nextPit = 0;
				}
				else if(nextPit>6) {
					otherPlayer.getPits()[nextPit-6].addPebbles(1);
					currentPebbles--;
				}
				else if(nextPit<6) {
					currentPlayer.getPits()[nextPit].addPebbles(1);
					currentPebbles--;
				}
			}

			//if last pit pebble dropped into was empty and the player's own, player gets that pebble and their apponents pebbles accross for the store
			if(nextPit < 5 && currentPlayer.getPits()[nextPit].getPebbles() == 1) {
				currentPlayer.getStore().addPebbles(1);
				currentPlayer.getStore().addPebbles(otherPlayer.getPits()[5-nextPit].getPebbles());
				//set both emptied pits to 0
				currentPlayer.getPits()[nextPit].setPebbles(0);
				otherPlayer.getPits()[5-nextPit].setPebbles(0);
			}
			
			//if either player's pits are all empty, game ends
			if (player1.allEmpty() || player2.allEmpty()) {
				hasWinner = true;
			}
			else if(!goAgain) {
				Player nextPlayer = currentPlayer;
				currentPlayer = otherPlayer;
				otherPlayer = nextPlayer;
			}
						
		}while(!hasWinner);
		
		//Game over, player with remaining pebbles collects them and ats them to store
		collectRemainingPebbles();
		
		//calls on method to get winner, or null for a tie
		winner = getWinner();
		if(winner == null) {
			System.out.println("It's a tie!");
		}
		else {
			System.out.println(winner.getName() + " wins!");
		}
		
		//game over
		System.out.println("Game is Over");
		
	}
	
	public void collectRemainingPebbles() {
		//if player1's pits are empty, player2 gets all pebbles on their side for the store
		if(!player1.allEmpty()) {
			for(Pit p : player1.getPits()) {
				player1.getStore().addPebbles(p.getPebbles());
			}
		}
		//if player2's pits are empty, player1 gets all pebbles on their side for the store
		if(!player2.allEmpty()) {
			for(Pit p : player2.getPits()) {
					player2.getStore().addPebbles(p.getPebbles());
			}
		}
	}
	
	//needs help
	public String getBoardString(Player currentPlayer) {
		Player otherPlayer;
		if(currentPlayer == player1) {
			otherPlayer = player2;
		}else {
			otherPlayer = player1;
		}
		int otherName = otherPlayer.getName().length();
		int currentName = currentPlayer.getName().length();

		StringBuilder str = new StringBuilder();
		str.append(otherPlayer.getName());
		str.append("   Store    Pit6   Pit5   Pit4   Pit3   Pit2   Pit1   \n");
		for(int x = 0; x<otherName; x++) {
			str.append(" ");
		}
		str.append("        " + otherPlayer.getStore().getPebbles() + "   ");
		for(int index = 5; index >= 0; index--) {
			str.append(" " + otherPlayer.getPits()[index].getPebbles() + "     ");
		}
		str.append("\n\n");
		for(int x = 0; x<otherName; x++) {
			str.append(" ");
		}
		str.append("            ");
		for(int index = 0; index < currentPlayer.getPits().length; index++) {
			str.append(" " + currentPlayer.getPits()[index].getPebbles() + "     ");
		}
		str.append("   " + currentPlayer.getStore().getPebbles());
		str.append("\n");
		for(int x = 0; x<otherName; x++) {
			str.append(" ");
		}
		str.append("            ");
		str.append("Pit1   Pit2   Pit3   Pit4   Pit5   Pit6   Store   ");
		str.append(currentPlayer.getName() + "\n");
		
		return str.toString();
	}

}
