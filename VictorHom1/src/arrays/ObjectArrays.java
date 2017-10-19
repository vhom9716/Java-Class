package arrays;

public class ObjectArrays {

	public ObjectArrays() {
		Person[] people = new Person[20];
		populate(people);
		testShuffling();		
		
		/**
		for(Person p: people) {
			p.mingle(people);
			p.printFriends();
			System.out.println("");
		}
	
		for(Person p: selectGroup(people, 6)) {
			System.out.println(p);
		} **/
	}

	public void testShuffling() {
		Person[] people = new Person[20];
		populate(people);
		double diff = countDifferences(selectGroup(people, people.length), people);
		double avg = diff/people.length;
		System.out.println(avg);
	}
	
	private void populate(Person[] people) {
		for(int i = 0; i < people.length; i++) {
			String firstName = randomNameFrom(Person.FIRST_START, Person.FIRST_MIDDLE, Person.FIRST_END);
			String lastName = randomNameFrom(Person.LAST_START, Person.LAST_MIDDLE, Person.LAST_END);
			//BIG IDEA
			//Object arrays (not primitive arrays) can have multiple data types 
			//in them(subclasses of the declared type)
			Borough b = randomBorough();
			if(Math.random() < .6) {
				int grade = (int)(Math.random()*4)+9;
				people[i] = new Student(firstName, lastName, b, grade);
			}else {
				people[i] = new Person(firstName, lastName, b);
			}

		}
	}

	private Borough randomBorough() {
		return Borough.NY_BOROUGHS[(int) (Math.random() * Borough.NY_BOROUGHS.length)];
	}

	private String randomNameFrom(String[] a, String[] b, String[] c) {
		return get(a) + get(b) + get(c);
	}

	private String get(String[] a) {
		return a[(int) (Math.random() * a.length)];
	}
	
	public Person[] selectGroup(Person[] parray, int length) {
		Person[] subGroup = new Person[length];
		for(int i = 0; i < length; i++) {
			Person nextPerson = selectAPerson(parray);
			while(isAlreadyIn(nextPerson, subGroup)) {
				nextPerson = selectAPerson(parray);
			}
			subGroup[i] = nextPerson;
		}
		return subGroup;
	}

	public double countDifferences(Person[] arr1, Person[] arr2) {
		double diff = 0;
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i] != arr2[i]) {
				diff++;
			}
		}
		return diff;
	}
	
	public static boolean isAlreadyIn(Person p, Person[] parr) {
		for(int i = 0;  i < parr.length; i++) {
			if(parr[i] == p) {
				return true;
			}
		}
		return false;
	}
	
	public Person selectAPerson(Person[] group) {
		int sel = (int) (Math.random() * group.length);
		return group[sel];
	}
}
