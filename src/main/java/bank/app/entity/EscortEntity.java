package bank.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class EscortEntity extends PersonEntity{
    private Double moneyBalance;
    private String workStatus;
    private Integer escortId;

    public void beginTransport(){}

    public void changeTransportStatus(){}

    public void endTransport(){}

}
