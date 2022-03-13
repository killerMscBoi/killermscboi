import java.util.Scanner;

public class RailFenceCipher{
	static String Encryption(String plainText,int depth){
		int r = depth, len = plainText.length();
		int c = len/depth;
		char mat[][] = new char[r][c];
		int k = 0;

		String cipherText = "";

		for(int i=0;i<c;i++){
			for(int j=0;j<r;j++){
				if(k!=len){
					mat[j][i] = plainText.charAt(k++);
				}else{
					mat[j][i]='X';
				}
			}
		}
		
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				cipherText += mat[i][j];
			}
		}
		
		return cipherText;
	}

	static String Decryption(String cipherText,int depth){
		int r = depth,len=cipherText.length();
		int c = len/depth;
		char mat[][] = new char[r][c];
		int k = 0;

		String plainText = "";

		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				mat[i][j] = cipherText.charAt(k++);
			}
		}
		
		for(int i=0;i<c;i++){
			for(int j=0;j<r;j++){
				plainText += mat[j][i];
			}
		}

		return plainText;
	}

	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int depth;

		String plainText;
		String cipherText;
		String decryptedText;

		System.out.print("Enter plain text: \t");
		plainText = scn.nextLine();

		System.out.print("Enter depth of encryption: \t");
		depth = scn.nextInt();

		cipherText = Encryption(plainText, depth);
		System.out.println("Encrypted text is: \t"+cipherText);

		decryptedText = Decryption(cipherText, depth);
		System.out.println("Decrypted text is:\t"+decryptedText);
	}
}
