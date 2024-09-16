package br.org.sesisenai.suggestions.exceptions.notfound;

public class SuggestionNotFound extends NotFoundException {

        public SuggestionNotFound(Long id) {
            super("Suggestion", id);
        }

}
