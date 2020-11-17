import java.util.Random;

public abstract class Algorithm  < T extends Comparable < ? super T > >  {

	public abstract void apply(T[] array);
	
	public long  time(T[] array) {
        long start, end;
          start = System.currentTimeMillis();
         
          // invoke the apply method
          this.apply(array);
         
          end = System.currentTimeMillis();

          // returns elapsed time
          return  (end - start);
    }
	
	public static Integer[] createRandomArray(int n) {
		Integer[] ints = new Integer[n];
		Random generator = new Random();
		
		for (int i = 0; i < ints.length; i++) {
			ints[i] = generator.nextInt();
		}
		
		return ints;
	}
}
