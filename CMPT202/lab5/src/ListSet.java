import java.util.ArrayList;
import java.util.Iterator;

// ListSet by Jack Wilburn and Greg Nola
// Date Sep 2018

// ListSet implementation of Set class with Iterator
public class ListSet<T> implements Set<T> {
	
	private ArrayList<T> elements;
	
	public ListSet() {
		elements = new ArrayList<T>();
	}

	public ListSet(int size) {
		elements = new ArrayList<T>(size);
	}
	
	@Override
	public void add(T element) {
		if (!contains(element) && element != null) {
			elements.add(element);
		}
	}

	@Override
	public void addAll(T[] newElements) {
		for (T i :newElements) {
			this.add(i);
		}
	}

	@Override
	public boolean contains(T element) {
		return elements.contains(element);
	}

	@Override
	public int getSize() {
		return elements.size();
	}

	@Override
	public void remove(T element) {
		elements.remove(element);
	}

	@Override
	public Set<T> union(Set<T> anotherSet) {
		Set<T> newSet = anotherSet.difference(this);
		newSet.addAll((T[]) this.elements.toArray());
		return newSet;
	}

	@Override
	public Set<T> intersection(Set<T> anotherSet) {
		Set<T> newSet = new ListSet<T>();
		for (T i : this.elements) {
			if (anotherSet.contains(i)) {
				newSet.add(i);
			}
		}
		return newSet;
	}

	@Override
	public Set<T> difference(Set<T> anotherSet) {
		Set<T> newSet = new ListSet<T>();
		for (T i : this.elements) {
			if (!anotherSet.contains(i)) {
				newSet.add(i);
			}
		}
		return newSet;
	}

	@Override
	public Iterator<T> iterator() {
		return elements.iterator();
	}
	
	
	
}
