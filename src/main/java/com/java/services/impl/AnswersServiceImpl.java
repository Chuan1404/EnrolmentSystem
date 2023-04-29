/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.services.impl;

import com.java.pojos.Answers;
import com.java.repositories.AnswersRepository;
import com.java.services.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jackc
 */
@Service
public class AnswersServiceImpl implements AnswersService {
    
    @Autowired
    private AnswersRepository answersRepository;

    @Override
    public boolean saveAnswer(Answers answer) {
        return answersRepository.saveAnswer(answer);
    }
    
}
