import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
public class MessageDigest5
{
	public static void main(String[] args)
	{
		System.out.println("Enter the string whose digest has to be created");
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		System.out.println("The message digest is "+makeDigest(str));
	}
	public static String makeDigest(String input)
	{
		String md = null;
		try
		{
			//Create MessageDigest object for MD5
			MessageDigest digest = MessageDigest.getInstance("MD5");
			//Update input string in message digest
			digest.update(input.getBytes(), 0, input.length());
			//Converts message digest value in base 16 (hex) 
			md= new BigInteger(1, digest.digest()).toString(16);
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		return md;
	}
}
