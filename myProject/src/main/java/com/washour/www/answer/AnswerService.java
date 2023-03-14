package com.washour.www.answer;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.washour.www.member.Member;
import com.washour.www.qeustion.Question;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AnswerService {

	private final AnswerRepository answerRepository;


    public void create(Question question, String content, Member author) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setAuthor(author);
        answer.setQuestion(question);
        this.answerRepository.save(answer);
    }
	
}
