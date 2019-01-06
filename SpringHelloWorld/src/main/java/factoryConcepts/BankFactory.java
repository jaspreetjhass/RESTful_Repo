package factoryConcepts;

public class BankFactory {

	public static Bank getBank(String bankName) throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		return (Bank) Class.forName(bankName).newInstance();
	}


}
