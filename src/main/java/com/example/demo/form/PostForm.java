package com.example.demo.form;

import com.example.demo.entity.Post;
import lombok.Data;

@Data
public class PostForm {

    private Integer id;
    private String name;
    private Integer hackathon;
    private Integer team;
    private Integer frontend;
    private Integer backend;
    private Integer infrastructure;
    private Integer git;
    private Integer design;
    private Integer movie;
    private Integer machinelearning;
    private Integer portfolio;
    private Integer presentation;
    private String work;
    private String event;
    private String comment;

    //入力データからEntityを生成して返す
    public Post toEntity() {
        Post post = new Post();

        post.setId(id);
        post.setName(name);
        post.setHackathon(hackathon);
        post.setTeam(team);
        post.setFrontend(frontend);
        post.setBackend(backend);
        post.setInfrastructure(infrastructure);
        post.setGit(git);
        post.setDesign(design);
        post.setMovie(movie);
        post.setMachinelearning(machinelearning);
        post.setPortfolio(portfolio);
        post.setPresentation(presentation);
        post.setWorkInfo(work);
        post.setEventInfo(event);
        post.setWorkLink(work);
        post.setEventLink(event);
        post.setComment(comment);

        return post;
    }
}
