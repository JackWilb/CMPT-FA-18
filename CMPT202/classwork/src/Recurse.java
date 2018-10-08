/**
 * Example program illustrating iterative and recursive
 * solutions to the incredibly simply problem of
 * printing out a list of numbers from n ... 1
 */

public class Recurse
{
 /**
  * Iterative version that prints out
  * a list of numbers from n .. 0
  */
 public static void iterative(int n) {
  for (int i = n; i >= 0; i--)
   System.out.println(i + " ");
 }

 /**
  * Recursive version that prints out
  * a list of numbers from 0 .. n
  */
 public static void recursive(int n) {
  if (n == 0)
   return;
  else {
   System.out.println("Before = " + n);
   recursive(n - 1);
   System.out.println("After = " + n);
  }
 } 



 public static void main(String args[]) {
  if (args.length != 1) {
   System.out.println("Usage: java Recurse <n>");
   System.exit(0);
  }

  recursive(Integer.parseInt(args[0]));
 }
}
