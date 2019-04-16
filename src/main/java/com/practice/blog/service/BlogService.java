package com.practice.blog.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.practice.blog.model.Blog;
import com.practice.blog.repository.BlogRepository;

@Service
public class BlogService {

	@Autowired
	BlogRepository blogRepository;

	public List<Blog> getAllBlogs() {
		List<Blog> blogs = new ArrayList<Blog>();

		blogRepository.findAll().forEach(blogs::add);
		return blogs;
	}

	public Blog addBlog(Blog blog) {
		long createdAt=new Date().getTime();
		blog.setCreatedAt(createdAt);
		return blogRepository.save(blog);
		
	}
	public Blog upVote(String _id){
		Blog b=new Blog();
		b=getBlog(_id);
		int c=b.getVote()+1;
		b.setVote(c);
		return blogRepository.save(b);
	}
	public Blog getBlog(String _id){
		return blogRepository.findById(_id).orElse(null);
	}
	public Blog removeBlog(String _id) {
		// TODO Auto-generated method stub
		Blog b=getBlog(_id);
		blogRepository.delete(b);
		return b;
	}
}
