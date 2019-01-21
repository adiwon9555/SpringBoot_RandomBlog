package com.practice.blog.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.blog.model.Blog;
import com.practice.blog.service.BlogService;


@CrossOrigin
@RestController
public class BlogController {
	
	@Autowired
	BlogService blogService;
	
	@RequestMapping("/hello")
	public String sayHi(){
		return "Hi";
	}
	
	@GetMapping(path="/blogs")
	 public ResponseEntity<List<Blog>> getAllBlogs() {
        List<Blog> blogs = blogService.getAllBlogs();
        if (blogs.isEmpty()) {
            return new ResponseEntity<List<Blog>>(HttpStatus.NOT_FOUND);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
    }
	@PostMapping(path="/blog")
	public Blog addBlog(@RequestBody Blog blog){
		
		return blogService.addBlog(blog);
		
	}
	@PatchMapping(path="/blog/{_id}")
	public Blog upvote(@PathVariable String _id){
		return blogService.upVote(_id);
	}

}
