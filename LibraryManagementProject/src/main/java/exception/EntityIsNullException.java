package exception;

public class EntityIsNullException extends RuntimeException{
    public EntityIsNullException(String msg){
        super(msg);
    }
}
