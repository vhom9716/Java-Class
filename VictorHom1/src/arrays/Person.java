package arrays;

public class Person {

	public static final String[] FIRST_START = {"Chr", "M", "L", "Gre", "Ph", "B", "Th"};
	public static final String[] FIRST_MIDDLE = {"isti", "icha", "era", "eta", "ala", "ina", "ara"};
	public static final String[] FIRST_END = {"", "na", "n", "r", "tian", "s", "rs", "mp", "les"};
	
	public static final String[] LAST_START = {"Ch", "M", "L", "Ca", "Ph", "B", "Th"};
	public static final String[] LAST_MIDDLE = {"om", "ohn", "era", "et", "ola", "e", "is", "ar"};
	public static final String[] LAST_END = {"", "son", "ers", "rian", "ston", "s", "ck", "sk"};
	
	private String firstName;
	private String lastName;
	private Borough home;
	
	public Person(String fN, String lN, Borough home){
		firstName = fN;
		lastName = lN;
		this.home = home;
	}
	
	public String toString() {
		return "My name is " + firstName + " " + lastName + " and I live in " + home + ".";
	}
}
