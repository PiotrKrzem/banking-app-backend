package bank.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EscortEntity {
    private Double moneyBalance;
    private String workStatus;
    private Integer escortId;

    public void beginTransport(){}

    public void changeTransportStatus(){}

    public void endTransport(){}

}
