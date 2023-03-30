package com.example.demo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name="post")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "hackathon")
    private Integer hackathon;

    @Column(name = "team")
    private Integer team;

    @Column(name = "frontend")
    private Integer frontend;

    @Column(name = "backend")
    private Integer backend;

    @Column(name = "infrastructure")
    private Integer infrastructure;

    @Column(name = "git")
    private Integer git;

    @Column(name = "design")
    private Integer design;

    @Column(name = "movie")
    private Integer movie;

    @Column(name = "machinelearning")
    private Integer machinelearning;

    @Column(name = "portfolio")
    private Integer portfolio;

    @Column(name = "presentation")
    private Integer presentation;

    @Column(name = "work_info")
    private String workInfo;

    @Column(name = "event_info")
    private String eventInfo;

    @Column(name = "work_link")
    private String workLink;

    @Column(name = "event_link")
    private String eventLink;

    @Column(name = "comment")
    private String comment;

}
