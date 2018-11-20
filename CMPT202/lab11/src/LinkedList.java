/**
 * Implementation of the List interface.
 * 
 * This implementation involves a single-linked list.
 * 
 * @author Jack Wilburn and Greg Nola - September 2018
 *
 */
public class LinkedList<T> implements List<T> {
	// reference to the head of the linked list
	private Node head;

	// number of elements in the list
	private int numberOfElements;

	public LinkedList() {
		head = null;
	}

	/** 
	 * Inner class representing a node in the linked list
	 */

	private class Node
	{
		private T data;
		private Node next;

		private Node(T data) {
			this(data, null);
		}

		private Node (T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	// Methods

	@Override
	public void add(T item) {

		// adds (appends) an item to the rear of the list

		Node newNode = new Node(item);
		Node current = head;

		if (isEmpty()) {
			// special case - first element being added to the list
			head = newNode;
		}
		else {
			while (current.next != null) {
				current = current.next;
			}

			// current now references the last item in the list
			current.next = newNode;
		}

		newNode.next = null;
		++numberOfElements;
	}

	@Override
	public boolean add(T item, int index) {
		// Create 2 nodes, 1 to iterate through list and one to add into the list
		Node addition = new Node(item);
		Node current = head;
		
		// Go to the node before index
		for (int i = 0; i < index - 1; i++) {
			if (current.next == null) {
				return false;
			}
			current = current.next;
		}
		
		// If 0, copy head to 1 and change head data
		if (index == 0) {
			add(head.data,1);
			head.data = item;
		} else { // else update new pointer to old pointer and old pointer to new node
			addition.next = current.next;
			current.next = addition;
		}
		numberOfElements++;
		return true;
	}

	@Override
	public boolean contains(T item) {
		Node current = head;
		boolean found = false;

		while (current != null && !found) {
			if (current.data.equals(item)) {
				found = true;
			}

			current = current.next;
		}
		return found;

	}

	@Override
	public T get(int index) {
		// Set node to head so we can iterate through list
		Node current = head;
		
		// Iterate
		for (int i = 0; i < index; i++) {
			// if index is out of bounds then return null
			if (current.next == null) {
				return null;
			}
			current = current.next;
		}
		// return the data in the node at given index
		return current.data;
	}

	@Override
	public boolean remove(T item) {
		// if item is in the list find it and remove
		if (this.contains(item)) {
			Node current = head;
			for (int i = 0; i < this.getLength(); i++) {
				if (current.data == item) {
					remove(i);
					break;
				}
				current = current.next;
			}
			return true;
		} else {
			return false;
		}
	}

	@Override
	public T remove(int index) {
		T rv = null;

		if (isEmpty() || index >= numberOfElements) {
			rv = null;
		}
		else if (index == 0) {
			// special case - first element in the list
			rv = head.data;
			head = head.next;
			numberOfElements--;
		}
		else {
			int currentIndex = 0;
			Node current = head;

			while (currentIndex < (index - 1)) {
				current = current.next;
				currentIndex++;
			}

			// current references the node we want to remove
			rv = current.next.data;
			current.next = current.next.next;
			numberOfElements--;
		}

		return rv;
	}

	@Override
	public int getLength() {
		return numberOfElements;
	}

	@Override
	public boolean isEmpty() {
		// if no elements then it's empty
		return numberOfElements == 0;
	}
	
	@Override
	// Count how many times the item occurs in the list
	public int getFrequency(T item) {
		if(contains(item)) {
			int freq = 0;
			Node current = head;
			for (int i = 0; i < this.getLength(); i++) {
				if (current.data.equals(item)) {
					freq++;
				}
				current = current.next;
			}
			return freq;
		} else {
			return 0;
		}
	}

	@Override
	public void clear() {
		// set all to null and the number of elements to 0
		head.data = null;
		head.next = null;
		numberOfElements = 0;
	}

}
