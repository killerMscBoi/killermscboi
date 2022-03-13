import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.io.*;

public class generatesymkeys
{
	public static void generateKey(String keyAlgorithm)
	{
		try
		{
			KeyGenerator keyGen = KeyGenerator.getInstance(keyAlgorithm);
			SecretKey key = keyGen.generateKey();
			System.out.println("\n" + "Generating symmetric key using " + key.getAlgorithm() + " algorithm:");
			byte keyBytes[] = key.getEncoded();
			int numBytes = keyBytes.length;
			System.out.println("Number of Bytes in key: " +numBytes);
			SecretKey key1 = new SecretKeySpec(keyBytes, keyAlgorithm);
			System.out.println("Secret Key: "+key.toString());
			System.out.println("Are both symmetric keys equals? " + key.equals(key1));
		}
		catch(NoSuchAlgorithmException e)
		{
			System.out.println("Exception");
			System.out.println("No such algorithm: " + keyAlgorithm);
		}
	}

	public static void main(String a[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";

		while(!str.equals("7"))
		{
			System.out.println("\n Menu for generating Symmetric Keys");
			System.out.println(" ----------------------------------");
			System.out.println(" 1. DES");
			System.out.println(" 2. AES");
			System.out.println(" 3. Blowfish");
			System.out.println(" 4. TripleDES");
			System.out.println(" 5. HmacMD5");
			System.out.println(" 6. HmacSHA1");
			System.out.println(" 7. Exit");
			System.out.println();
			System.out.print("Please enter your choice:");

			str = br.readLine();

			if(str.equals("1"))
				generateKey("DES");
			else if(str.equals("2"))
				generateKey("AES");
			else if(str.equals("3"))
				generateKey("Blowfish");
			else if(str.equals("4"))
				generateKey("DESede");
			else if(str.equals("5"))
				generateKey("HmacMD5");
			else if(str.equals("6"))
				generateKey("HmacSHA1");
			else
				break;
		}
		
	}
}
