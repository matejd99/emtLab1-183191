package mk.ukim.finki.emt.emtlab.exception;


public class invalidAuthorException extends RuntimeException{

    public invalidAuthorException() {
        super("Invalid author id");
    }
}
