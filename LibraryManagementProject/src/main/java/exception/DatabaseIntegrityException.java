package exception;

public class DatabaseIntegrityException extends RuntimeException{
    public DatabaseIntegrityException(String msg){
        super(msg);
    }
}
