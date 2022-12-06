package com.ch.everyshop.service;

import com.ch.everyshop.domain.Answer;
import com.ch.everyshop.domain.Question;
import com.ch.everyshop.domain.SiteUser;
import com.ch.everyshop.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;

    public void saveAnswer(Question question, String content,  SiteUser author) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        answer.setAuthor(author);
        answerRepository.save(answer);
    }
}
