package com.burhan.app.rest.repository;

import com.burhan.app.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> getByFirstName(String name);
    Optional<User> getByLastName(String lastName);
    Optional<User> getByEmail(String email);
}
