package fr.univlorraine.miage.revolutmiage.utils.domain.cmd;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

@Service
@AllArgsConstructor
public abstract class DefaultValidater<INPUT> {
    protected String ENTITY_NAME;
    protected final Validator validator;

    public void validate(final INPUT input) {
        final Set<ConstraintViolation<INPUT>> violations = validator.validate(input);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(ENTITY_NAME, violations);
        }

        final Map<String, String> problems = customValidate(input);
        if (!problems.isEmpty()) {
            throw new InputValidationException(problems);
        }
    }

    protected abstract Map<String, String> customValidate(final INPUT input);

    public String key(final String attr, final String error) {
        return new StringJoiner(".").add(ENTITY_NAME).add("validation").add(attr).add(error).toString();
    }
}
