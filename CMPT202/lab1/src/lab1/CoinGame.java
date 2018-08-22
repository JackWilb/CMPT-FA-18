/**
 *    @name Jack Wilburn
 *    @date August 2018
 *    
 *    This code was created for lab 1 of CMPT 202.
 *
 *    This class allows users to toss a coin and guess the answer.
 *    
 */

package lab1;

import java.util.Scanner;

public class CoinGame {

	public static void main(String[] args) {
		// Initialize variables
		GenericCoin coin1 = new GenericCoin();
		Scanner keyboard = new Scanner(System.in);
		int turns = 0;
		int correctGuesses = 0;
		
		System.out.println("When you're done playing type stop.");
		
		// Start loop here
		while(true) {
			coin1.toss();
			System.out.println("Guess which side of the coin is facing up:");
			String input = keyboard.nextLine();
			
			if (input.equals("stop")) {
				double percentage = (correctGuesses * 100.0f)/turns;
				System.out.print("Thanks for playing. You got ");
				System.out.print(correctGuesses + " correct out of a possible ");
				System.out.format(turns + ". That is a  %.2f", percentage);
				System.out.print(" percent accuracy.");
				break;
			}
			
			if (input.equalsIgnoreCase(coin1.toString())) {
				correctGuesses++;
				System.out.println("Correct");
			} else {
				System.out.println("Incorrect, the correct answer was " + coin1.toString());
			}
			
			turns++;
		}
	}
}
