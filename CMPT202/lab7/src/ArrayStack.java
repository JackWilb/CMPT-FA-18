// Jack Wilburn and Greg Nola

public class ArrayStack<T> implements Stack<T> {
	
	private static final int multiplier = 2;
	private static final int DEFAULT_CAPACITY = 10;
	
	private int index = 0;
	private int capacity;
	private T[] elements;
	
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}
	
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Capacity must be >= 0");
		}
		
		this.capacity = capacity;
		elements = (T[])new Object[capacity];
	}
	
	@Override
	public void push(T item) {
		this.ensureCapacity();
		this.elements[this.index] = item;
		index++;
	}

	@Override
	public T pop() {
		if (!this.isEmpty()) {
			return this.elements[--this.index];
		}
		return null;
	}

	@Override
	public T peek() {
		if (!this.isEmpty()) {
			return this.elements[this.index-1];
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return this.index == 0;
	}
	
	private void ensureCapacity() {
		if (this.index == this.capacity) {
			@SuppressWarnings("unchecked")
			T[] newArray = (T[])new Object[(this.index+1) * multiplier];
			System.arraycopy(this.elements,0,newArray,0,this.index);
			this.elements = newArray;
			this.capacity = capacity * multiplier;
		}
	}

}
