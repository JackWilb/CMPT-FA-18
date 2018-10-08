
class node {
		int i;
		public node next1;
		public node next2;
		public node(int i) {
			this.i = i;
		}
	}

public class LinkedListRecur {
	public static void main(String[] args) {
		node n6 = new node(6);
		node n5 = new node(5);
		node n4 = new node(4);
		node n3 = new node(3);
		node n2 = new node(2);
		node n1 = new node(1);
		
		n1.next1 = n2;
		n1.next2 = n3;
		n2.next1 = n6;
		n3.next1 = n4;
		n3.next2 = n5;
		
		printOut(n1);
		
	}
	
	public static void printOut(node current) {
		if (current == null) {
			return;
		} else {
			System.out.println(current.i);
			printOut(current.next1);
			printOut(current.next2);
		}
	}
	
}
