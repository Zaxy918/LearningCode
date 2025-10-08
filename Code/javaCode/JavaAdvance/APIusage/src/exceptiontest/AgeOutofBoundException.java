package exceptiontest;

public class AgeOutofBoundException extends RuntimeException {
    AgeOutofBoundException() {

    }

    AgeOutofBoundException(String message) {
        super(message);
    }
}
