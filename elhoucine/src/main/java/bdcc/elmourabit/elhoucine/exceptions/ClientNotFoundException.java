package bdcc.elmourabit.elhoucine.exceptions;


import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClientNotFoundException extends Exception {
    private final String msg;

    public ClientNotFoundException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
