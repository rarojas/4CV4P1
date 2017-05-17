package com.escom.distribuidos.p2.webapp.security;

import org.springframework.beans.factory.annotation.Value;

public class JwtUtil {

	@Value("${jwt.secret}")
	private String secret;

	// public User parseToken(String token) {
	// try {
	// Claims body =
	// Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	//
	// User u = new User();
	// u.setUsername(body.getSubject());
	// u.setId(Long.parseLong((String) body.get("userId")));
	// u.setRole((String) body.get("role"));
	//
	// return u;
	//
	// } catch (JwtException | ClassCastException e) {
	// return null;
	// }
	// }
	//
	// public String generateToken(User u) {
	// Claims claims = Jwts.claims().setSubject(u.getUsername());
	// claims.put("userId", u.getId() + "");
	// claims.put("role", u.getRole());
	//
	// return
	// Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512,
	// secret).compact();
	// }
}
