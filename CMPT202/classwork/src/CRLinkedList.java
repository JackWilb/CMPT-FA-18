
public class CRLinkedList implements CR{

	private int numCrimes = 0;
	Node head;
	
	private class Node {
		String crime;
		Node nextNode;
		
	}
	
	@Override
	public void add(String crime) {
		Node newCrime = new Node();
		newCrime.crime = crime;
		newCrime.nextNode = null;
		
		if (head == null) {
			head = newCrime;
		} else {
			newCrime.nextNode = head;
			head = newCrime;
		}
		numCrimes++;
	}

	@Override
	public boolean contains(String crime) {
		Node currentNode = head;
		for (int i = 0; i < numCrimes; i++) {
			if (currentNode.crime.equals(crime)) {
				return true;
			} else {
				currentNode = currentNode.nextNode;
			}
		}
		return false;
	}

}
