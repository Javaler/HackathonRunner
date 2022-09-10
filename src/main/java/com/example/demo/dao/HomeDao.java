package com.example.demo.dao;

import java.util.List;
import com.example.demo.entity.Post;
import com.example.demo.form.HomeQuery;

public interface HomeDao {
	// Criteria APIによる検索
	  List<Post> findByCriteria(HomeQuery todoQuery);
}
