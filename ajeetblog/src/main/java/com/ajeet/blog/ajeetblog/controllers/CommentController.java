package com.ajeet.blog.ajeetblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajeet.blog.ajeetblog.payloads.ApiResponse;
import com.ajeet.blog.ajeetblog.payloads.CommentDto;
import com.ajeet.blog.ajeetblog.services.CommentService;

@RestController
@RequestMapping("/api")
public class CommentController {
	
	@Autowired
	private CommentService commentService;

	@PostMapping("/user/{userId}/post/{postId}/comment")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto,@PathVariable Integer userId, @PathVariable Integer postId){
		CommentDto comment = this.commentService.createComment(commentDto, userId ,postId);
		return new ResponseEntity<CommentDto>(comment, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/comment/{commentId}")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){
		this.commentService.deleteComment(commentId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Comment Deleted successfully commentId : "+commentId, true), HttpStatus.CREATED);
	}
}
