
package bank.app.api.error_handler;

import bank.app.api.error_handler.errors.AccessForbiddenException;
import bank.app.api.error_handler.errors.ObjectNotFoundException;
import bank.app.api.error_handler.errors.ObjectValidationFailedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import org.zalando.problem.spring.web.advice.ProblemHandling;

@Slf4j
@ControllerAdvice
public class ApplicationExceptionHandler implements ProblemHandling {

    private static final String PARAMETERS = "parameters";

    @ExceptionHandler(value = {AccessForbiddenException.class})
    public ResponseEntity<Problem> handleInvalidRequestException(AccessForbiddenException ex, NativeWebRequest request) {
        Problem prob = Problem.builder()
                .withStatus(Status.FORBIDDEN)
                .withTitle(ex.getLocalizedMessage())
                .withDetail(ex.getDetail())
                .build();
        return create(ex, prob, request);
    }

    @ExceptionHandler(value = {ObjectNotFoundException.class})
    public ResponseEntity<Problem> handleInvalidRequestException(ObjectNotFoundException ex, NativeWebRequest request) {
        Problem prob = Problem.builder()
                .withStatus(Status.NOT_FOUND)
                .withTitle(ex.getLocalizedMessage())
                .withDetail(ex.getDetail())
                .with(ObjectNotFoundException.PARAMETERS, ex.getParameters())
                .build();
        return create(ex, prob, request);
    }

    @ExceptionHandler(value = {ObjectValidationFailedException.class})
    public ResponseEntity<Problem> handleInvalidRequestException(ObjectValidationFailedException ex, NativeWebRequest request) {
        Problem prob = Problem.builder()
                .withStatus(Status.BAD_REQUEST)
                .withTitle(ex.getLocalizedMessage())
                .withDetail(ex.getDetail())
                .with(ObjectValidationFailedException.PARAMETERS, ex.getParameters())
                .build();
        return create(ex, prob, request);
    }
}
