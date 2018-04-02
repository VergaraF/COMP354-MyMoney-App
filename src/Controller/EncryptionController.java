package Controller;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
*
* COMP 354 Project
* Group PJ-A

* The class responsible for encrypting and decrypting inputs
*/
public class EncryptionController 
{
	private final static String key = "12345678abcdefgh";
	
	/**
	 * Encrypts the string using the MD5 algorithm and byte to hexadecimal conversion.
	 */
	public static String OneWayEncrypt(String input) 
	{
		String savedInfo = input;
		MessageDigest messageDigest = null;
		byte[] encryptedData = null;
		
		try 
		{
			messageDigest = MessageDigest.getInstance("MD5");
		} 
		catch (NoSuchAlgorithmException e) 
		{
			e.printStackTrace();
		}
		
		messageDigest.update(savedInfo.getBytes());
		
		encryptedData = messageDigest.digest();
		
		StringBuffer buffer = new StringBuffer();
		
        for (int i = 0; i < encryptedData.length; i++) 
        {
        	buffer.append(Integer.toString((encryptedData[i] & 0xff) + 0x100, 16).substring(1));
        }
        
        return buffer.toString();
	}
	
	/**
	 * Encrypts the string using the AES algorithm.
	 */
	public static String Encrypt(String input)
	{
		Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
		
        Cipher cipher = null;
        byte[] encryptedData = null;
        
		try 
		{
			cipher = Cipher.getInstance("AES");
		} 
		catch (NoSuchAlgorithmException e) 
		{
			e.printStackTrace();
		} 
		catch (NoSuchPaddingException e) 
		{
			e.printStackTrace();
		}
		
        try 
        {
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
		} 
        catch (InvalidKeyException e) 
        {
			e.printStackTrace();
		}
        
		try 
		{
			encryptedData = cipher.doFinal(input.getBytes());
		} 
		catch (IllegalBlockSizeException e) 
		{
			e.printStackTrace();
		} 
		catch (BadPaddingException e) {
			e.printStackTrace();
		}

        StringBuilder stringBuilder = new StringBuilder();
        
        for (byte b : encryptedData) 
        {
            stringBuilder.append((char)b);
        }

        return stringBuilder.toString();
	}
	
	/**
	 * Decrypts the string using the AES algorithm.
	 */
	public static String Decrypt(String input)
	{
		Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
		byte[] encryptedData = new byte[input.length()];
		
        Cipher cipher = null;
        String decryptedData = null;
        
        for (int i = 0; i < input.length(); i++) 
        {
            encryptedData[i] = (byte) input.charAt(i);
        }

        try 
        {
			cipher = Cipher.getInstance("AES");
		} 
        catch (NoSuchAlgorithmException e) 
        {
			e.printStackTrace();
		} 
        catch (NoSuchPaddingException e) 
        {
			e.printStackTrace();
		}
		try 
		{
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
		} 
		catch (InvalidKeyException e) 
		{
			e.printStackTrace();
		}
        
        try 
        {
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
		} 
        catch (InvalidKeyException e) 
        {
			e.printStackTrace();
		}
        
		try 
		{
			decryptedData = new String(cipher.doFinal(encryptedData));
		} 
		catch (IllegalBlockSizeException e) 
		{
			e.printStackTrace();
		} 
		catch (BadPaddingException e) 
		{
			e.printStackTrace();
		}
		
		return decryptedData;
	}
}
