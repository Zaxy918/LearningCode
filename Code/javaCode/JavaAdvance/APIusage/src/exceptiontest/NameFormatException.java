package exceptiontest;

public class NameFormatException extends RuntimeException {
    NameFormatException() {
    }

    NameFormatException(String message) {
        super(message);
    }
}
