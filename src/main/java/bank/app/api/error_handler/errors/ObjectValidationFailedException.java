
package bank.app.api.error_handler.errors;

import bank.app.entity.ClientEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ObjectValidationFailedException extends RuntimeException implements Supplier<ObjectValidationFailedException> {
    public static final String PARAMETERS = "object";

    private Map<String, Object> parameters = new HashMap<>();
    private final String detail;

    public ObjectValidationFailedException(String message, String why, Map<String, Object> parameters) {
        super(message);
        this.detail = why;
        this.parameters = parameters;
    }

    public static ObjectValidationFailedException clientValidationFailed(String why, ClientEntity client){
        return new ObjectValidationFailedException("Client validation failed", why, Map.of(PARAMETERS, client));
    }

    public static ObjectValidationFailedException loanValidationFailed(String why, String id){
        return new ObjectValidationFailedException("Loan validation failed", why, Map.of(PARAMETERS, id));
    }

    public static ObjectValidationFailedException depositValidationFailed(String why, String id){
        return new ObjectValidationFailedException("Deposit validation failed", why, Map.of(PARAMETERS, id));
    }

    public static ObjectValidationFailedException employeeValidationFailed(String why, String id){
        return new ObjectValidationFailedException("Employee validation failed", why, Map.of(PARAMETERS, id));
    }

    public static ObjectValidationFailedException escortValidationFailed(String why, String id){
        return new ObjectValidationFailedException("Escort validation failed", why, Map.of(PARAMETERS, id));
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    @Override
    public ObjectValidationFailedException get() {
        return this;
    }

    public String getDetail() {
        return detail;
    }
}