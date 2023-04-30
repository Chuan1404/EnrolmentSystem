/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.api;

import com.java.pojos.Articles;
import com.java.pojos.Comments;
import com.java.pojos.Users;
import com.java.services.ArticlesService;
import com.java.services.CommentService;
import com.java.services.UsersService;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jackc
 */
@RestController
public class ApiCommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private ArticlesService articlesService;

    @GetMapping("/api/article/{articleId}/comments")
    public ResponseEntity<List<Comments>> getComments(@PathVariable(value = "articleId") String id) {
        Articles currArticle = articlesService.getArticleById(id);
        List<Comments> comments = this.commentService.getComments(currArticle);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping(path = "/api/article/{articleId}/comments", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Comments> addComment(@RequestBody Map<String, String> params,
            @PathVariable(value = "articleId") String id, Principal principal) {
        Articles article = articlesService.getArticleById(id);
        Users user = usersService.getUsersByUsername(principal.getName());

        Comments c = new Comments();
        c.setContent(params.get("content"));
        c.setCreatedDate(new Date());
        c.setUserId(user);
        c.setArticleId(article);
        c = commentService.addComments(c);
        if (c != null) {
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @PostMapping(path = "/api/article/{articleId}/comments/{commentId}/reply", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Comments> addReply(@RequestBody Map<String, String> params,
            @PathVariable(value = "articleId") String articleId,
            @PathVariable(value = "commentId") String commentId, Principal principal) {
        Articles article = articlesService.getArticleById(articleId);
        Comments comment = commentService.getCommentById(Integer.parseInt(commentId));
        Users user = usersService.getUsersByUsername(principal.getName());

        Comments reply = new Comments();
        reply.setArticleId(article);
        reply.setBaseCommentId(comment);
        reply.setUserId(user);
        reply.setCreatedDate(new Date());
        reply.setContent(params.get("content"));
        reply = commentService.addComments(reply);
        if (reply != null) {
            return new ResponseEntity<>(reply, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
