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
	private String nickname;
	
	
	public Person(String fN, String lN, Borough home){
		firstName = fN;
		lastName = lN;
		this.home = home;
		this.hobby = Hobby.randomHobby();
		this.nickname = createNickname(firstName);
		friends = new Person[3];
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
		nickname = createNickname(firstName);
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
	
	//Takes all letters up to 2nd vowel and returns them.
	
	//Java is pass by value, meaning the parameters of a method are just values not references.
	//So if you change those values, the original objects is not affected
	//In this case, name will not be changed. In fact, nothing will can change
	//this.firstName via local variable name
	public static String createNickname(String name) {
		
		String nickname = name.substring(0, secondVowelPos(name));
		
		return nickname;
	}
	
	private static int secondVowelPos(String word) {
		boolean firstVowelFound = false; 
		boolean secondVowelFound = false;
		word = word.toLowerCase();
		int index = word.length();
		String[] vowels = {"a", "e", "i", "o", "u"}; 
		for(int i = 0; i < word.length(); i++) {
			for(int v = 0; v < vowels.length; v++) {
				if(word.substring(i,  i + 1).equals(vowels[v])) {
					if(firstVowelFound && !secondVowelFound) {
						index = i;
						secondVowelFound = true;
					}else {
						firstVowelFound = true;
					}
				}
			}
		}
		return index;
	}
	
	public String toString() {
		return "My name is " + firstName + " " + lastName + ". Call me " + nickname + " and I live in " + home + "." + " I like " + hobby;
	}
}
