package com.example.growth.repository;


import com.example.growth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findBySocialId(Long socialId);
    User findUserById(Long id);

}
