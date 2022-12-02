package com.ch.everyshop.repository;

import com.ch.everyshop.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Questionrepository extends JpaRepository<Question, Long> {
    Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject, String content);
}
