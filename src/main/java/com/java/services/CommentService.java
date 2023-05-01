/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.services;

import com.java.pojos.Articles;
import com.java.pojos.Comments;
import java.util.List;


/**
 *
 * @author jackc
 */
public interface CommentService {
    List<Comments> getComments(Articles articles);
    Comments addComments(Comments comment);
    Comments getCommentById(int id);
}
