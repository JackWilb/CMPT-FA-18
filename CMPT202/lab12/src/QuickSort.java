
public class QuickSort <T extends Comparable<? super T>> extends SortingAlgorithm <T> {
	
	void quicksort(T[] a, int left, int right)
	{
	    int l = left;
	    int r = right;

	    T pivot = a[right];

	    while (l <= r)
	    {
	        while (a[l].compareTo(pivot) < 0)
	            l++;

	        while (a[r].compareTo(pivot) > 0)
	            r--;

	        if (l <= r)
	        {
	            swap(a, l, r);

	            l++;
	            r--;
	        }
	        }

	   // call quick sort recursively
	   if (left < r)
	       quicksort(a, left, r);

	   if (l < right)
	       quicksort(a, l, right);
	}

	@Override
	public void sort(T[] array) {
		// TODO Auto-generated method stub
		quicksort(array, 0, array.length-1);
	}
}
