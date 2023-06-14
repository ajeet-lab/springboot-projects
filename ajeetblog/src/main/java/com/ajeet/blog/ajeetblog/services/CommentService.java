package com.ajeet.blog.ajeetblog.services;

import com.ajeet.blog.ajeetblog.payloads.CommentDto;

public interface CommentService {
	CommentDto createComment(CommentDto comment,Integer userId, Integer postId);
	
	void deleteComment(Integer commentId);
}
