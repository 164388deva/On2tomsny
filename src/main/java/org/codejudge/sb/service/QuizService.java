package org.codejudge.sb.service;

import org.codejudge.sb.model.Quiz;


public interface QuizService {

	public Quiz createQuiz(Quiz quiz);
	public Quiz getQuizBasedonID(int id);

}
