
public class SorterMain {

	public static void main(String[] args) {
		String[] a = new String[6];
		a[0] = "f";
		a[1] = "e";
		a[2] = "d";
		a[3] = "c";
		a[4] = "b";
		a[5] = "a";
		Sorter.sort(a, 0, 5);
		for (String i : a) {
			System.out.println(i);
		}
	}

}
