/**
 * Jack Wilburn and Greg Nola
 */

import java.util.Scanner;

public class PalindromeChecker
{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String message = null;

		do {
			// messages out
			System.out.println("Enter a string:");
			message = scan.nextLine();
            if (message.length() == 0) {
            	break;
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
    			System.out.println(message + " is a palindrome!");
    		} else {
    			System.out.println(message + " is not a palindrome...");
    		}
            
		}
		while (message.length() != 0);
		
		scan.close();
	}
}
