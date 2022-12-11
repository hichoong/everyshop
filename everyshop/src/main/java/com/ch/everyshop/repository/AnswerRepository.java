package com.ch.everyshop.repository;

import com.ch.everyshop.domain.Answer;
import com.ch.everyshop.domain.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Page<Answer> findAllByQuestion(Question question, Pageable pageable);
}
