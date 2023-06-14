package com.ajeet.blog.ajeetblog.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {   
    private Integer postId;
    private String postName;
    private String postContent;
    private String postImage;
    private Date createdAt;
    private Date updatedAt;
    private CategoryDto category;
    private UserDto user;
    private Set<CommentDto> comment = new HashSet<>();
}
