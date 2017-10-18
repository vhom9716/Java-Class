package arrays;

public class Borough {

	public static final Borough[] NY_BOROUGHS = {new Borough("Queens"), new Borough("Manhattan"), new Borough("Bronx"), new Borough("Brooklyn"), new Borough("Staten Island")};

	
	private String name;
	
	public Borough(String s) {
		name = s;
	}

	public String toString() {
		return name;
	}
}
