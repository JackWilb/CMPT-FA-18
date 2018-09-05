import java.util.ArrayList;

public class ArrayListBag implements Bag {
	public static final int CAPACITY_MULTIPLIER = 2;
	public static final int DEFAULT_CAPACITY = 15;
	
	private int capacity = 0;
	private int numberOfElements = 0;
	private ArrayList elements;
	
	public ArrayListBag() {
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayListBag(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Capacity must be >= 0");
		}
		
		this.capacity = capacity;
		elements = new ArrayList(capacity);
	}
	
	public void add(Object element) {
		elements.add(numberOfElements, element);
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
			elements.remove(index);
		}

		return;
	}
	
	public int indexOf(Object element) {
		return elements.indexOf(element);
	}
}