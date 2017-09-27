package attendance;

public class Student implements Attendee {

	private String firstName;
	private String lastName;
	private boolean present;
	
	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public boolean isPresent() {
		if(this.present) {
			return true;
		}
		return false;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public boolean mathces(String first, String last) {
		if(this.firstName.toUpperCase().equals(first.toUpperCase()) && this.lastName.toUpperCase().equals(last.toUpperCase())) {
			return true;
		}
		return false;
	}

	public boolean matches(String last) {
		if(this.lastName.toUpperCase().equals(last.toUpperCase())) {
			return true;
		}
		return false;
	}

	public String getReportString() {
		String reportString = "";
		String trunFirstName = this.firstName;
		String trunLastName = this.lastName;
		
		if(trunFirstName.length() > 20) {
			trunFirstName = trunFirstName.substring(0, 20);
			trunFirstName = trunFirstName.substring(0, 17) + "...";
		}else {
			while(trunFirstName.length() < 20) {
				trunFirstName += " ";
			}
		}
		
		if(trunLastName.length() > 20) {
			trunLastName = trunLastName.substring(0, 20);
			trunLastName = trunLastName.substring(0, 17) + "...";
		}else {
			while(trunLastName.length() < 20) {
				trunLastName += " ";
			}
		}
		if(this.present) {
			reportString = trunFirstName + trunLastName + "PRESENT";
			
			while(reportString.length() < 60) {
				reportString += " ";
			}
			
		}else {
			reportString = trunFirstName + trunLastName + "ABSENT";
			while(reportString.length() < 60) {
				reportString += " ";
			}
		}
		return reportString;
	}
}
