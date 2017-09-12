package intro;

//class is a file describing a new data type
public class CodingConventions {
	
	
	//fields do not instantiate here 
	private String name;
	private String description;
	
	/*
	//this is a special method, a "constructor"
	//notice it does not have a return type
	//that is because the thing it returns is an instance of a class
	//therefore the name of a constructor must always match the name of the class
	*/
	
	public CodingConventions(){
		//In Java , fields are instantiated in a constructor
		name = "Mr. Nockles";
		description = "is a teacher";
	}
}
