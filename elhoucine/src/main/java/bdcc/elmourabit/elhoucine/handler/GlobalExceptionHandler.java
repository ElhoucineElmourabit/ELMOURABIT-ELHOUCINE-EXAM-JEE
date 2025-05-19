package bdcc.elmourabit.elhoucine.handler;

import bdcc.elmourabit.elhoucine.exceptions.ClientNotFoundException;
import bdcc.elmourabit.elhoucine.exceptions.CreditNotFoundException;
import bdcc.elmourabit.elhoucine.exceptions.RemboursementNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<String> handle(ClientNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    @ExceptionHandler(RemboursementNotFoundException.class)
    public ResponseEntity<String> handle(RemboursementNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    @ExceptionHandler(CreditNotFoundException.class)
    public ResponseEntity<String> handle(CreditNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
