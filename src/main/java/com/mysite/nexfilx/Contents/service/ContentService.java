package com.mysite.nexfilx.Contents.service;

import com.mysite.nexfilx.Contents.dao.ContentRepository;
import com.mysite.nexfilx.Contents.domain.NetflixContents;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ContentService {
    private final ContentRepository contentRepository;

    public NetflixContents contents(NetflixContents netflixContents) {
        Optional<NetflixContents> contentNum = contentRepository.findByContentNum(netflixContents.getContentNum());
        if (contentNum.isPresent()) {
            NetflixContents getContents = contentNum.get();
            return getContents;
        }
//
    return null;

    }
}
