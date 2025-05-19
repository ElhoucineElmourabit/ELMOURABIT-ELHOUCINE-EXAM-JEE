package bdcc.elmourabit.elhoucine.exceptions;

public class CreditNotFoundException extends Exception {

    private final String msg;
    public CreditNotFoundException(String msg) {
        super(msg);
        this.msg = msg;
    }
}