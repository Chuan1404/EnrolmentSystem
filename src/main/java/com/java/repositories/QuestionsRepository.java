/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.repositories;

import com.java.pojos.Livestreams;
import com.java.pojos.Questions;
import java.util.List;

/**
 *
 * @author HP
 */
public interface QuestionsRepository {
    boolean addQuestion(Questions question);
    List<Questions> getQuestionsByLivestream(Livestreams livestream);
}
