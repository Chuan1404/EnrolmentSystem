/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controllers;

import com.java.pojos.Livestreams;
import com.java.pojos.Questions;
import com.java.pojos.Users;
import com.java.services.EmailService;
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
import org.springframework.web.bind.annotation.RequestParam;

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
    private EmailService emailService;
    
    
    
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
        Users user = userService.getUsersByUsername(principal.getName());
        Livestreams livestream = livestreamsService.getLiveStreamById(streamId);
        question.setUserId(user);
        question.setLivestreamId(livestream);
        
        if (questionService.addQuestion(question)) {
            String subject = "Câu hỏi mới từ livestream \"" + livestream.getTitle() + "";
            String content = "Bạn nhận được câu hỏi mới từ bạn " + user.getName()
                    + "\n đến xem câu hỏi tại đường link " 
                    + "http://localhost:8080/EnrolmentSystem/livestream/" 
                    + livestream.getId()+ "/questions";
            emailService.sendEmail(livestream.getUserId().getEmail(), subject, content);
            return "redirect:/livestream/";
        }
        return "redirect:/";
    }
    
    @GetMapping(value = "/{id}/questions")
    public String questions(@PathVariable("id") String id, Model model, @RequestParam(value = "page", required = false) Integer page) {
        List<Questions> questions = questionService.getQuestionsByLivestreamId(livestreamsService.getLiveStreamById(id));
        if (questions == null) {
            questions = new ArrayList<>();
        }
        model.addAttribute("questions", questions);
        model.addAttribute("pageLimit",Math.ceil(questions.size() / 25));
        model.addAttribute("activePage", page);
        return "livestream-questions";
    }
    
    
}
