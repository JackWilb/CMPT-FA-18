/**
 *    @name Jack Wilburn
 *    @date August 2018
 *    
 *    This code was created for lab 1 of CMPT 202.
 *
 *    This class allows users to toss 2 coins and see which returns the most heads.
 *    
 */

package lab1;

public class UseGenericCoin {

	public static void main(String[] args) {
		// Initialize variables
		GenericCoin coin1 = new GenericCoin();
		GenericCoin coin2 = new GenericCoin();
		int outcomes1 = 0;
		int outcomes2 = 0;
		
		// Loop through 100 times
		for (int i = 0; i < 100; i++) {
			// Toss the 2 coins
			coin1.toss();
			coin2.toss();
			
			// Check coins and add to their tally if heads shows
			if (coin1.isHeads()) {
				outcomes1++;
			}
			if (coin2.isHeads()) {
				outcomes2++;
			}
		}
		
		// Print final results of the basic game
		if (outcomes2 - outcomes1 < 0) {
			System.out.format("Coin 1 was heads %d more times that coin 2", outcomes1-outcomes2);
		} else if (outcomes1 - outcomes2 < 0) {
			System.out.format("Coin 2 was heads %d more times that coin 1", outcomes2-outcomes1);
		} else {
			System.out.println("Both coins had the same number of heads");
		}
	}
}
