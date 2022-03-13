import java.lang.Math;
import java.util.Scanner;

public class VerminCipher {
	
	public static void main(String args[]){
		Scanner scn = new Scanner(System.in);
		String text;
		System.out.print("Enter plain text: \t");
		text = scn.nextLine();
		
		char[] arText = text.toCharArray();
		String cipher = new String("XYZHG");
		
		char[] arCipher = cipher.toCharArray();
		char[] encoded = new char[5];
		
		System.out.print("Encoded " + text + " to:\t");
		
		for (int i = 0; i < arText.length; i++){
			encoded[i] = (char) (arText[i] ^ arCipher[i]);
			System.out.print(encoded[i]);
		}
		System.out.println("");
		System.out.print("Decoded to:\t\t");

		for (int i = 0; i < encoded.length; i++){
			char temp = (char) (encoded[i] ^ arCipher[i]);
			System.out.print(temp);
		}
	}
}
