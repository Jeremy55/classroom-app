package fr.univlorraine.miage.revolutmiage.utils.infra.rest;

import fr.univlorraine.miage.revolutmiage.utils.domain.cmd.InputValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public abstract class DefaultResource {

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String, Map<String, String>> handleValidationExceptions(final ConstraintViolationException ex) {
        final Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach(error -> {
            final StringJoiner fieldName = new StringJoiner(".")
                    .add(ex.getMessage())
                    .add("validation")
                    .add(error.getPropertyPath().toString())
                    .add(error.getConstraintDescriptor().getAnnotation().annotationType().getSimpleName());
            final String errorMessage = error.getMessage();
            errors.put(fieldName.toString().toLowerCase(), errorMessage);
        });
        return new HashMap<>() {{
            put("problems", errors);
        }};
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(InputValidationException.class)
    public Map<String, Map<String, String>> handleValidationExceptions(final InputValidationException ex) {
        return new HashMap<>() {{
            put("problems", ex.getProblems());
        }};
    }
}
