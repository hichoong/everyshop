package com.ch.everyshop.controller;

import com.ch.everyshop.domain.AnswerForm;
import com.ch.everyshop.domain.Question;
import com.ch.everyshop.repository.AnswerRepository;
import com.ch.everyshop.repository.QuestionRepository;
import com.ch.everyshop.service.AnswerService;
import com.ch.everyshop.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;
    private final QuestionService questionService;
    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Long id, @Valid AnswerForm answerForm, BindingResult bindingResult)  {
        Question question = questionService.getQuestion(id);
        if (bindingResult.hasErrors()) {
            model.addAttribute("question", question);
            return "question_detail";
        }
        answerService.saveAnswer(question, answerForm.getContent());
        return String.format("redirect:/question/detail/%s", id);
    }
}
