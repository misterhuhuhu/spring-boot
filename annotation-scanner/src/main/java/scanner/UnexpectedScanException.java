package scanner;

public class UnexpectedScanException extends RuntimeException {
    public UnexpectedScanException(Throwable ex) {
        super(ex);
    }
}
