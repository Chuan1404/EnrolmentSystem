/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.services.impl;

import com.java.pojos.Articles;
import com.java.pojos.Comments;
import com.java.repositories.CommentRepository;
import com.java.services.CommentService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jackc
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comments> getComments(Articles articles) {
        List<Comments> comments = commentRepository.getComments(articles);
        return comments.stream().map(comment -> {
            Set<Comments> replies = commentRepository.getReplies(comment).stream().collect(Collectors.toSet());
            comment.setCommentsCollection(replies);
            return comment;
            
        }).collect(Collectors.toList());
        
    }

    @Override
    public Comments addComments(Comments comment) {
        return commentRepository.addComment(comment);
    }

    @Override
    public Comments getCommentById(int id) {
        return commentRepository.getCommentById(id);
    }
    
}
