package com.whoayoo.util.jwt;

import java.security.Key;
import java.util.Date;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.*;


public class JwtUtil {

	
	// method to construct a JWT
	public String createNewToken(String id, String issuer, String subject, long ttlMillis) {
		
		
		//The JWT signature algorithm we will be using to sign the token
	    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
	 
	    long nowMillis = System.currentTimeMillis();
	    Date now = new Date(nowMillis);
	 
	    
	    String key = SecretKey.KEY;
	   
	   
	    
	    //We will sign our JWT with our ApiKey secret
	    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key);
	    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
	 
	    //Let's set the JWT Claims
	    JwtBuilder builder = Jwts.builder().setId(id)
	                                .setIssuedAt(now)
	                                .setSubject(subject)
	                                .setIssuer(issuer)
	                                .signWith(signatureAlgorithm, signingKey);
	 
	    //if it has been specified, let's add the expiration
	    if (ttlMillis >= 0) {
	    long expMillis = nowMillis + ttlMillis;
	        Date exp = new Date(expMillis);
	        builder.setExpiration(exp);
	    }
	 
	    //Builds the JWT and serializes it to a compact, URL-safe string
	    return builder.compact();
		
	}
	
	
	
	// method to validate and read the JWT (Decode and Verify Tokens)
	public String getUserIdFromToken(String jwt) {
		
		String key = SecretKey.KEY;
		
		
		//This line will throw an exception if it is not a signed JWS (as expected)
		try {
			Claims claims = Jwts.parser()         
				       .setSigningKey(DatatypeConverter.parseBase64Binary(key))
				       .parseClaimsJws(jwt).getBody();
		    System.out.println("ID: " + claims.getId());
		    System.out.println("Subject: " + claims.getSubject());
		    System.out.println("Issuer: " + claims.getIssuer());
		    System.out.println("Expiration: " + claims.getExpiration());
		    return claims.getId();
		} catch (Exception e) {
			System.out.println("Failed to decrypt JWT");
			System.out.println(e);
			return null;
		}
	    
		
	}
	
	
}
