import java.math.BigInteger;
import java.util.Scanner;

public class AffineCipher{
	
	private static int firstKey = 5;
	private static int secondKey = 19;
	private static int module = 26;

	static String encrypt(String input)	{
		StringBuilder builder = new StringBuilder();
		for(int in = 0; in<input.length(); in++){
			char character = input.charAt(in);
			if(Character.isLetter(character)){
				character = (char) ((firstKey * (character - 'a') + secondKey) % module + 'a');
			}
			builder.append(character);
		}
		return builder.toString();
	}

	static String decrypt(String input){
		StringBuilder builder = new StringBuilder();
		BigInteger inverse = BigInteger.valueOf(firstKey).modInverse(BigInteger.valueOf(module));
		for(int in=0;in<input.length();in++){
			char character = input.charAt(in);
			if(Character.isLetter(character)){
				int decoded = inverse.intValue() * (character - 'a' - secondKey + module);
				character = (char)(decoded % module + 'a');
			}
			builder.append(character);
		}
		return builder.toString();
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter String: \t");
		String input = sc.nextLine();
		String cipher = encrypt(input);
		String decipher = decrypt(cipher);
		
		System.out.println("Source : " + input);
		System.out.println("Encrypted : " + cipher);
		System.out.println("Decrypted : " + decipher);
	}
}
