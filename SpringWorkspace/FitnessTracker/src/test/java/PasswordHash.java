import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import junit.framework.TestCase;

public class PasswordHash extends TestCase {
	
	/*public void testMD5Hash() {
		
		String password="secure";
		Md5PasswordEncoder passwordEncode=new Md5PasswordEncoder();
		String hashedPassword=passwordEncode.encodePassword(password, null);
		System.out.println(hashedPassword);
	}*/
	
	public void testBcryptHash() {
		
		String password="secure";
		BCryptPasswordEncoder passwordEncode=new BCryptPasswordEncoder();
		String hashedPassword=passwordEncode.encode(password);
		System.out.println(hashedPassword);
	}

}
