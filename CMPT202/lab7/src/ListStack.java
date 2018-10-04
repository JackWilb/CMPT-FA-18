// Jack Wilburn and Greg Nola

import java.util.ArrayList;

public class ListStack<T> implements Stack<T> {

	private int index = 0;
	private ArrayList<T> elements = new ArrayList<T>();
	
	public ListStack() {
		
	}
	
	@Override
	public void push(T item) {
		this.elements.add(index, item);
		index++;
	}

	@Override
	public T pop() {
		if (!this.isEmpty()) {
			T output = this.elements.get(index-1);
			index--;
			return output;
		}
		return null;
	}

	@Override
	public T peek() {
		if (!this.isEmpty()) {
			return this.elements.get(index-1);
		}
		return null;
		
	}

	@Override
	public boolean isEmpty() {
		return index == 0;
	}

}
