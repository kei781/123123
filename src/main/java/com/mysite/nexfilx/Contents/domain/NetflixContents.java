package com.mysite.nexfilx.Contents.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Blob;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NetflixContents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String contentNum;
    private String contentName;
    private int episodes;
    private String date;
    private String actor;
    private int age;
    private String director;
    private Blob contentImg;
    private Blob contentVideo;
    private Blob detailImg;
    private Blob detailTextImg;
    private String mainStory;


}
