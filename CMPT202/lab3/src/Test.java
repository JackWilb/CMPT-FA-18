
public class Test {

	public static void main(String[] args) {
		String a[] = {"ada", "lovelace"};
		ArrayIterator<String> iter = new ArrayIterator<String>(a);
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
