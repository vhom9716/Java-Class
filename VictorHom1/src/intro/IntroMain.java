package intro;//this is a package declaration

//this is a class header(class declaration)
public class IntroMain {

	//constants are public
	public static final String[] DESCRIPTIONS = {" is a teacher", 
			" is a student", 
			" is a human being", 
			" is imaginary"};	
	
	public static void main(String[] args) {
		//declaration of a local variable
		//notice use of the word 'new' 
		//new must be used to call a constructor
		CodingConventions conventionsInstance  = new CodingConventions("Mr.Nocles",2);
		
		//instance method call as it is called from an individual instance of the object CodingConventions
		//dependent on the individual instance
		conventionsInstance.doStuff();
	}

}
