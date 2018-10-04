
public class ArrayQueue<T> implements Queue<T> {

	private static int defaultCap = 10;
	private static int multiplier = 2;
	private int numberOfElements = 0;
	private int front = 0;
	private int rear = 0;
	private int arraySize = 0;
	private T[] elements;

	public ArrayQueue() {
		this(defaultCap);
	}

	@SuppressWarnings("unchecked")
	public ArrayQueue(int size) {
		elements = (T[]) new Object[size];
		arraySize = size;
	}
	
	@Override
	public void add(T item) {
		ensureCapacity();
		elements[rear] = item;
		rear = (++rear) % (arraySize);
		numberOfElements++;
	}

	@Override
	public T remove() {
		T output = elements[front];
		elements[front] = null;
		front = (++front) % (arraySize);
		numberOfElements--;
		return output;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return numberOfElements == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return numberOfElements;
	}

	private void ensureCapacity() {
		if((front - rear == 0) && elements[front] != null) {
			T[] newArray = (T[]) new Object[arraySize * multiplier];
			
			for(int i = 0; i < arraySize; i++) {
				newArray[((front + i) % arraySize)] = elements[i];
			}
			
			elements = newArray;
			rear = arraySize;
			front = 0;
			arraySize = arraySize * multiplier;
			
		} else {
			return;
		}
		
	}
}
