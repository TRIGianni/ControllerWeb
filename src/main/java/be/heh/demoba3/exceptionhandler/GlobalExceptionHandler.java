package be.heh.demoba3.exceptionhandler;

import be.heh.demoba3.web.ConstraintViolation;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice("be.heh.demoba3")
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        ProblemDetail validationProblemDetail =
                ProblemDetail.forStatusAndDetail(BAD_REQUEST, "Validation error");

        List<ConstraintViolation> errors = exception.getFieldErrors()
                .stream()
                .map(violation -> ConstraintViolation.builder()
                        .message(violation.getDefaultMessage())
                        .fieldName(violation.getField())
                        .rejectedValue(Objects.isNull(
                                violation.getRejectedValue()) ?
                                "null":
                                violation.getRejectedValue().toString())
                        .build())
                .collect(Collectors.toList());

        validationProblemDetail.setProperty("errors", errors);
        return validationProblemDetail;
    }
}
