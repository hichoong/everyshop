package com.ch.everyshop.controller;

import com.ch.everyshop.domain.Question;
import com.ch.everyshop.repository.AnswerRepository;
import com.ch.everyshop.repository.QuestionRepository;
import com.ch.everyshop.service.AnswerService;
import com.ch.everyshop.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;
    private final QuestionService questionService;
    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Long id, @RequestParam String content) {
        Question question = questionService.getQuestion(id);
        answerService.saveAnswer(question, content);
        return String.format("redirect:/question/detail/%s", id);
    }
}
