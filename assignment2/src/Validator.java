public class Validator{
	//fields

	//constructor method
	public Validator(){
	}

	//validate method to check if string is a sufficiently storng password
	public int validate(String s){
		int pass = 0;

		//This is the series of if statements to apply an error message.

		//rule 1: check if the password is not listed as 'password'
		if (! ( s.equalsIgnoreCase("password") ) ){ 
			pass ++;
		}

		//rule 2: check if the password is atleast 8 charcters long.
		if (s.length() > 7) {
			pass ++;
		}

		return pass;
	}

}