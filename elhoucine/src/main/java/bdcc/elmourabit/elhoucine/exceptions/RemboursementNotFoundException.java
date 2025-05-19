package bdcc.elmourabit.elhoucine.exceptions;

public class RemboursementNotFoundException extends Exception {

    private final String msg;
    public RemboursementNotFoundException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
