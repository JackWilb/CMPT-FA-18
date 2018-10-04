// example usage of priority queue

public class PriorityQueueExample {

	public static void main(String[] args) {
		java.util.PriorityQueue<Integer> pq1 = new java.util.PriorityQueue<Integer>();
		
		pq1.add(15);
		pq1.add(10);
		pq1.add(-5);
		pq1.add(12);
		
		while (!pq1.isEmpty())
			System.out.println(pq1.remove());

	}

}
