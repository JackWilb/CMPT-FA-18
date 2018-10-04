import java.util.ArrayList;

public class ListQueue<T> implements Queue<T> {

	private ArrayList<T> elements = new ArrayList<T>();
	
	public ListQueue() {
		
	}
	
	@Override
	public void add(T item) {
		elements.add(item);
	}

	@Override
	public T remove() {
		if (this.size() == 0) {
			return null;
		} else {
			return elements.remove(0);
		}
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return elements.size() == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return elements.size();
	}



}
