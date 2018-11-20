
public class Sorter {
	public static <T extends Comparable<? super T>> void sort(T[] a, int start, int stop) {
		//base case
		if (Math.abs(start-stop) == 0) {
			return;
		} else { //recursive step
			int pivot = stop;
			
			while (start < pivot) {
				swapIfBigger(a, start, pivot-1);
				swapIfBigger(a, pivot-1, pivot);
				
				pivot = pivot - 1;
			}
			
			
			sort(a, start, pivot);
			sort(a, pivot+1, stop);
		}
	}
	
	public static <T extends Comparable<? super T>> boolean swapIfBigger(T[] a, int left, int right) {
		if (a[left].compareTo(a[right]) > 0) {
			T temp = a[left];
			a[left] = a[right];
			a[right] = temp;
			return true;
		}
		
		return false;
	}
}
