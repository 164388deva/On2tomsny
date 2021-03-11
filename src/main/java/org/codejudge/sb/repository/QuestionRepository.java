package org.codejudge.sb.repository;

import java.util.List;

import org.codejudge.sb.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>  {

	List<Question> findByQuizId(int id);

}
