/**
 * @author Jack Wilburn
 * @date Sep 2018
 *
 * Program to play a hangman clone named snowman
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Snowman {
	// This will be all the words from words.txt
	List<String> wordList = new ArrayList<String>();

	// Read in the list of words
	public void readWords(String fileName) throws FileNotFoundException {
		Scanner s = new Scanner(new File(fileName));

		while (s.hasNext())
			wordList.add(s.next());

		s.close();
	}

	// Returns a random word from wordList
	public String getWord() {
		Random r = new Random();

		return wordList.get(r.nextInt(wordList.size()));
	}
	

	// Plays the game
	public void playGame(String word) {
		// Initialize variables
		char nextChoice;
		char[] wordArray = word.toCharArray();
		char[] output = word.toCharArray();
		ArrayList guesses = new ArrayList();
		int wrongGuesses = 0;
        
		// Print initial game board
        for (int i = 0; i < word.length(); i++) {
        	output[i] = '_';
        	System.out.print(" " + output[i] + " ");
        }
        System.out.println();
        
		// Scanner for reading inputs
		Scanner reader = new Scanner(System.in);

		// Game loop
		while (true) {
			// Get next character
			System.out.print("Your choice: ");
			nextChoice = reader.next().charAt(0);
			
			// Check if character is a letter
			if ((nextChoice <= 'z' && nextChoice >= 'a') || (nextChoice <= 'Z' && nextChoice >= 'A')) {
				// Coerce the guess to lower case
				nextChoice = Character.toLowerCase(nextChoice);
				
				// Check to see if the letter has been guessed
				if (!guesses.contains(nextChoice)) {
					guesses.add(nextChoice);
					
					// See if guess is in word
					if (contains(wordArray, nextChoice)) {
						System.out.println("The word contains " + nextChoice);
						System.out.println("");
						for (int i = 0; i < word.length(); i++) {
							if (wordArray[i] == nextChoice) {
								output[i] = nextChoice;
							}
						}
					} else {
						System.out.println("The word doesn't contain " + nextChoice);
						System.out.println("");
						wrongGuesses++;
					}
					
					// Output new game board
					for (int i = 0; i < word.length(); i++) {
						System.out.print(" " + output[i] + " ");
					}
					System.out.println("");
					System.out.println("Incorrect guesses = " + wrongGuesses);
					
					// Win condition
					if (equals(wordArray, output)) {
						System.out.println("You win!");
						break;
					}
					
					// Loss condition
					if (wrongGuesses == 6) {
						System.out.println("You lose! The word was " + word);
						break;
					}
				} else {
					System.out.println("You already guessed that");
				}
					
			} else {
				System.out.println("Please input a proper character");
			}
			
        }
			
	}

	public static void main(String[] args) {
		Snowman game = new Snowman();

		try {
			game.readWords("words.txt");
			game.playGame(game.getWord());
		} catch (FileNotFoundException fnf) {
			System.err.println("words.txt file Not Found");
		}

	
	}
	
	// See if wordArray contains guess
	public boolean contains(char[] wordArray, char nextChoice) {
		for (int i = 0; i < wordArray.length; i++) {
			if (wordArray[i] == nextChoice) {
				return true;
			}
		}
		return false;
	}
	
	// See if wordArray equals output
	public boolean equals(char[] wordArray, char[] output) {
		int numberOfMatches = 0;
		
		// See how many letters match
		for (int i = 0; i < wordArray.length; i++) {
			if (wordArray[i] == output[i]) {
				numberOfMatches++;
			}
		}
		
		// If matches equals numbers of letters return match
		if (numberOfMatches == wordArray.length) {
			return true;
		}
		return false;
	}
}
