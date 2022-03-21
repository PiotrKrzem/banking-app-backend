
package bank.app.api.error_handler.errors;

import java.util.function.Supplier;

public class AccessForbiddenException extends RuntimeException implements Supplier<AccessForbiddenException> {

    private final String detail;

    public AccessForbiddenException(String message, String why) {
        super(message);
        this.detail = why;
    }


    public static AccessForbiddenException accessForbidden(String why){
        return new AccessForbiddenException("Access forbidden", why);
    }

    @Override
    public AccessForbiddenException get() {
        return this;
    }

    public String getDetail() {
        return detail;
    }
}