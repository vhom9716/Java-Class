package arrays;

public class Hobby extends Thing {

	public Hobby(String description) {
		super(description);
	}

	public static Hobby randomHobby() {
		Hobby[] someHobbies = {new Hobby("playing basketball"), new Hobby("programming"), new Hobby("reading"), new Hobby("playing video games"), new Hobby("dancing")};
		return someHobbies[(int) (Math.random() * someHobbies.length)];
	}
}
