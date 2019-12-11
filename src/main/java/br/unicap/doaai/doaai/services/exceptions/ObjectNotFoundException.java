package br.unicap.doaai.doaai.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {
    public static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String id, String classe) {
        super("Objeto não encontrado! Id: " + id + ", Tipo: " + classe);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}