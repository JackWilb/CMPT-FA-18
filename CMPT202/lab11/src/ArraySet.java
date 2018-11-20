import java.util.Iterator;

// ArraySet by Jack Wilburn and Greg Nola
// Date Sep 2018

// ArraySet implementation of Set class with Iterator
public class ArraySet<T> implements Set<T> {
	
	// Initialize variables
	public static final int CAPACITY_MULTIPLIER = 2;
	public static final int DEFAULT_CAPACITY = 15;
	
	private int size = 0;
	private int numberOfElements = 0;
	private T[] elements;
	
	// Without size parameter create an ArraySet of default size
	public ArraySet() {
		this(DEFAULT_CAPACITY);
	}
	
	// Create ArraySet of specified size
	public ArraySet(int size) {
		if (size < 0) {
			throw new IllegalArgumentException("Capacity must be >= 0");
		} else {
			this.size = size;
			elements = (T[]) (new Object[size]);
		}
	}
	
	
	// Method to add item to an ArraySet
	public void add(T element) {
		ensureCapacity();
		if (!contains(element) && element != null) {
			elements[numberOfElements] = element;
				numberOfElements++;
		}
		
	}

	// Method to add a whole array to the ArraySet
	public void addAll(T[] elements) {
		for (int i = 0; i < elements.length; i++) {
			add(elements[i]);	
		}
	}

	// Method to see if ArraySet contains an element
	public boolean contains(T element) {
		if (indexOf(element) > -1)
			return true;
		else
			return false;
	}

	// Method to getsize of an ArraySet
	public int getSize() {
		return numberOfElements;
	}

	// Method to remove an element from an Array
	public void remove(T element) {
		int index = indexOf(element);
		
		if (index > -1 && element != null) {
			numberOfElements--;
			elements[index] = elements[numberOfElements];
		}

		return;
		
	}

	// Unions 2 Sets
	public Set<T> union(Set<T> anotherSet) {
		Set<T> newSet = anotherSet.difference(this);
		newSet.addAll(this.elements);
		return newSet;
	}

	// Intersects 2 sets
	public Set<T> intersection(Set<T> anotherSet) {
		Set<T> newSet = new ArraySet<T>();
		for (T i : this.elements) {
			if (anotherSet.contains(i)) {
				newSet.add(i);
			}
		}
		return newSet;
	}

	// Difference anotherSet \ this
	public Set<T> difference(Set<T> anotherSet) {
		Set<T> newSet = new ArraySet<T>();
		for (T i : this.elements) {
			if (!anotherSet.contains(i)) {
				newSet.add(i);
			}
		}
		return newSet;
	}
	
	// Return index of an object
	private int indexOf(T element) {
		int index = -1;
		if (element != null) {
			for (int i = 0; i < numberOfElements; i++) {
				if (elements[i].equals(element)) {
					index = i;
					break;
				}
			}
		}
		
		
		return index;
	}
	
	// Ensures that there is enough space for a new element or expands the arrray
	private void ensureCapacity() {
		if (numberOfElements == size) {
			T[] newArray = (T[]) new Object[(numberOfElements+1) * CAPACITY_MULTIPLIER];
			System.arraycopy(elements,0,newArray,0,numberOfElements);
			elements = newArray;
		}
	}
	
	
	// new code
	
	
	// Make new iterator
	public Iterator<T> iterator() {
		return new ArraySetIterator();
	}
	
	/**
	 * Inner class that generates an iteration of the set.
	 */
	private class ArraySetIterator implements Iterator<T>
	{
		private int index = 0;
		
		/**
		 * Determines if there are more elements
		 * in the iteration.
		 * 
		 * @return true if there are more elements, false otherwise.
		 */
		public boolean hasNext() {
			return (index < numberOfElements);
		}

		/**
		 * Returns the next element in the iteration.
		 * 
		 * @throws java.util.NoSuchElementException if there are no more elements in the iteration.
		 */
		public T next() {
			if (hasNext()) {
				T nextItem = elements[index];
				index++;
				
				return nextItem;
			}
			else
				throw new java.util.NoSuchElementException("No items remaining in the iteration.");
			
		}
		
	}
	
}
