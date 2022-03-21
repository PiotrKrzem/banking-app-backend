
package bank.app.api.error_handler.errors;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ObjectNotFoundException extends RuntimeException implements Supplier<ObjectNotFoundException> {
    public static final String PARAMETERS = "id";

    private Map<String, Object> parameters = new HashMap<>();
    private final String detail;

    public ObjectNotFoundException(String message, String why, Map<String, Object> parameters) {
        super(message);
        this.detail = why;
        this.parameters = parameters;
    }

    public static ObjectNotFoundException clientNotFound(String why, String id){
        return new ObjectNotFoundException("Client not found", why, Map.of(PARAMETERS, id));
    }

    public static ObjectNotFoundException loanNotFOund(String why, String id){
        return new ObjectNotFoundException("Loan not found", why, Map.of(PARAMETERS, id));
    }

    public static ObjectNotFoundException depositNotFOund(String why, String id){
        return new ObjectNotFoundException("Deposit not found", why, Map.of(PARAMETERS, id));
    }

    public static ObjectNotFoundException employeeNotFound(String why, String id){
        return new ObjectNotFoundException("Employee not found", why, Map.of(PARAMETERS, id));
    }

    public static ObjectNotFoundException escortNotFound(String why, String id){
        return new ObjectNotFoundException("Escort not found", why, Map.of(PARAMETERS, id));
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    @Override
    public ObjectNotFoundException get() {
        return this;
    }

    public String getDetail() {
        return detail;
    }
}