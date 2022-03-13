import java.math.*;
import java.util.*;
import java.security.*;
import java.io.*;

public class ElGamalCipher{
	public static void main(String[] args){
		BigInteger p;
		BigInteger b;
		BigInteger c;
		BigInteger secretKey;
		Random srand = new SecureRandom();
		secretKey = new BigInteger("12345678901234567890");
		
		// public key calculation
		System.out.println("secretKey = " + secretKey);
		p = BigInteger.probablePrime(64, srand);
		b = new BigInteger("3");
		c = b.modPow(secretKey, p);
		
		// Encryption
		System.out.print("Enter your integer message to encrypt:\t");
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		
		BigInteger X = new BigInteger(s);
		BigInteger r = new BigInteger(64, srand);
		BigInteger EC = X.multiply(c.modPow(r, p)).mod(p);
		BigInteger brmodp = b.modPow(r, p);
		
		// Decryption
		BigInteger crmodp = brmodp.modPow(secretKey, p);
		BigInteger d = crmodp.modInverse(p);
		BigInteger ad = d.multiply(EC).mod(p);

		System.out.println("Decodes:\t"+ad);
	}
}
