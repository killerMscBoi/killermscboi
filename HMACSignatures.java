import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;
import sun.misc.*;

public class HMACSignatures
{
	public static void main (String[] args) throws Exception
	{
		SecureRandom random = new SecureRandom();
		byte[] keyBytes = new byte[20];
		random.nextBytes(keyBytes);
		SecretKeySpec key = new SecretKeySpec(keyBytes, "HMACSHA1");
		System.out.println("Key:"+new BASE64Encoder().encode(key.getEncoded()));
		Mac mac = Mac.getInstance("HmacSHA1");
		mac.init(key);
		mac.update("hello".getBytes("UTF8"));
		byte[] result = mac.doFinal();
		System.out.println("MAC: "+new BASE64Encoder().encode(result));
	}
}
