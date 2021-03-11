package org.codejudge.sb.serviceImpl;

import java.util.List;

import org.codejudge.sb.model.Question;
import org.codejudge.sb.repository.QuestionRepository;
import org.codejudge.sb.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionRepository QuestionRepo;	
	
	@Override
	public Question createQuestion(Question Question) {
		Question response=QuestionRepo.save(Question);
		return response;
	}

	@Override
	public Question getQuestionBasedonID(int id	) {
		Question response=QuestionRepo.getOne(id);
		return response;
	}

	@Override
	public List<Question> getAllQuestionOfQuiz(int id) {
		List<Question> response=QuestionRepo.findByQuizId(id);
		return response;
	}
	

	

}
