package com.ch.everyshop.repository;

import com.ch.everyshop.domain.Question;
import com.ch.everyshop.service.QuestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)

public class QuestionTest {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionService questionService;

    @Test
    public void 값_들어가는지_확인() {
        Question q1 = new Question();
        q1.setSubject("제목이에여");
        q1.setContent("이건 내용이구요");
        q1.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q1);

        Question q2 = new Question();
        q2.setSubject("제목이에여 22222");
        q2.setContent("이건 내용이구요22222");
        q2.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q2);
    }

    @Test
    public void 모두찾기() {
        List<Question> all = this.questionRepository.findAll();
        assertEquals(2, all.size());

        Question q = all.get(0);
        assertEquals("제목이에여", q.getSubject());
    }

    @Test
   public void ID를_이용해서_찾기() {
        Optional<Question> oq = this.questionRepository.findById(1L);
        if(oq.isPresent()) {
            Question q = oq.get();
            assertEquals("제목이에여", q.getSubject());
        }
    }

    @Test
    public void 제목을_이용해서_찾기() {
        Question q = this.questionRepository.findBySubject("제목이에여 22222");
        assertEquals( "이건 내용이구요22222" ,q.getContent());
    }

    @Test
    public void 수정하기() {
        Optional<Question> oq = this.questionRepository.findById(1L);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        q.setSubject("수정된 제목");
        this.questionRepository.save(q);
    }

    @Test
    public void 삭제하기() {
        assertEquals(2, this.questionRepository.count());
        Optional<Question> oq = this.questionRepository.findById(1L);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        this.questionRepository.delete(q);
        assertEquals(1, this.questionRepository.count());
    }

    @Test
    public void 페이징을_위한_데이터() {
        for (int i = 1; i <= 300; i++) {
            String subject = String.format("테스트 데이터입니다:[%03d]", i);
            String content = "내용무";
            this.questionService.createQuestion(subject, content);
        }
    }


}