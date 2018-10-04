
public class PalindromeCheckerStackQueue {
	
	public static void main(String[] args) {
		
		if (args.length == 0) {
			System.out.println("Please supply a string as an arguemnt.");
			System.exit(0);
		}
		

		// messages out
		String input = args[0];
        
        // create 2 new stacks
        Stack<Character> first = new ListStack<Character>();
		Queue<Character> second = new ArrayQueue<Character>();
		
		// add elements from the strings into stacks
		for(int i = 0; i < input.length()/2; i++) {
			first.push(input.charAt(i));
			if (input.length() % 2 == 0) {
				second.add(input.charAt(input.length()/ 2 + i));
			} else {
				second.add(input.charAt(input.length()/ 2 + i + 1));
			}
			
		}
		
		// test if it's a palindrome
		boolean palindrome = true;
		int i = (input.length()/2);
		while (i >= 0) {
			if (first.pop() != second.remove()) {
				palindrome = false;
			}
			i--;
		}
        
		// print whether it's a palindrome or not
		if (palindrome) {
			System.out.println(input + " is a palindrome!");
		} else {
			System.out.println(input + " is not a palindrome...");
		}
    
	}
	
	public static String inputToBinary(int input) {
		int quotient = input;
		int remainder;
		String output = "";
		
		while (quotient != 0) {
			remainder = quotient % 2;
			quotient = (quotient)/ 2;
			output = Integer.toString(remainder) + output;
		}
		
		System.out.println(input + " is " + output + " in binary.");
		return output;
	}
	
}
