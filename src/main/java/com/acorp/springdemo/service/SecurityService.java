package com.acorp.springdemo.service;

public interface SecurityService {
    String creteToken(String subject, long ttlMillis);

    String getSubject(String token);
}
