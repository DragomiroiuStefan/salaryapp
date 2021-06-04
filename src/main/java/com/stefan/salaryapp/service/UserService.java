package com.stefan.salaryapp.service;

import com.stefan.jooq.model.tables.pojos.Users;
import com.stefan.jooq.model.tables.records.UsersRecord;
import com.stefan.salaryapp.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final AuthenticationService authenticationService;

    public UserService(ModelMapper modelMapper, UserRepository userRepository, AuthenticationService authenticationService) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.authenticationService = authenticationService;
    }

    @Transactional
    public Users registerUser(Users user) {
        boolean usernameTaken = userRepository.getUserByUsername(user.getUsername()).isPresent();
        if (usernameTaken) {
            throw new IllegalArgumentException("Username " + user.getUsername() + " already taken");
        }
        boolean existingUser = userRepository.getUserByEmail(user.getEmail()).isPresent();
        if (existingUser) {
            throw new IllegalArgumentException("Email " + user.getEmail() + " already used");
        }

        byte[] salt = authenticationService.generateSalt();
        String passwordHash = authenticationService.generateHash(user.getPassword(), salt);

        user.setSalt(salt);
        user.setPassword(passwordHash);

        var usersRecord = userRepository.insertUser(user);
        usersRecord.setPassword(null);
        usersRecord.setSalt(null);
        return modelMapper.map(usersRecord, Users.class);
    }
}
