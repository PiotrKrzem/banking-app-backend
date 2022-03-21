package bank.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransportEntity {
    private Double moneyInPaper;
    private Integer escortId;
    private String transportStatus;
    private Double transportPrice;
    private Integer originAgency;
    private Integer destinationAgency;
}
