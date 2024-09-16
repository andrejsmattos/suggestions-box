package br.org.sesisenai.suggestions.exceptions.notfound;

public class AnswerNotFound extends NotFoundException {

            public AnswerNotFound(Long id) {
                super("Answer: ", id);
            }

}
