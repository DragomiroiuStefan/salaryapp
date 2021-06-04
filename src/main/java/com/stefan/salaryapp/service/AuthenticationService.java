package com.stefan.salaryapp.service;

import com.stefan.jooq.model.tables.pojos.Users;
import com.stefan.salaryapp.exceptions.IncorrectCredentials;
import com.stefan.salaryapp.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public Users authenticate(String authToken) {
        if ("".equals(authToken) || !"Basic ".equals(authToken.substring(0, 6))) {
            throw new IllegalArgumentException("Authentication missing or incorrect");
        }
        var decodedAuthToken = new String(Base64.getDecoder().decode(authToken.substring(6)));
        int colonIndex = decodedAuthToken.indexOf(":");
        var username = decodedAuthToken.substring(0, colonIndex);
        var password = decodedAuthToken.substring(colonIndex + 1);

        var user = userRepository.getUser(username)
            .orElseThrow(() -> new IncorrectCredentials("Username or password is incorrect"));

        if (!user.getPassword().equals(generateHash(password, user.getSalt()))) {
            throw new IncorrectCredentials("Username or password is incorrect");
        }
        user.setPassword(null);
        user.setSalt(null);
        return user;
    }

    public String generateHash(String password, byte[] salt) {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory = null;
        byte[] hash;
        try {
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            hash = factory.generateSecret(spec).getEncoded();

        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
        return new String(hash);
    }

    public byte[] generateSalt() {
        var random = new SecureRandom();
        var salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }
}
