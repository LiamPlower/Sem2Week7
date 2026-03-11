package ie.atu.week7solution.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String >> handleValidation(MethodArgumentNotValidException){

        Map<String,String> errors = new HashMap<>();

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ReservationConflictException.class)
    public ResponseEntity<Map<String, String >> handleConflict(ReservationConflict ex){


        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);


}
