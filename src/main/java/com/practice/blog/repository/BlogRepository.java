package com.practice.blog.repository;

import org.springframework.data.repository.CrudRepository;

import com.practice.blog.model.Blog;

public interface BlogRepository extends CrudRepository<Blog, String> {
	

}
