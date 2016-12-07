package com.whoayoo.util.jwt;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class EncodedKey {

	
	private static SecretKey secretKey = null; 

	public String createNewKey() {
		try {
			secretKey = KeyGenerator.getInstance("AES").generateKey();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	
		// get base64 encoded version of the key
		String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
	
		return encodedKey;
	
	}
	
	
}
