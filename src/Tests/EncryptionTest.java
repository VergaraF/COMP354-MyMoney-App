package Tests;

import static org.junit.Assert.*;
import org.junit.Test;

import Controller.EncryptionController;

public class EncryptionTest 
{
	@Test
    public void test1()
	{
    	String unencrypted = "test string";
		String encrypted = EncryptionController.OneWayEncrypt(unencrypted);
		
    	assertNotEquals(unencrypted, encrypted);
    }
	
	@Test
    public void test2()
	{
    	String unencrypted = "test string";
		String encrypted = EncryptionController.Encrypt(unencrypted);
		String decrypted = EncryptionController.Decrypt(encrypted);
		
    	assertNotEquals(unencrypted, encrypted);
    	assertEquals(unencrypted, decrypted);
    }
}
