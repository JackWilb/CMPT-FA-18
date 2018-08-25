/**
 * Generate the co-primes from (1,1) to (m,n)
 * 
 * Jack Wilburn
 *
 */


import java.util.*;


public class CoPrimes {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.err.println("Must be passed two integer values > 0");
			
			System.exit(0);
		}
		
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		
		for (int i = m; i > 0; i--) {
			for (int j = 1; j <= n; j++) {
				if (gcd(i,j) == 1) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.print("\n");
		}
		
	}
	
	public static int gcd(int x, int y) {
		while (y != 0) {
			int a = y;
			y = x % y;
			x = a;
		}
		return x;
	}

}
