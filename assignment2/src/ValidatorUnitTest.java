
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ValidatorUnitTest {
	static String str1 = "pASsWoRd"; //is 'password'
	static String str2 = "abcd"; //less than 8 chars
	
	static String str3 = "thisismypw"; //is not 'password'
	static String str4 = "hello1234"; //not less than 8 chars
		
	static String str5 = "strongpass"; //success
	
	static Validator v;
	
	// rule 1: password is not listed as 'password'
	// 		case insensitive
	
	// rule 2: password is at least 8 characters long
	
	
	@BeforeClass
	public static void init() {
		v = new Validator();
	}
	
	//failed rule validations
	@Test
	public void isPassword() {
		assertEquals(0, v.validateRule1(str1));
	}
	
	@Test
	public void lessThan8Chars() {
		assertEquals(0, v.validateRule2(str2));
	}
	
	//successful rule validations
	@Test
	public void isNotPassword() {
		assertEquals(1, v.validateRule1(str3));
	}
	
	@Test
	public void greaterThan7Chars() {
		assertEquals(1, v.validateRule2(str4));
	}	

	@Test
	public void successTest() {
		assertEquals(2, v.validate(str5));
	}	
}
