package com.ch.everyshop.service;

import com.ch.everyshop.domain.Question;
import com.ch.everyshop.exception.DataNotFoundException;
import com.ch.everyshop.repository.Questionrepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final Questionrepository questionRepository;

    public List<Question> getList() {
        return this.questionRepository.findAll();
    }

    public Question getQuestion(Long id) {
        Optional<Question> question = questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("존재하지 않는 게시물입니다.");
        }
    }
}
