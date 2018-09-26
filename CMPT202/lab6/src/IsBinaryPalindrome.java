//Jack Wilburn and Greg Nola

public class IsBinaryPalindrome
{
	public static void main(String[] args) {
		
		if (args.length == 0) {
			System.out.println("Please supply a decimal number as an arguemnt.");
			System.exit(0);
		}
		
		
		
		String message = null;
		int input;

		// messages out
		input = Integer.parseInt(args[0]);
		message = inputToBinary(input);
        if (message.length() == 0) {
        	System.out.println("Please provide an integer greater than 0");
        	System.exit(0);
        }
        
        // create 2 new stacks
        Stack<Character> first = new ListStack<Character>();
		Stack<Character> second = new ArrayStack<Character>();
		
		// add elements from the strings into stacks
		int i = 0;
		while(i < message.length()/2) {
			first.push(message.charAt(i));
    		second.push(message.charAt(message.length() - 1 - i));
    		i++;
		}
		
		// test if it's a palindrome
		boolean palindrome = true;
		while (i >= 0) {
			if (first.pop() != second.pop()) {
				palindrome = false;
			}
			i--;
		}
        
		// print whether it's a palindrome or not
		if (palindrome) {
			System.out.println("Thus it is a palindrome in binary!");
		} else {
			System.out.println("Thus it is not a palindrome in binary...");
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


