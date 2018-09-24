
public class CRArray implements CR{

	private String[] records = new String[100];
	private int numberOfCrimes = 0;
	
	@Override
	public void add(String crime) {
		records[numberOfCrimes] = crime;
		numberOfCrimes++;
	}

	@Override
	public boolean contains(String crime) {
		for (int i = 0; i < numberOfCrimes; i++) {
			if (records[i].equals(crime)) {
				return true;
			}
		}
		return false;
	}

}
