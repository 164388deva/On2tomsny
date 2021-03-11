package org.codejudge.sb.controller;

import org.codejudge.sb.model.Question;
import org.codejudge.sb.model.Quiz;
import org.codejudge.sb.service.QuestionService;
import org.codejudge.sb.service.QuizService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping
public class AppController {
	
	@Autowired
	QuizService quizService;
	
	@Autowired
	QuestionService questionService;
    
	Logger log= LoggerFactory.getLogger(AppController.class); 
	@ApiOperation("This api used for creating a Quiz")
    @PostMapping("/api/quiz/")
    public ResponseEntity<Object> createQuiz(@RequestBody Quiz quiz) {
		log.info("creating quiz: "+quiz.getName());
		Quiz response=quizService.createQuiz(quiz);
    	
		if(response.equals(null)) {
			log.info("creating quiz: "+quiz.getName() + " failed");

			return new ResponseEntity<>(new Quiz(),HttpStatus.BAD_REQUEST);
		}
    	return new ResponseEntity<>(response,HttpStatus.CREATED);
        
    }
	@ApiOperation("This api used for creating a Question")
    @PostMapping("/api/questions/")
    public ResponseEntity<Object> createQuestion(@RequestBody Question question) {
		log.info("creating quiz: "+question.getName());

		Question response=questionService.createQuestion(question);
    	
		if(response.equals(null)) {
			log.info("creating Question: "+question.getName() + " failed");

			return new ResponseEntity<>(new Question(),HttpStatus.BAD_REQUEST);
		}
    	return new ResponseEntity<>(response,HttpStatus.CREATED);
        
    }
	@ApiOperation("This api used for fetching a question based on ID")
	 @GetMapping("/api/questions/{questionId}")
	    public ResponseEntity<Object> getQuestionById(@PathVariable int questionId) {
		log.info("fetching question with ID: "+questionId);
	
			Question response=questionService.getQuestionBasedonID(questionId);
	    	
			if(response.equals(null)) {
				log.info("fetching question with ID: "+questionId +" not found");

				return new ResponseEntity<>(new Question(),HttpStatus.NOT_FOUND);
			}
	    	return new ResponseEntity<>(response,HttpStatus.OK);
	        
	    }
	 
	@ApiOperation("This api used for fetching a quiz based on ID")
	 @GetMapping("/api/quiz/{quizId}")
	    public ResponseEntity<Object> getQuizById(@PathVariable int quizId) {
		log.info("fetching quiz with ID: "+quizId);
	
			Quiz response=quizService.getQuizBasedonID(quizId);
	    	
			if(response.equals(null)) {
				log.info(" quiz with ID: "+quizId +" not found");

				return new ResponseEntity<>(new Quiz(),HttpStatus.NOT_FOUND);
			}
	    	return new ResponseEntity<>(response,HttpStatus.OK);
	        
	    }
	 
	@ApiOperation("This api used for fetching a questions based on quizID")
	 @GetMapping("/api/quiz-questions/{quizId}")
	    public ResponseEntity<Object> getQuestionsByquizId(@PathVariable int quizId) {
		log.info("fetching questions with quiz  ID: "+quizId );
		
			Quiz response=quizService.getQuizBasedonID(quizId);
	    	
			if(response.equals(null)) {
				log.info("questions quiz  ID: "+quizId +" not found");

				return new ResponseEntity<>(new Quiz(),HttpStatus.NOT_FOUND);
			}
	    	return new ResponseEntity<>(response,HttpStatus.OK);
	        
	    }
	 
	
	
}
