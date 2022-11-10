package com.mysite.nexfilx.Contents.controller;

import com.mysite.nexfilx.Contents.dao.ContentRepository;
import com.mysite.nexfilx.Contents.domain.NetflixContents;
import com.mysite.nexfilx.Contents.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ContentController {
    @Autowired
    private final ContentService contentService;
    private final ContentRepository contentRepository;

    @GetMapping("/contents")
//    @ResponseBody
    public NetflixContents contents(@RequestBody NetflixContents netflixContents) {
        NetflixContents getContents = contentService.contents(netflixContents);

        return getContents;
    }
    @GetMapping("/get")
    public List<NetflixContents> get(){
        return contentRepository.findAll();
    }


}
