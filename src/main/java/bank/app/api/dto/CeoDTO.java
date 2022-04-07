package bank.app.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CeoDTO extends PersonDTO{
    private ServerDTO server;
}
