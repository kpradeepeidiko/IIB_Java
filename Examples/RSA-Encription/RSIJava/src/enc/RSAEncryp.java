package enc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;

public class RSAEncryp {

	public static void main(String[] args) throws Exception {
		String tt = main2("ndcd");
		System.out.println("TT = " + tt);
	}
public static String main2(String text)
{	
	//String text = "pradeep_k";
	String encrypted = null;
	PublicKey key = null;
	try {
		key = getKey("C:/Users/bandaru/Desktop/Sample_Examples/En_Dn/uba.key");
	} catch (IOException ex) {
		ex.printStackTrace();
		// Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null,
		// ex);
	}
	catch (GeneralSecurityException ex) {
		// Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null,
		// ex);
		ex.printStackTrace();
	}
	
	encrypted = encrypt(text, key);
	return encrypted;
}
	public static String encrypt(String text, PublicKey key) {
		byte[] cipherText = null;
		try {
			Cipher cipher = Cipher.getInstance("RSA");

			cipher.init(Cipher.ENCRYPT_MODE, key);
			cipherText = cipher.doFinal(text.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String encryptedIdentifier = Base64.encodeBase64String(cipherText);
		
		System.out.println("identifier:: " + encryptedIdentifier);

		return encryptedIdentifier;
	}

	public static String decrypt(byte[] text, String keyPath,
			String privateKeyName) {
		byte[] dectyptedText = null;
		try {
			Cipher cipher = Cipher.getInstance("RSA");
			ObjectInputStream inputStream = null;
			inputStream = new ObjectInputStream(new FileInputStream(keyPath
					+ "/" + privateKeyName));
			PrivateKey key = (PrivateKey) inputStream.readObject();
			System.out.println("After getting private key");

			cipher.init(2, key);
			dectyptedText = cipher.doFinal(text);

			System.out.println("Decrypted text:" + dectyptedText);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return new String(dectyptedText);
	}

	public static String decrypt(byte[] text, String keyPath) throws Exception {
		byte[] dectyptedText = null;
		try {
			Cipher cipher = Cipher.getInstance("RSA");
			ObjectInputStream inputStream = null;
			inputStream = new ObjectInputStream(new FileInputStream(keyPath));
			PrivateKey key = (PrivateKey) inputStream.readObject();
			System.out.println("After getting private key");

			cipher.init(2, key);
			dectyptedText = cipher.doFinal(text);

			System.out.println("Decrypted text:" + dectyptedText);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}

		return new String(dectyptedText);
	}

	public static PublicKey getKey(String filename) throws IOException,
			GeneralSecurityException {

		CertificateFactory cf = CertificateFactory.getInstance("X.509");
		X509Certificate cert = null;
		
		System.out.println("FileName:: " + filename);
		try {
			InputStream str = new FileInputStream(filename);
			cert = (X509Certificate) cf.generateCertificate(str);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		;
		PublicKey pubKey = cert.getPublicKey();
		return pubKey;
	}

}
