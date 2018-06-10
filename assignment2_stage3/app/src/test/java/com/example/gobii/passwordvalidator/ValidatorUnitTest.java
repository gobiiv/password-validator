/*
this is the unit test for the validator class

 */
package com.example.gobii.passwordvalidator;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ValidatorUnitTest {
    static String str1 = "pASsWoRd"; //is 'password'
    static String str2 = "abcd"; //less than 8 chars
    static String str3 = "abcdefghi"; //does not contain number
    static String str4 = "abcd1234"; //does not contain upper case
    static String str5 = "abc def ghi jkl mno pqr"; //greater than 15 chars

    static String str6 = "hello world"; //is not 'password'
    static String str7 = "abcd12345"; //not less than 8 chars
    static String str8 = "abcdefgh3"; //contains number
    static String str9 = "aBcd1234"; //contains upper case
    static String str10 = "abc def ghi"; //not greater than 15 chars

    static String str11 = "Strong1234"; //success

    static Validator v;

    // rule 1: password is not listed as 'password'
    // 		case insensitive

    // rule 2: password is at least 8 characters long

    // rule 3: password contains a number
    // 		0 (char) = 48, 9 (char) = 57

    // rule 4: password contains an upper case character
    // 		A (char) = 65, Z (char) = 90

    // rule 5: password is less than 15 characters

    //this method initializes the validator class before running tests
    @BeforeClass
    public static void init() {
        v = new Validator();
    }

    //failed rule validations
    @Test
    public void isPassword() {
        //tests the result when password is entered with different case
        assertEquals(0, v.validateRule1(str1));
    }

    @Test
    public void lessThan8Chars() {
        //tests the result when a string of less than 8 characters is entered
        assertEquals(0, v.validateRule2(str2));
    }

    @Test
    public void doesNotContainNumber() {
        //tests the result when a string with no numbers is entered
        assertEquals(0, v.validateRule3(str3));
    }

    @Test
    public void doesNotContainUpperCase() {
        //tests the result when a string with no upper case letters is entered
        assertEquals(0, v.validateRule4(str4));
    }

    @Test
    public void greaterThan15Chars() {
        //tests the result when a string with more than 15 characters is entered
        assertEquals(0, v.validateRule5(str5));
    }

    //successful rule validations
    @Test
    public void isNotPassword() {
        //tests the result when 'password' is not entered
        assertEquals(1, v.validateRule1(str6));
    }

    @Test
    public void greaterThan7Chars() {
        //tests the result when a string with more than 7 characters is entered
        assertEquals(1, v.validateRule2(str7));
    }

    @Test
    public void containsNumber() {
        //tests the result when a string containing at least 1 number is entered
        assertEquals(1, v.validateRule3(str8));
    }

    @Test
    public void ContainsUpperCase() {
        //tests the result when a string containing at least 1 upper case letter
        // is entered
        assertEquals(1, v.validateRule4(str9));
    }

    @Test
    public void lessThan16Chars() {
        //tests the result when a string containing less than 16 characters is
        // entered
        assertEquals(1, v.validateRule5(str10));
    }

    @Test
    public void successTest() {
        //tests the result when a string representing a strong password is
        // entered
        assertEquals(5, v.validate(str11));
    }

}