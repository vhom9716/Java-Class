package intro;

//class is a file describing a new data type
public class CodingConventions {
	
	
	//fields, do not instantiate here 
	private String name;
	private String description;
	
	/*
	//this is a special method, a "constructor"
	//notice it does not have a return type
	//that is because the thing it returns is an instance of a class
	//therefore the name of a constructor must always match the name of the class
	*/
	
	public CodingConventions(String name, int index){
		//In Java , fields are instantiated in a constructor
		
		//there is a local variable 'name' and a field name
		//the field persists, but the local data is destroyed at the end of the method
		//distinguish the field by using the reserved word "this"
		
		this.name = name;
		//static reference begins with a class name
		description = IntroMain.DESCRIPTIONS[index];
	}

	public void doStuff() {
		//static method call since the System is a class so it is not called on an individual instance but on the class
		System.out.println(name + description); //use space btwn operations
		//this is static since the method does not depend on the instance of 12, as all numbers can be square rooted 
		System.out.print("The square root of 12 is " + Math.sqrt(12));
	}
}
