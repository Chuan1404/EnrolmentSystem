/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.services.impl;

import com.java.pojos.Livestreams;
import com.java.pojos.Questions;
import com.java.repositories.QuestionsRepository;
import com.java.services.QuestionsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class QuestionsServiceImpl implements QuestionsService {
    @Autowired
    private QuestionsRepository questionRepository;

    @Override
    public boolean addQuestion(Questions question) {
        return questionRepository.addQuestion(question);
    }

    @Override
    public List<Questions> getQuestionsByLivestreamId(Livestreams livestreams) {
        return questionRepository.getQuestionsByLivestream(livestreams);
    }

    @Override
    public Questions getQuestionById(int id) {
        return questionRepository.getQuestionById(id);
    }
    
}
