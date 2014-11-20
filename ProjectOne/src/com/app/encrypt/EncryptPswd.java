package com.app.encrypt;

import java.security.*;

import org.springframework.stereotype.Repository;

@Repository("encrypt")
public class EncryptPswd {

	public String getEncryptedPassword(String password){
		
		MessageDigest md=null;
		
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String digestA = new String(md.digest(password.getBytes()));

		return digestA;
		
	}
	
}
