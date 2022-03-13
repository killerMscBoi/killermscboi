import java.security.*;
import java.security.spec.*;
import java.io.*;

public class DiffieHellmanKeyExchange{
	public static void generateKey(String keyAlgorithm, int numBits){
		try{
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance(keyAlgorithm);
			keyGen.initialize(numBits);

			KeyPair keyPair = keyGen.genKeyPair();
			PrivateKey privateKey = keyPair.getPrivate();
			PublicKey publicKey = keyPair.getPublic();

			System.out.println("\n" + "Generating Key/value pair using " + privateKey.getAlgorithm() + " algorithm");

			byte privateKeyBytes[] = privateKey.getEncoded();
			byte publicKeyBytes[] = publicKey.getEncoded();

			String formatPrivate = privateKey.getFormat();
			String formatPublic = publicKey.getFormat();

			System.out.println("Private key format : " + formatPrivate);
			System.out.println("Public key format : " + formatPublic);

			KeyFactory keyFactory = KeyFactory.getInstance(keyAlgorithm);

			EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
			PrivateKey privateKey1 = keyFactory.generatePrivate(privateKeySpec);

			EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
			PublicKey publicKey1 = keyFactory.generatePublic(publicKeySpec);

			System.out.println("Are both private keys equal?" + privateKey.equals(privateKey1));
			System.out.println("Are both public keys equal?" + publicKey.equals(publicKey1));
		}
		catch(InvalidKeySpecException e){
			System.out.println(e);
		}
		catch(NoSuchAlgorithmException e){
			System.out.println(e);
		}
	}

	public static void main(String a[]) throws IOException{
			generateKey("DH", 576);
	}
}
