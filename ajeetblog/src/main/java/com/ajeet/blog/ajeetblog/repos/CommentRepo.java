package com.ajeet.blog.ajeetblog.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajeet.blog.ajeetblog.entites.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
