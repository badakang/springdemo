package com.acorp.springdemo.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

@Service
public class SecurityServiceImpl implements SecurityService {

    public static final String secretKey = "4C8XFLGAdJdfFdASJFAsSJFJAFAFzv";

    @Override
    public String creteToken(String subject, long ttlMillis) { // subject는 식별자로 userid개념
        if(ttlMillis == 0) {
            throw new RuntimeException("토큰 만료기간은 0 이상어야 합니다.");
        }

        //HS256 방식으로 암호화 방식 설정
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecuretBytes = DatatypeConverter.parseBase64Binary(secretKey);
        Key sigingKey = new SecretKeySpec(apiKeySecuretBytes, signatureAlgorithm.getJcaName());

        //token 생성
        JwtBuilder builder = Jwts.builder()
                .setSubject(subject)
                .signWith(signatureAlgorithm, sigingKey);

        long nowMillis = System.currentTimeMillis();
        builder.setExpiration(new Date(nowMillis + ttlMillis));

        return builder.compact();
    }

    @Override
    public String getSubject(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
                .parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
