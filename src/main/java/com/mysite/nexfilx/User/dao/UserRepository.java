package com.mysite.nexfilx.User.dao;

import com.mysite.nexfilx.User.main.NetflixUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<NetflixUser, Long> {
    Optional<NetflixUser> findByUseremail(String userEmail);
}
