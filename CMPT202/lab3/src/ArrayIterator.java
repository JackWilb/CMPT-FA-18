import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
		T inputArray[];
		int i;
		
		public ArrayIterator(Object[] inputArray) {
			this.inputArray = (T[]) inputArray;
			i = -1;
			
		}
		
		public boolean hasNext() {
			return !(i + 1 == inputArray.length || inputArray[i + 1] == null);
		}
		
		public T next() {
			if (this.hasNext()) {
				return inputArray[++i];
			}
			return null;
		}
}
