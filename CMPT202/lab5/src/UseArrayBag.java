import java.util.Iterator;

public class UseArrayBag {
	
	 public static void main(String[] args) {
		 ArrayBag<String> ab = new ArrayBag<String>();
		 
		 ab.add("Apple");
		 ab.add("Banana");
		 ab.add("Cherry");
		 ab.add("Donut");
		 ab.add("Eggs");
		 
		 Iterator iter = ab.iterator();
		 
		 while(iter.hasNext()) {
			 System.out.println(iter.next());
		 }
		 
	 }
	 
}
