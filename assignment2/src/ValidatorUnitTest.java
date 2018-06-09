
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ValidatorUnitTest {
	static String str1 = "password";
	static String str2 = "PASSWORD";
	static String str3 = "pASsWoRd";
	
	static String str4 = "abcd";
	static String str5 = "HelloPassword!";
	
	static Validator v;
	
	@BeforeClass
	public static void init() {
		v = new Validator();
	}
	
	@Test
	public void notPassword1() {
		assertEquals(1, v.validate(str1));
	}
	
	@Test
	public void notPassword2() {
		assertEquals(1, v.validate(str2));
	}
	
	@Test
	public void notPassword3() {
		assertEquals(1, v.validate(str3));
	}
	
	@Test
	public void lessThan8Chars() {
		assertEquals(1, v.validate(str4));
	}
	
	@Test
	public void StrongPassword() {
		assertEquals(2, v.validate(str5));
	}	

}
