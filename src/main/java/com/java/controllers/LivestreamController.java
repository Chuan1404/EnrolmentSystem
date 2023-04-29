/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controllers;

import com.java.pojos.Answers;
import com.java.pojos.Livestreams;
import com.java.pojos.Questions;
import com.java.services.AnswersService;
import com.java.services.LivestreamsService;
import com.java.services.QuestionsService;
import com.java.services.UsersService;
import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author AnChuPC
 */
@Controller
@RequestMapping(value = "/livestream")
public class LivestreamController {
    
    @Autowired
    private LivestreamsService livestreamsService;
    
    @Autowired
    private UsersService userService;
    
    @Autowired
    private QuestionsService questionService;
    
    @Autowired
    private AnswersService answersService;
    
    @GetMapping(value = "/")
    public String index(Model model, Principal principal) {
        Map<String, String> params = new HashMap<>();
        
        LocalDate date = LocalDate.now();
        params.put("date", date.toString());
        
        List<Livestreams> livestreams = livestreamsService.getLivestreams(params);
        
        
        model.addAttribute("livestreams",livestreams);
        
        
        return "livestream";
    }
    
    @GetMapping(value = "/{id}")
    public String detail(Model model, @PathVariable(value = "id") String id) {
        model.addAttribute("livestream", livestreamsService.getLiveStreamById(id));
        model.addAttribute("question", new Questions());
        return "livestream-detail";
    }
    
    @PostMapping(value = "/{id}/question")
    public String addQuestion(@ModelAttribute Questions question, @PathVariable(value="id") String streamId,
            Principal principal) {
        question.setUserId(userService.getUsersByUsername(principal.getName()));
        question.setLivestreamId(livestreamsService.getLiveStreamById(streamId));
        if (questionService.addQuestion(question))
            return "redirect:/livestream/";
        return "redirect:/";
    }
    
    @GetMapping(value = "/{id}/questions")
    public String questions(@PathVariable("id") String id, Model model) {
        List<Questions> questions = questionService.getQuestionsByLivestreamId(livestreamsService.getLiveStreamById(id));
        if (questions == null) {
            questions = new ArrayList<>();
        }
        model.addAttribute("questions", questions);
        model.addAttribute("answer", new Answers());
        return "livestream-questions";
    }
    
    @GetMapping(value = "/{id}/questions/{questionId}/answer")
    public String answer(@PathVariable("id") String id, @PathVariable("questionId") String questionId, Model model, Principal principal) {
        List<Questions> questions = questionService.getQuestionsByLivestreamId(livestreamsService.getLiveStreamById(id));
        if (questions == null) {
            questions = new ArrayList<>();
        }
        Questions question = questionService.getQuestionById(Integer.parseInt(questionId));
        Answers answer = new Answers();
        answer.setLivestreamId(livestreamsService.getLiveStreamById(id));
        answer.setQuestionId(question);
        answer.setUserId(userService.getUsersByUsername(principal.getName()));
        model.addAttribute("questions", questions);
        model.addAttribute("answer", answer);
        
        return "livestream-questions";
        
    }
    
    @PostMapping(value = "/answer")
    public String answer(@ModelAttribute("answer") Answers answer) {
        
        if (answersService.saveAnswer(answer)) {
            return "redirect:/livestream";
        }
        return "redirect:/";
    }
}
