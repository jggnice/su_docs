package not_file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

import tofile.ToFile;

/**
 * @author JavaDigest
 * 
 */
public class TestRSAnoPadding {

	/**
	 * String to hold name of the encryption algorithm.
	 */
	public static final String ALGORITHM = "RSA";

	/**
	 * String to hold name of the encryption padding.
	 */
	private static final String PADDING = "RSA/NONE/NoPadding";

	/**
	 * String to hold name of the security provider.
	 */
	private static final String PROVIDER = "BC";

	/**
	 * String to hold the name of the private key file.
	 */
	private static final String privatekey64 = "rO0ABXNyAEJvcmcuYm91bmN5Y2FzdGxlLmpjYWpjZS5wcm92aWRlci5hc3ltbWV0cmljLnJzYS5CQ1JTQVByaXZhdGVDcnRLZXlsuofOAnNVLgIABkwADmNydENvZWZmaWNpZW50dAAWTGphdmEvbWF0aC9CaWdJbnRlZ2VyO0wADnByaW1lRXhwb25lbnRQcQB+AAFMAA5wcmltZUV4cG9uZW50UXEAfgABTAAGcHJpbWVQcQB+AAFMAAZwcmltZVFxAH4AAUwADnB1YmxpY0V4cG9uZW50cQB+AAF4cgA/b3JnLmJvdW5jeWNhc3RsZS5qY2FqY2UucHJvdmlkZXIuYXN5bW1ldHJpYy5yc2EuQkNSU0FQcml2YXRlS2V5RusJwAfPQRwDAAJMAAdtb2R1bHVzcQB+AAFMAA9wcml2YXRlRXhwb25lbnRxAH4AAXhwc3IAFGphdmEubWF0aC5CaWdJbnRlZ2VyjPyfH6k7+x0DAAZJAAhiaXRDb3VudEkACWJpdExlbmd0aEkAE2ZpcnN0Tm9uemVyb0J5dGVOdW1JAAxsb3dlc3RTZXRCaXRJAAZzaWdudW1bAAltYWduaXR1ZGV0AAJbQnhyABBqYXZhLmxhbmcuTnVtYmVyhqyVHQuU4IsCAAB4cP///////////////v////4AAAABdXIAAltCrPMX+AYIVOACAAB4cAAAACCCar9DA0aYD8IRPssf/4f6KJ+IR4qLmr/RSFUCKmIVT3hzcQB+AAT///////////////7////+AAAAAXVxAH4ACAAAAB9ard5OufhbwpktZHvXw9THGBX696xnsDoSBPeq9EIxeHhzcQB+AAT///////////////7////+AAAAAXVxAH4ACAAAABCfxEcMr7H3QTRjq/NhgovieHNxAH4ABP///////////////v////4AAAABdXEAfgAIAAAAEEPgVh5BK4hPd/bMrvPl6jF4c3EAfgAE///////////////+/////gAAAAF1cQB+AAgAAAAQHHmksqCXSyDsjSqazkplkXhzcQB+AAT///////////////7////+AAAAAXVxAH4ACAAAABDf/QkBR6QjNAdMoLztPjWdeHNxAH4ABP///////////////v////4AAAABdXEAfgAIAAAAEJUOQVrk4qHIilkiBhIZmNt4c3EAfgAE///////////////+/////gAAAAF1cQB+AAgAAAADAQABeA==";
	/**
	 * String to hold name of the public key file.
	 */
	private static final String publickey64 = "rO0ABXNyAD5vcmcuYm91bmN5Y2FzdGxlLmpjYWpjZS5wcm92aWRlci5hc3ltbWV0cmljLnJzYS5CQ1JTQVB1YmxpY0tleSUiag5b+myEAwACTAAHbW9kdWx1c3QAFkxqYXZhL21hdGgvQmlnSW50ZWdlcjtMAA5wdWJsaWNFeHBvbmVudHEAfgABeHBzcgAUamF2YS5tYXRoLkJpZ0ludGVnZXKM/J8fqTv7HQMABkkACGJpdENvdW50SQAJYml0TGVuZ3RoSQATZmlyc3ROb256ZXJvQnl0ZU51bUkADGxvd2VzdFNldEJpdEkABnNpZ251bVsACW1hZ25pdHVkZXQAAltCeHIAEGphdmEubGFuZy5OdW1iZXKGrJUdC5TgiwIAAHhw///////////////+/////gAAAAF1cgACW0Ks8xf4BghU4AIAAHhwAAAAIIJqv0MDRpgPwhE+yx//h/oon4hHiouav9FIVQIqYhVPeHNxAH4AA////////////////v////4AAAABdXEAfgAHAAAAAwEAAXh4";

	/*
	 * private static boolean areKeysPresent() {
	 * 
	 * File privateKey = new File("/private.dat"); File publicKey = new
	 * File("/public.dat");
	 * 
	 * if (privateKey.exists() && publicKey.exists()) { return true; } return
	 * false; }
	 */

	/**
	 * Encrypt the plain text using public key.
	 * 
	 * @param text
	 *            : original plain text
	 * @param key
	 *            :The public key
	 * @return Encrypted text
	 * @throws java.lang.Exception
	 */
	private static byte[] encrypt(String text, PublicKey key) {
		byte[] cipherText = null;
		try {
			// get an RSA cipher object and print the provider
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
			final Cipher cipher = Cipher.getInstance(PADDING, PROVIDER);

			// encrypt the plain text using the public key
			cipher.init(Cipher.ENCRYPT_MODE, key);
			cipherText = cipher.doFinal(text.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cipherText;
	}

	/**
	 * Decrypt text using private key.
	 * 
	 * @param text
	 *            :encrypted text
	 * @param key
	 *            :The private key
	 * @return plain text
	 * @throws java.lang.Exception
	 */
	private static String decrypt(byte[] text, PrivateKey key) {
		byte[] dectyptedText = null;
		try {
			// get an RSA cipher object and print the provider
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
			final Cipher cipher = Cipher.getInstance(PADDING, PROVIDER);

			// decrypt the text using the private key
			cipher.init(Cipher.DECRYPT_MODE, key);
			dectyptedText = cipher.doFinal(text);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return new String(dectyptedText);
	}

	/**
	 * Test the EncryptionUtil
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void S2S2(String[] args) throws IOException,
			ClassNotFoundException {
		ObjectInputStream inputStream = null;
		// Decrypt the cipher text using the private key.
		CreateFile.decodetofile(privatekey64, "/private.dat");
		inputStream = new ObjectInputStream(new FileInputStream("/private.dat"));
		final PrivateKey privateKey = (PrivateKey) inputStream.readObject();
		Base64 base64 = new Base64();
		byte[] cipherTextArray = base64.decode(args[0]);
		args[1] = decrypt(cipherTextArray, privateKey);
		inputStream.close();
		ToFile.file_delete("/private.dat");
	}

	public static void S2S(String[] args) {

		try {
			/*
			 * if (!areKeysPresent()) { return; }
			 */

			final String originalText = args[0];
			// System.out.println(args[0]);
			ObjectInputStream inputStream = null;
			// Encrypt the string using the public key
			CreateFile.decodetofile(publickey64, "/public.dat");
			inputStream = new ObjectInputStream(new FileInputStream(
					"/public.dat"));
			final PublicKey publicKey = (PublicKey) inputStream.readObject();
			final byte[] cipherText = encrypt(originalText, publicKey);
			// use String to hold cipher binary data
			Base64 base64 = new Base64();
			String cipherTextBase64 = base64.encodeToString(cipherText);
			// get cipher binary data back from String
			inputStream.close();
			args[1] = cipherTextBase64;
			ToFile.file_delete("/public.dat");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
