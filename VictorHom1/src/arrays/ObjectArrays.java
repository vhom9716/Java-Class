package arrays;

public class ObjectArrays {

	public ObjectArrays() {
		Object[] people = new Object[20];
		populate(people);
		people[0] = new Thing("coffee maker");
		for(Object p: people) {
			System.out.println(p);
		}
	}

	private void populate(Object[] people) {
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
	


}
