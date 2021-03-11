package org.codejudge.sb.service;

import java.util.List;

import org.codejudge.sb.model.Question;


public interface QuestionService {

public Question createQuestion(Question question);
public Question getQuestionBasedonID(int id);
List<Question> getAllQuestionOfQuiz(int id);

}
