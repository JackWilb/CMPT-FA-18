/**
 * Plays Greedy Coin game such that the computer never loses.
 * 
 * Jack Wilburn
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class GreedyCoinGame {
	
	List<Integer> linked = new LinkedList<Integer>();
	int compTotal = 0;
	int playerTotal = 0;
	
	public GreedyCoinGame(String file) throws FileNotFoundException {
		Scanner inFile = new Scanner(new File(file));

		while (inFile.hasNext()) {
			linked.add(inFile.nextInt());
		}

		inFile.close();
	}

	// prints the coins and their position
	public void printCoins() {
		
		System.out.println("+++++++++++");
		
		System.out.print("Coins		");
		for (int i = 0; i < linked.size(); i++) {
			System.out.print(linked.get(i) + "	");
		}
		System.out.print("\n");
		
		System.out.print("Positions	");
		for (int i = 0; i < linked.size(); i++) {
			System.out.print(i + "	");
		}
		System.out.print("\n");
		
		System.out.println("Computer: " + Integer.toString(compTotal) + " You: " + Integer.toString(playerTotal));
		
		System.out.println("+++++++++++");
	}

	public void playGame() {
		// get the keyboard for the silly human
		Scanner keyboard = new Scanner(System.in);
		int red = 0;
		int blue = 0;
		int selection;
		
		for (int i = 0; i < linked.size(); i++) {
			if (i % 2 == 0) {
				red = red + linked.get(i);
			} else {
				blue = blue + linked.get(i);
			}
		}
		
		if (red > blue) {
			selection = 0;
		} else {
			selection = linked.size()-1; 
		}
		
		System.out.println("Let's play the coin game!");
		printCoins();
		System.out.println("First is my turn. I pick the coin in the " + Integer.toString(selection) + " position.");
		compTotal += linked.get(selection);
		linked.remove(selection);
		printCoins();
		
		
		while(true) {
			int humanChoice = -1;
			while(humanChoice != linked.size()-1 && humanChoice != 0) {
				System.out.println("Indicate the position of the coin you choose: ");
				humanChoice = keyboard.nextInt();
			}
			
			playerTotal += linked.get(humanChoice);
			linked.remove(humanChoice);
			
			if (linked.size() == 0) {
				System.out.println("That's the game. The final scores are Computer: " + Integer.toString(compTotal) + " You: " + Integer.toString(playerTotal));
				break;
			}
			printCoins();
			
			if (humanChoice == 0) {
				selection = 0;
			} else {
				selection = linked.size() - 1;
			}
			System.out.println("I pick the coin in the " + Integer.toString(selection) + " position.");
			compTotal += linked.get(selection);
			linked.remove(selection);
			printCoins();
		}
		

		keyboard.close();

	}

	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.err.println("Pass a file on the command line");
			System.exit(0);
		}

		GreedyCoinGame game = new GreedyCoinGame(args[0]);

		game.playGame();
	}

}
