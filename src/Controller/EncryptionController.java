package Controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
*
* COMP 354 Project
* Group PJ-A

* The class responsible for encrypting inputs
*/
public class EncryptionController 
{
	/**
	 * Encrypts the string using the MD5 algorithm and byte to hexadecimal conversion.
	 */
	public static String Encrypt(String input) 
	{
		String savedInfo = input;

		MessageDigest messageDigest = null;
		
		try 
		{
			messageDigest = MessageDigest.getInstance("MD5");
		} 
		catch (NoSuchAlgorithmException e) 
		{
			e.printStackTrace();
		}
		
		messageDigest.update(savedInfo.getBytes());
		
		byte encryptedData[] = messageDigest.digest();
		
		StringBuffer buffer = new StringBuffer();
		
        for (int i = 0; i < encryptedData.length; i++) 
        {
        	buffer.append(Integer.toString((encryptedData[i] & 0xff) + 0x100, 16).substring(1));
        }
        
        return buffer.toString();
	}
}
