package labs.exception;

public class InvalidRoomsCountException extends IndexOutOfBoundsException{
    public InvalidRoomsCountException(String s) {
        super(s);
    }
}
