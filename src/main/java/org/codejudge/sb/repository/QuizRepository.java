package org.codejudge.sb.repository;

import org.springframework.stereotype.Repository;
import org.codejudge.sb.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer>  {

}
 