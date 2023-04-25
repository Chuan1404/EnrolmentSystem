/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.repositories;

import com.java.pojos.Articles;
import com.java.pojos.Comments;
import java.util.List;

/**
 *
 * @author jackc
 */
public interface CommentRepository {
    List<Comments> getComments(Articles articles);
    Comments addComment(Comments comment);
    List<Comments> getReplies(Comments comment);
}
