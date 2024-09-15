package br.org.sesisenai.suggestions.repositories;


import br.org.sesisenai.suggestions.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
