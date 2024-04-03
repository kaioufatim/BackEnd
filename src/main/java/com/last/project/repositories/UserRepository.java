package com.last.project.repositories;

import com.last.project.entities.User;
import org.apache.naming.factory.SendMailFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    //User FindFirstByEmail(String email);
    User findFirstByEmail(String email);
    Optional<User> findByName(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
