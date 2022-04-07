package bank.app.entity;

import bank.app.api.dto.ServerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class CeoEntity extends EmployeeEntity{
    private ServerDTO server;

    public void changeSalary(){

    }

    public void changeInnerFees(){

    }

    public void changeReferenceTaxes(){

    }

    public void changeReserveRequirements(){

    }

    public void fireEmployee(){

    }
}
