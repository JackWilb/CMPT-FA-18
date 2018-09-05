// ArraySet by Jack Wilburn and Amin Abdinasir
// Date Sep 2018

// ArraySet implementation of Set class
public class ArraySet implements Set {
	
	// Initialize variables
	public static final int CAPACITY_MULTIPLIER = 2;
	public static final int DEFAULT_CAPACITY = 15;
	
	private int size = 0;
	private int numberOfElements = 0;
	private Object[] elements;
	
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
			elements = new Object[size];
		}
	}
	
	
	// Method to add item to an ArraySet
	public void add(Object element) {
		ensureCapacity();
		if (!contains(element) && element != null) {
			elements[numberOfElements] = element;
				numberOfElements++;
		}
		
	}

	// Method to add a whole array to the ArraySet
	public void addAll(Object[] elements) {
		for (int i = 0; i < elements.length; i++) {
			add(elements[i]);	
		}
	}

	// Method to see if ArraySet contains an element
	public boolean contains(Object element) {
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
	public void remove(Object element) {
		int index = indexOf(element);
		
		if (index > -1 && element != null) {
			numberOfElements--;
			elements[index] = elements[numberOfElements];
		}

		return;
		
	}

	// Unions 2 Sets
	public Set union(Set anotherSet) {
		Set newSet = anotherSet.difference(this);
		newSet.addAll(this.elements);
		return newSet;
	}

	// Intersects 2 sets
	public Set intersection(Set anotherSet) {
		Set newSet = new ArraySet();
		for (Object i : this.elements) {
			if (anotherSet.contains(i)) {
				newSet.add(i);
			}
		}
		return newSet;
	}

	// Difference anotherSet \ this
	public Set difference(Set anotherSet) {
		Set newSet = new ArraySet();
		for (Object i : this.elements) {
			if (!anotherSet.contains(i)) {
				newSet.add(i);
			}
		}
		return newSet;
	}
	
	// Return index of an object
	private int indexOf(Object element) {
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
			Object[] newArray = new Object[(numberOfElements+1) * CAPACITY_MULTIPLIER];
			System.arraycopy(elements,0,newArray,0,numberOfElements);
			elements = newArray;
		}
	}
	
}
