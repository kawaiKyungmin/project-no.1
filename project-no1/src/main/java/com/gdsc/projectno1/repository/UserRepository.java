package com.gdsc.projectno1.repository;

import com.gdsc.projectno1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    User findByNameAndPassword(String name, String password);
}
