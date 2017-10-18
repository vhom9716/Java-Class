package arrays;

public class Student extends Person{

	public static final String[] grades = {"Freshman", "Sophomore", "Junior", "Senior"};
	
	public String grade;
	
	public Student(String fN, String lN, Borough home, int gradeLevel) {
		super(fN, lN, home); //super constructor is first because a student must exist before a student can
		int index = gradeLevel - 9;
		this.grade = grades[index];
	}
	
	public String toString() {
		//NOTE: if you want to call the parent method, use super.toString()
		return super.toString() + " I am also a " + grade + ".";
	}
}
