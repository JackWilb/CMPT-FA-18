package quiz4;

import java.util.PriorityQueue;

public class Quiz4main {

	public static void main(String args[]) {
		System.out.println(mystery(5));
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(6);
		pq.add(5);
		pq.add(4);
		pq.add(3);
		pq.add(2);
		pq.add(1);
		pq.add(7);
		pq.add(8);
		
		for (int a : pq) {
			System.out.println(a);
		}
	}
	
	public static int mystery(int n) {
		if (n <2)
			return 1;
		else
			return mystery(n-1) + mystery(n-2);
	}
}
