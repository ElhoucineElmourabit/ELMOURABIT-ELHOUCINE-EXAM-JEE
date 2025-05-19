package bdcc.elmourabit.elhoucine.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CreditNotFoundException extends Exception {

    private final String msg;
    public CreditNotFoundException(String msg) {
        super(msg);
        this.msg = msg;
    }
}