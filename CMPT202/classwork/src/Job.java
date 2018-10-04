/**
 * Job class
 *
 * These items can be placed into a priority queue
 */

public class Job implements Comparable<Job>
{
	/* the relative priorities of different jobs */
	public enum Priority {HIGH, MEDIUM, LOW};

	private String title;
	private Priority priority;

	public Job(String title, Priority priority) {
		this.title = title;
		this.priority = priority;
	}
	
	
	public String toString() {
		String importance;

		if (priority == Priority.HIGH)
			importance = "HIGH";
		else if (priority == Priority.MEDIUM)
			importance = "MEDIUM";
		else
			importance = "LOW";
			
		return "Title: " + title + " Importance: " + importance;
	}

	/**
	 * This specifies the natural ordering of jobs.
	 */
	public int compareTo(Job other) {
		int priorityLeft = 0;
		int priorityRight = 0;
		
		if (this.priority == Priority.HIGH)
			priorityLeft = 2;
		else if (this.priority == Priority.MEDIUM)
			priorityLeft = 1;
		
		if (other.priority == Priority.HIGH)
			priorityRight = 2;
		else if (other.priority == Priority.MEDIUM)
			priorityRight = 1;
		
		return priorityLeft - priorityRight;
	}
}
