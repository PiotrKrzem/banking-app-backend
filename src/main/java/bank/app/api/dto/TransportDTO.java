package bank.app.api.dto;

import lombok.Data;

@Data
public class TransportDTO {
    private Double moneyInPaper;
    private Integer escortId;
    private String transportStatus;
    private Double transportPrice;
    private Integer originAgency;
    private Integer destinationAgency;
}
