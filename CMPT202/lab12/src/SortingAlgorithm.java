
public abstract class SortingAlgorithm <T extends Comparable <? super T>> extends Algorithm <T> {

	public abstract void sort (T[] array);
	static final int NUMBER = 4;
	
	public void apply(T[] array) {
	    this.sort(array);
	}
	
	public static <T extends Comparable<? super T>> boolean isSorted(Comparable[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i].compareTo(array[i-1]) < 0)
				return false;
		}
		return true;
	}
	
	protected static void swap(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp; 
	} 
	
	public static void compareSorts(int n) {
		Integer[] array = createRandomArray(n);
		Integer[][] sortArray = new Integer[NUMBER][n];
		System.arraycopy(array, 0, sortArray[0], 0, array.length);
		System.arraycopy(array, 0, sortArray[1], 0, array.length);
	    System.arraycopy(array, 0, sortArray[2], 0, array.length);
	    System.arraycopy(array, 0, sortArray[3], 0, array.length);
	     
		SortingAlgorithm[] sorts = new SortingAlgorithm[NUMBER];
		

		sorts[0] = new SelectionSort();
		sorts[1] = new InsertionSort();
		sorts[2] = new MergeSort();
		sorts[3] = new QuickSort();
		
		for (int i=0; i < sorts.length; i++) {
			System.out.print(sorts[i].time(sortArray[i]) + ", ");
		}
		System.out.print("\n");
	}
}
