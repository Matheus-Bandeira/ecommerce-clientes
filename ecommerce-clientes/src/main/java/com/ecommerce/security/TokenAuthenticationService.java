package com.ecommerce.security;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenAuthenticationService {

	@Value("${jwt.appication}")
	private String application;
	
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private String expiration;
	
	public String generateToken(String user, String roles) {
		
		//data de geração do token
		Date now = new Date();
		
		// data de expiração do token
		Date exp = new Date(now.getTime() + Long.parseLong(expiration));
		
//		return Jwts.builder()
//				.setIssuer(application) //nome da aplicação
//				.setSubject(user) // nome do usuário
//				.setExpiration(exp)
//				.signWith(SignatureAlgorithm.HS256, secret)
//				.compact();
		
		// informações de perfil do usuário
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
		
		//GERANDO O TOKEN
		String token = Jwts.builder()
				.setId(application) // nome da aplicação
				.setSubject(user) // identificação do usuário
				.claim("authorities", grantedAuthorities.stream()
						.map(GrantedAuthority::getAuthority)
						.collect(Collectors.toList()))
				.setIssuedAt(now)  // data geração do token
				.setExpiration(exp) // data de expiração do token
				.signWith(SignatureAlgorithm.HS512, secret.getBytes()) // chave anti-falsificação
				.compact();
		
		return token;
	}
}
