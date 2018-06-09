public class Validator{
	//fields

	//constructor method
	public Validator(){
	}

	// validate method to check if string is a sufficiently strong password
	public int validate(String s){

		// This returns the sum of successful rules
		return (validateRule1(s)
				+ validateRule2(s));
	}

	public int validateRule1(String s){
		// rule 1: check if the password is not listed as 'password'
		// case insensitive
		if (! ( s.equalsIgnoreCase("password") ) ){ 
			return 1; //success
		} else {
			return 0; //fail
		}
	}

	public int validateRule2(String s){
		// rule 2: check if the password is at least 8 characters long
		if (s.length() > 7) {
			return 1; //success
		} else {
			return 0; //fail
		}
	}	
	
	
}