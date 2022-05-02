package com.prodemy.dataperpus_try6.repository;

import com.prodemy.dataperpus_try6.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoUser extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
