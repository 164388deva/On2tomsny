package org.codejudge.sb.serviceImpl;

import org.codejudge.sb.model.Quiz;
import org.codejudge.sb.repository.QuizRepository;
import org.codejudge.sb.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	QuizRepository quizRepo;	
	
	@Override
	public Quiz createQuiz(Quiz quiz) {
		Quiz response=quizRepo.save(quiz);
		return response;
	}

	@Override
	public Quiz getQuizBasedonID(int id	) {
		Quiz response=quizRepo.getOne(id);
		return response;
	}

	


}
