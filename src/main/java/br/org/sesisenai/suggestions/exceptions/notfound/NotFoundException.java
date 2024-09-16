package br.org.sesisenai.suggestions.exceptions.notfound;

public abstract class NotFoundException extends RuntimeException {

    public NotFoundException(String entityName, Long id) {
        super(entityName + " not found with id: " + id);
    }

//        public NotFoundException(String message) {
//            super(message);
//        }
//
//        public NotFoundException(String message, Throwable cause) {
//            super(message, cause);
//        }
}
