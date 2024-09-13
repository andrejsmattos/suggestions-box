package br.org.sesisenai.suggestions.repositories;

import br.org.sesisenai.suggestions.entities.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {

}