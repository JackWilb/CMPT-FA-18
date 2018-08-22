/**
 *    @name Jack Wilburn
 *    @date August 2018
 *
 *    This class provides a generic coin.
 */

package lab1;

public class GenericCoin {

	public enum CoinSide {HEADS, TAILS};
	public CoinSide side;
	
	public GenericCoin() {
		// Init: side = heads
		this.side = CoinSide.HEADS;
		
	}
	// Change side to heads
	public void setToHeads() {
		this.side = CoinSide.HEADS;
	}
	
	// Change side to tails
	public void setToTails() {
		this.side = CoinSide.TAILS;
	}
	
	// Detect if coin is heads
	public boolean isHeads() {
		return this.side == CoinSide.HEADS;
	}
	
	// Detect if coin is tails
	public boolean isTails() {
		return this.side == CoinSide.TAILS;
	}
	
	// Simulate coin toss
	public void toss() {
		double outcome = java.lang.Math.random();
		if (outcome > 0.5) {
			this.side = CoinSide.HEADS;
		} else {
			this.side = CoinSide.TAILS;
		}
	}
	
	// Coin to string
	public String toString() {
		return this.side.toString();
	}

}
