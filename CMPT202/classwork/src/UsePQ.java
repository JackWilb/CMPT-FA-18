
/**
 * Example usage of priority queue in java api.
 */

public class UsePQ
{
	public static final int SIZE = 6;

	public static void main(String[] args) {
		
		java.util.PriorityQueue<Job> pq = new java.util.PriorityQueue<Job>();
		Job[] workers = new Job[SIZE];

		workers[0] = new Job("Doctor", Job.Priority.MEDIUM);
		workers[1] = new Job("Lawyer", Job.Priority.LOW);
		workers[2] = new Job("Indian Chief", Job.Priority.HIGH);
		workers[3] = new Job("Java Developer", Job.Priority.HIGH);
		workers[4] = new Job("MIS Manager", Job.Priority.HIGH);
		workers[5] = new Job("Embezzler", Job.Priority.LOW);

		for (int i = 0; i < SIZE; i++)
			pq.add(workers[i]);

		while (!pq.isEmpty())
			System.out.println(pq.remove());
		
		
	}
	
}
