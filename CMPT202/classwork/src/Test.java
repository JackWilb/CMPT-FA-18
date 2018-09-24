
public class Test {

	public static void main(String[] args) {
		CR Greg_Nola = new CRLinkedList();
		Greg_Nola.add("Loitering with intent to talk about finance.");
		System.out.println(Greg_Nola.contains("Loitering with intent to talk about finance."));
		System.out.println(Greg_Nola.contains("Blockchain trading."));
	}

}
