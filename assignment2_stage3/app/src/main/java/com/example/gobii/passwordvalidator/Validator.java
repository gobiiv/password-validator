package com.example.gobii.passwordvalidator;

public class Validator{
	// fields

	// constructor method
	public Validator(){
	}

	// validate method to check if string is a sufficiently strong password
	public int validate(String s){

		// This returns the sum of successful rules
		return (validateRule1(s)
				+ validateRule2(s)
				+ validateRule3(s)
				+ validateRule4(s)
				+ validateRule5(s));
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

	public int validateRule3(String s){
		// rule 3: check if the password contains a number
		// 0 (char) = 48, 9 (char) = 57
		for (char c: s.toCharArray()){
			if (c >= 48 && c <= 57){
				return 1; //success
			}
		}
		return 0; //fail
	}

	public int validateRule4(String s){
		// rule 4: check if the password contains an upper case character
		// A (char) = 65, Z (char) = 90
		for (char c: s.toCharArray()){
			if (c >= 65 && c <= 90){
				return 1; //success
			}
		}
		return 0; //fail
	}

	public int validateRule5(String s){
		// rule 5: check if the password is less than 15 characters
		if (s.length() < 16) {
			return 1; //success
		} else {
			return 0; //fail
		}
	}

}