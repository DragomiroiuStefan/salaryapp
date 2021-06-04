package com.stefan.salaryapp.repository;


import com.stefan.jooq.model.tables.pojos.Users;
import com.stefan.jooq.model.tables.records.UsersRecord;
import com.stefan.salaryapp.util.Role;
import org.jooq.DSLContext;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

import static com.stefan.jooq.model.Tables.USERS;

@Repository
public class UserRepository {

    private final DSLContext dslContext;

    public UserRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public Optional<Users> getUser(String username) {
        return dslContext.select()
            .from(USERS)
            .where(USERS.USERNAME.eq(username))
            .fetchOptionalInto(Users.class);
    }

    public Optional<Users> getUserByUsername(String username) {
        return dslContext.selectFrom(USERS)
            .where(USERS.USERNAME.eq(username))
            .fetchOptionalInto(Users.class);
    }

    public Optional<Users> getUserByEmail(String email) {
        return dslContext.selectFrom(USERS)
            .where(USERS.EMAIL.eq(email))
            .fetchOptionalInto(Users.class);
    }

    public UsersRecord insertUser(Users user) {
        var usersRecord = new UsersRecord();
        usersRecord.setUsername(user.getUsername());
        usersRecord.setPassword(user.getPassword());
        usersRecord.setSalt(user.getSalt());
        usersRecord.setEmail(user.getEmail());
        usersRecord.setCreatedOn(LocalDate.now());
        usersRecord.setRoleId(Role.USER.getRoleId());

        return  dslContext.insertInto(USERS)
            .set(usersRecord)
            .returning()
            .fetchOne();
    }
}
