package com.example.growth.repository;


import com.example.growth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findBySocialId(Long socialId);

}
