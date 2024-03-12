package jtm.activity08;

public class SimpleCalcException extends Exception {

    private static final long serialVersionUID = 5314968337642461176L;

    public SimpleCalcException(String message) {
        super(message);
    }

    public SimpleCalcException(String message, Throwable cause) {
        super(message, cause);
    }
}
