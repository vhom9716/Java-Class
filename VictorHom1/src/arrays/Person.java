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
	private Hobby hobby;
	private Person[] friends;
	
	
	public Person(String fN, String lN, Borough home){
		firstName = fN;
		lastName = lN;
		this.home = home;
		this.hobby = Hobby.randomHobby();
		friends = new Person[3];
	}
	
	//Chooses friends from people based on who is of same class as this instance and who has the same hobbies
	public void mingle(Person[] people) {
		System.out.print("I am in he class " + this.getClass());
		for(Person p: people) {
			if(p != this) {
				p = betterFriend(p, friends[0]);
				addFriendToFirstPlace(p);
			}
		}
	}
	
	private Person betterFriend(Person p, Person q) {
		if(p == null) {
			return q;
		}
		if(q == null) {
			return p;
		}
		if(p.getClass() == q.getClass() && p.getClass( )== this.getClass()) {
			if(p.hobby == this.hobby) {
				return p;
			}
			if(q.hobby == this.hobby) {
				return q;
			}
		}
		if(p.getClass() == this.getClass()) {
			return p;
		}
		if(q.getClass() == this.getClass()) {
			return q;
		}
		//if none are true, just take p
		
		return p;
	}

	public void printFriends() {
		System.out.println("My name is " + firstName + " " + lastName + " and these are my friends:");
		for(Person d: friends) {
			if(d != null) {
				System.out.println(d);
			}
		}
	}
	//Moves all persons in friends back one index and puts p at index 0
	public void addFriendToFirstPlace(Person p) {
		for(int i = friends.length - 1; i > 0; i--) {
			friends[i] = friends[i - 1];
		}
		friends[0] = p;
	}
	
	public String toString() {
		return "My name is " + firstName + " " + lastName + " and I live in " + home + "." + " I like " + hobby;
	}
}
