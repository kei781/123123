package com.mysite.nexfilx.Contents.dao;


import com.mysite.nexfilx.Contents.domain.NetflixContents;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContentRepository extends JpaRepository<NetflixContents, Long> {

    Optional<NetflixContents> findByContentNum(String ContentNum);

}
