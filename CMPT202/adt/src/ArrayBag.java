/**
 * An array-based bag of infinite capacity.
 *
 * @author Greg Gagne
 *
 */
public class ArrayBag implements Bag {
	public static final int CAPACITY_MULTIPLIER = 2;
	public static final int DEFAULT_CAPACITY = 15;
	
	private int capacity = 0;
	private int numberOfElements = 0;
	private Object[] elements;
	
	public ArrayBag() {
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayBag(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Capacity must be >= 0");
		}
		
		this.capacity = capacity;
		elements = new Object[capacity];
	}

	public void add(Object element) {
		ensureCapacity();
		elements[numberOfElements] = element;
		numberOfElements++;
	}

	public void addAll(Object[] elements) {
		for (int i = 0; i < elements.length; i++) {
			add(elements[i]);	
		}

	}

	public boolean contains(Object element) {
		if (indexOf(element) > -1)
			return true;
		else
			return false;
	}

	public int getSize() {
		return numberOfElements;
	}

	public void remove(Object element) {
		int index = indexOf(element);
		
		if (index > -1) {
			numberOfElements--;
			elements[index] = elements[numberOfElements];
		}

		return;
	}
	
	/**
	 * Returns the index of a specified element, 
	 * or -1 if the element is not present in the array.
	 */
	private int indexOf(Object element) {
		int index = -1;
		for (int i = 0; i < numberOfElements; i++) {
			if (elements[i].equals(element)) {
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	/**
	 * This ensures the array has sufficient capacity to store an additional element.
	 * 
	 * If the bag is full, a new array is created that is CAPACITY_MULTIPLIER times
	 * larger than the original array. All existing elements are copied to the
	 * new array.
	 */
	private void ensureCapacity() {
		if (numberOfElements == capacity) {
			Object[] newArray = new Object[(numberOfElements+1) * CAPACITY_MULTIPLIER];
			System.arraycopy(elements,0,newArray,0,numberOfElements);
			elements = newArray;
		}
	}

}
