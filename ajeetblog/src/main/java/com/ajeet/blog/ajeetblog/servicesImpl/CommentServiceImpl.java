package com.ajeet.blog.ajeetblog.servicesImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajeet.blog.ajeetblog.entites.Comment;
import com.ajeet.blog.ajeetblog.entites.Post;
import com.ajeet.blog.ajeetblog.entites.User;
import com.ajeet.blog.ajeetblog.exceptions.ResourceNotFoundException;
import com.ajeet.blog.ajeetblog.payloads.CommentDto;
import com.ajeet.blog.ajeetblog.repos.CommentRepo;
import com.ajeet.blog.ajeetblog.repos.PostRepo;
import com.ajeet.blog.ajeetblog.repos.UserRepo;
import com.ajeet.blog.ajeetblog.services.CommentService;


@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public CommentDto createComment(CommentDto commentDto,Integer userId, Integer postId) {
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));
		Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));	
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		comment.setUser(user);
		Comment savedComment = this.commentRepo.save(comment);
		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment comment = this.commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "CommentId", commentId));
		System.out.println("Comment:: "+ comment);
		this.commentRepo.delete(comment);
	}

}
