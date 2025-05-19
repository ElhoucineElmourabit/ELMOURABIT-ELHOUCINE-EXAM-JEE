package bdcc.elmourabit.elhoucine.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RemboursementNotFoundException extends Exception {

    private final String msg;
    public RemboursementNotFoundException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
