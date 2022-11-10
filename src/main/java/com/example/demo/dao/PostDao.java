package com.example.demo.dao;

import java.util.List;
import com.example.demo.entity.Post;
import com.example.demo.form.PostQuery;

public interface PostDao {

    List<Post> findByCriteria(PostQuery postQuery);
}
